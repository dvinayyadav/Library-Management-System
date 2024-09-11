package com.example.Library_Management_System1.DTO.RequestDTO;

import com.example.Library_Management_System1.Entities.Author;
import com.example.Library_Management_System1.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDto {
    String title;

    Genre genre;

    int price;

   int authorId;

}
