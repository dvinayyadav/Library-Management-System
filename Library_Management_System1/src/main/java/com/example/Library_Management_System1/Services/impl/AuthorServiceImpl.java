package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.Converters.AuthorConverters;
import com.example.Library_Management_System1.Converters.BookConverters;
import com.example.Library_Management_System1.DTO.RequestDTO.RequestAuthorDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.AuthorResponseDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.BookResponseDto;
import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Repositories.AuthorRepository;
import com.example.Library_Management_System1.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(RequestAuthorDto requestAuthorDto) {

        Author author= AuthorConverters.RequestAuthorDtoToAuthor(requestAuthorDto);
        authorRepository.save(author);
        return "Author ADDED SECCUSSFULLY ADDED";
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        List<Author> list=authorRepository.findAll();
        List<AuthorResponseDto> list1=new ArrayList<>();
        for(Author author:list){

            list1.add(AuthorConverters.authorToAuthorResponseDto(author));
        }
        return list1;
    }

    @Override
    public AuthorResponseDto getAuthorById(int id) {
        Author author=authorRepository.findById(id).get();
        List<BookResponseDto> bookResponseDtoList=new ArrayList<>();
        for(Book book:author.getList()){
            bookResponseDtoList.add(BookConverters.bookToBookResponseDto(book));
        }
        AuthorResponseDto authorResponseDto=AuthorConverters.authorToAuthorResponseDto(author);
        authorResponseDto.setList(bookResponseDtoList);
        return authorResponseDto;
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {
        Author author=authorRepository.findByEmail(email);
        return AuthorConverters.authorToAuthorResponseDto(author);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
    @Override
    public List<BookResponseDto> getAllBooksByAuthor(String name) {
      Author author=authorRepository.findByName(name);
      List<Book> list=author.getList();
      List<BookResponseDto> list1=new ArrayList<>();
      for(Book book:list){
          list1.add(BookConverters.bookToBookResponseDto(book));
      }
      return list1;
    }

    @Override
    public String delById(int id) {
        authorRepository.deleteById(id);
        return "Author removed Successfully";
    }

    @Override
    public String delByName(String name)throws Exception {
        try {
            authorRepository.deleteByName(name);
            return "Author removed Successfully";
        }
        catch(Exception e){
            throw new Exception("AUTHOR NOT EXIST");
        }
    }

    @Override
    public String deleteAllAuthors() {
        authorRepository.deleteAll();
        return "All Authors Deleted from the DataBase";
    }

    @Override
    public String updateAuthorEmail(int id, String email) throws Exception{
        try{
            Author author=authorRepository.findById(id).get();
            author.setEmail(email);
            authorRepository.save(author);
            return "UpdatedSuccessfully";
        }
        catch (Exception e){
            throw new Exception("ID NOT PRESENT IN DATABASE");
        }

    }
}
