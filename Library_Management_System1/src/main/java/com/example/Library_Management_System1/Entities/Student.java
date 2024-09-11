package com.example.Library_Management_System1.Entities;


import com.example.Library_Management_System1.Enum.Department;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="student_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(unique = true)
    private String mobileNo;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
   private Card card;
}
