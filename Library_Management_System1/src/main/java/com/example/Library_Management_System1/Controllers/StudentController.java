package com.example.Library_Management_System1.Controllers;

import com.example.Library_Management_System1.DTO.RequestDTO.StudentRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.StudentResponseDto;
import com.example.Library_Management_System1.Entities.Student;
import com.example.Library_Management_System1.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @DeleteMapping("/del_student")
    public String delStudentById(@RequestParam("id") int id){
        return studentService.delStudentById(id);
    }

    @GetMapping("/get")
    public StudentResponseDto getStudentById(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get_via_mobileNo")
    public StudentResponseDto getStudentByMobile(@RequestParam("mobileNo") String mobileNo){
        return studentService.getStudentByMobile(mobileNo);
    }

    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id,@RequestParam("mobileNo") String mobileNo)throws Exception{
        return studentService.updateStudent(id,mobileNo);
    }

    @GetMapping("/allStudents")
    public List<StudentResponseDto> getAllStudents(){
       return  studentService.getAllStudenst();
    }
}
