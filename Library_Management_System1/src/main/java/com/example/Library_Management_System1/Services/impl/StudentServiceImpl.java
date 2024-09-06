package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.DTO.RequestDTO.StudentRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.StudentResponseDto;
import com.example.Library_Management_System1.Entities.Card;
import com.example.Library_Management_System1.Entities.Student;
import com.example.Library_Management_System1.Repositories.StudentRepository;
import com.example.Library_Management_System1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.Library_Management_System1.Enum.CardStatus.ACTIVATED;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobileNo(studentRequestDto.getMobileNo());

        Card card=new Card();
        card.setIssueDate(new Date());
        card.setCardStatus(ACTIVATED);
        card.setValidTill("2027-12-31");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "STUDENT ADDED SUCCESSFULLY";
    }

    @Override
    public String delStudentById(int id) {
        studentRepository.deleteById(id);
        return "STUDENT DELETED SUCCESSFULLY";
    }

    @Override
    public StudentResponseDto getStudentById(int id) {

        StudentResponseDto studentResponseDto=new StudentResponseDto();
        Student student=studentRepository.findById(id).get();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMobileNo(student.getMobileNo());

        return studentResponseDto;
    }

    @Override
    public StudentResponseDto getStudentByMobile(String mobileNo) {
       Student student=studentRepository.findByMobileNo(mobileNo);
       StudentResponseDto studentResponseDto=new StudentResponseDto();
       studentResponseDto.setName(student.getName());
       studentResponseDto.setMobileNo(student.getMobileNo());
       return studentResponseDto;
    }

    @Override
    public String updateStudent(int id, String mobileNo) throws Exception {
        try {
            Student student = studentRepository.findById(id).get();
            student.setMobileNo(mobileNo);
            studentRepository.save(student);
            return "UPDATED SUCCESSFULLY";
        }
        catch (Exception e){
            throw new Exception("student Id not Available");
        }

    }

    @Override
    public List<StudentResponseDto> getAllStudenst() {
        List<Student> studentList=studentRepository.findAll();
        List<StudentResponseDto> list=new ArrayList<>();
        for(Student student:studentList){
            StudentResponseDto studentResponseDto=new StudentResponseDto();
            studentResponseDto.setName(student.getName());
            studentResponseDto.setMobileNo(student.getMobileNo());
            list.add(studentResponseDto);
        }
        return list;
    }
}
