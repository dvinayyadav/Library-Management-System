package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.Converters.BookConverters;
import com.example.Library_Management_System1.Converters.CardConverter;
import com.example.Library_Management_System1.Converters.TransactionConverters;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.CardResponseDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.IsIssueResponseDto;
import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Entities.Card;
import com.example.Library_Management_System1.Entities.Transaction;
import com.example.Library_Management_System1.Repositories.CardRepository;
import com.example.Library_Management_System1.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<CardResponseDto> getAll() {

        List<Card> cardList=cardRepository.findAll();

        List<CardResponseDto> cardResponseDtoList=new ArrayList<>();
        for(Card card:cardList){
            CardResponseDto cardResponseDto= CardConverter.cardToCardResponseDto(card);
            List<Book> bookList=card.getBookList();
            List<BookResponseDto> bookResponseDtoList=new ArrayList<>();
            for(Book book:bookList){
                bookResponseDtoList.add(BookConverters.bookToBookResponseDto(book));
            }
            cardResponseDto.setBookList(bookResponseDtoList);
            List<Transaction> transactionList=card.getTransactionList();
            List<IsIssueResponseDto> isIssueResponseDtoList=new ArrayList<>();
            for(Transaction transaction:transactionList){
                isIssueResponseDtoList.add(TransactionConverters.TransactionToIsissueDto(transaction));
            }
            cardResponseDto.setTransactionList(isIssueResponseDtoList);
            cardResponseDtoList.add(cardResponseDto);
        }
        return cardResponseDtoList;
    }

}
