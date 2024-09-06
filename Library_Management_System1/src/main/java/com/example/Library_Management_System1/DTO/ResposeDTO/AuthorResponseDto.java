package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Entities.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AuthorResponseDto {

    private String name;


    private String email;


    private List<Book> list=new ArrayList<>();
}
