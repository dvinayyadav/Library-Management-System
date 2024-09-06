package com.example.Library_Management_System1.Services;

import com.example.Library_Management_System1.DTO.RequestDTO.StudentRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.StudentResponseDto;
import com.example.Library_Management_System1.Entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {
    String addStudent(StudentRequestDto studentRequestDto);

    String delStudentById(int id);

    StudentResponseDto getStudentById(int id);

    StudentResponseDto getStudentByMobile(String mobileNo);

    String updateStudent(int id, String mobileNo) throws Exception;

    List<StudentResponseDto> getAllStudenst();
}
