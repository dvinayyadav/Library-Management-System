package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.DTO.RequestDTO.IsIssueRequestDto;
import com.example.Library_Management_System1.DTO.RequestDTO.IsReceivedRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.IsIssueResponseDto;
import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Entities.Card;
import com.example.Library_Management_System1.Entities.Transaction;
import com.example.Library_Management_System1.Enum.CardStatus;
import com.example.Library_Management_System1.Enum.TransactionStatus;
import com.example.Library_Management_System1.Repositories.BookRepository;
import com.example.Library_Management_System1.Repositories.CardRepository;
import com.example.Library_Management_System1.Repositories.TransactionRepository;
import com.example.Library_Management_System1.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public IsIssueResponseDto issueBook(IsIssueRequestDto isIssueRequestDto) throws Exception {
        Transaction transaction=new Transaction();
        transaction.setIssue(true);
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        Card card;
        try{
            card=cardRepository.findById(isIssueRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("cardId NOT AVAILABLE");
        }
        transaction.setCard(card);
        Book book;
        try{
         book=bookRepository.findById(isIssueRequestDto.getBookId()).get();
        }
        catch(Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("bookId NOT AVAILABE");
        }
        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("CARD IS NOT IN ACTIVE");
        }

        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is Not Available");
        }
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookList().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);// card is parent for both transaction and book

        IsIssueResponseDto isIssueResponseDto=new IsIssueResponseDto();
        isIssueResponseDto.setBookName(book.getTitle());
        isIssueResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        isIssueResponseDto.setTransactionStatus(transaction.getTransactionStatus());
     return isIssueResponseDto;
    }

    @Override
    public String isBookReceived(IsReceivedRequestDto isReceivedRequestDto) {

        Card card= cardRepository.findById(isReceivedRequestDto.getCardId()).get();
        List<Transaction> list=card.getTransactionList();
        Transaction transaction = null;
        for(Transaction transaction1:list){
            if(transaction1.getId()==isReceivedRequestDto.getTransactionId()) {
               transaction=transaction1;
            }
        }
        list.remove(transaction);
        transactionRepository.deleteById(isReceivedRequestDto.getTransactionId());
        card.setTransactionList(list);
        Book book=bookRepository.findById(isReceivedRequestDto.getBookId()).get();
        book.setIssued(false);

         cardRepository.save(card);
        return "Transaction Deleted And Book is not Available";
    }

}
