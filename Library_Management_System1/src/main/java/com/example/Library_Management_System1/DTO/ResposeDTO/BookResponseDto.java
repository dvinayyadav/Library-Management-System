package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookResponseDto {


    String title;

    Genre genre;

     int authorId;
}
