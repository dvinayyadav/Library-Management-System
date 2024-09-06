package com.example.Library_Management_System1.DTO.RequestDTO;

import com.example.Library_Management_System1.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {

    private String name;

    private Department department;

    private String mobileNo;

}
