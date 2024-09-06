package com.example.Library_Management_System1.DTO.RequestDTO;

import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;

    private Genre genre;

    private int price;

    private Author author;

}
