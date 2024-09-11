package com.example.Library_Management_System1.Converters;

import com.example.Library_Management_System1.DTO.RequestDTO.RequestAuthorDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.AuthorResponseDto;
import com.example.Library_Management_System1.Entities.Author;

public class AuthorConverters {

    public static Author RequestAuthorDtoToAuthor(RequestAuthorDto requestAuthorDto){
        return Author.builder()
                .name(requestAuthorDto.getName())
                .age(requestAuthorDto.getAge())
                .email(requestAuthorDto.getEmail())
                .qualification(requestAuthorDto.getQualification())
                .build();
    }

    public static AuthorResponseDto authorToAuthorResponseDto(Author author){
        return AuthorResponseDto.builder()
                .name(author.getName())
                .email(author.getEmail())
                .build();
    }

}
