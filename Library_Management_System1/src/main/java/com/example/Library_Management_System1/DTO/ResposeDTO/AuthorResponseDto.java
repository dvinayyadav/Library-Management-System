package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Entities.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class AuthorResponseDto {

    private String name;


    private String email;


    private List<BookResponseDto> list=new ArrayList<>();
}
