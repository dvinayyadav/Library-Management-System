package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.Converters.BookConverters;
import com.example.Library_Management_System1.DTO.RequestDTO.BookRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Repositories.AuthorRepository;
import com.example.Library_Management_System1.Repositories.BookRepository;
import com.example.Library_Management_System1.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {
        Author author;
        try{

            author= authorRepository.findById(bookRequestDto.getAuthorId()).get();

        }
        catch(Exception e){
            throw new Exception("Author not available in the DataBase");
        }
        Book book= BookConverters.bookRequestDtoToBook(bookRequestDto);
        book.setIssued(false);
        book.setAuthor(author);
        author.getList().add(book);
        authorRepository.save(author);

        return "Book added Via Author Body";


    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> list= bookRepository.findAll();
        List<BookResponseDto> ansList=new ArrayList<>();
        for(Book book:list){
            ansList.add(BookConverters.bookToBookResponseDto(book));
        }
        return ansList;
    }
}
