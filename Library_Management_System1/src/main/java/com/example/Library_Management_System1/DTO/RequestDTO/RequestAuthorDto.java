package com.example.Library_Management_System1.DTO.RequestDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestAuthorDto {

    private String name;

    private String email;

    private int age;

    private String qualification;
}
