package com.example.Library_Management_System1.Entities;

import com.example.Library_Management_System1.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CurrentTimestamp
    private Date issueDate;

    private String validTill;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    @JsonBackReference
    private Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactionList=new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Book> bookList=new ArrayList<>();

}
