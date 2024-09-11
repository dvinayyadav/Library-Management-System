package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Entities.Student;
import com.example.Library_Management_System1.Entities.Transaction;
import com.example.Library_Management_System1.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class CardResponseDto {

    private Date issueDate;

    private String validTill;


    private CardStatus cardStatus;


    private int studentId;

       private List<IsIssueResponseDto> transactionList=new ArrayList<>();


    private List<BookResponseDto> bookList=new ArrayList<>();
}
