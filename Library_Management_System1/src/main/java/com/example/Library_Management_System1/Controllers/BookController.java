package com.example.Library_Management_System1.Controllers;

import com.example.Library_Management_System1.DTO.RequestDTO.BookRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto)throws Exception{
        return bookService.addBook(bookRequestDto);
    }

    @GetMapping("/getAllBooks")
    public List<BookResponseDto> getAllAuthors(){
        return bookService.getAllBooks();
    }
}
