package com.example.Library_Management_System1.Services;

import com.example.Library_Management_System1.DTO.RequestDTO.RequestAuthorDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.AuthorResponseDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

   String addAuthor(RequestAuthorDto requestAuthorDto);

    List<AuthorResponseDto> getAllAuthors();

    Author getAuthorById(int id);

    Author getAuthorByEmail(String email);

    List<BookResponseDto> getAllBooksByAuthor(String name);

    String delById(int id);

    String delByName(String name) throws Exception;

    String deleteAllAuthors();

    String updateAuthorEmail(int id, String email) throws Exception;
}
