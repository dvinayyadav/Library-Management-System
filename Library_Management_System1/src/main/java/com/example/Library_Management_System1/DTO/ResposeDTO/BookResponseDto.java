package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDto {


    private String title;

    private Genre genre;

    private Author author;
}
