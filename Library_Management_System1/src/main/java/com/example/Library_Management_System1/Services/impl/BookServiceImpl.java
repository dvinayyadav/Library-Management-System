package com.example.Library_Management_System1.Services.impl;

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

        try{
            int   authorId= bookRequestDto.getAuthor().getId();
            Author author= authorRepository.findById(authorId).get();
            Book book=new Book();
            book.setGenre(bookRequestDto.getGenre());
            book.setTitle(bookRequestDto.getTitle());
            book.setPrice(bookRequestDto.getPrice());
            author.getList().add(book);
            book.setAuthor(author);
            authorRepository.save(author);

            return "Book added Via Author Body";
        }
        catch(Exception e){
            throw new Exception("Author not available in the DataBase");
        }


    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> list= bookRepository.findAll();
        List<BookResponseDto> ansList=new ArrayList<>();
        for(Book book:list){
            BookResponseDto bookResponseDto=new BookResponseDto();
            bookResponseDto.setAuthor(book.getAuthor());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDto.setTitle(book.getTitle());
            ansList.add(bookResponseDto);
        }
        return ansList;
    }
}
