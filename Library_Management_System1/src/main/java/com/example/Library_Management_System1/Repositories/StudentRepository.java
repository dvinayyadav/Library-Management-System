package com.example.Library_Management_System1.Repositories;

import com.example.Library_Management_System1.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByMobileNo(String mobileNo);
}
