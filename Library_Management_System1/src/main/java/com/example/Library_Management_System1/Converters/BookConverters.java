package com.example.Library_Management_System1.Converters;

import com.example.Library_Management_System1.DTO.RequestDTO.BookRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Book;

public class BookConverters {

public static BookResponseDto bookToBookResponseDto(Book book){

    return BookResponseDto.builder()
            .authorId(book.getAuthor().getId())
            .title(book.getTitle())
            .genre(book.getGenre())
            .build();
}

public static Book bookRequestDtoToBook(BookRequestDto bookRequestDto){

    return Book.builder()
            .genre(bookRequestDto.getGenre())
            .price(bookRequestDto.getPrice())
            .title(bookRequestDto.getTitle())
            .build();
}
}
