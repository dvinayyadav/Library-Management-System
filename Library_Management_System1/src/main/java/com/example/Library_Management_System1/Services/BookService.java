package com.example.Library_Management_System1.Services;

import com.example.Library_Management_System1.DTO.RequestDTO.BookRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    String addBook(BookRequestDto book) throws Exception;


    List<BookResponseDto> getAllBooks();
}
