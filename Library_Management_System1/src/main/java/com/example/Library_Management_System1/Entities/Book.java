package com.example.Library_Management_System1.Entities;

import com.example.Library_Management_System1.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int price;

    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Author author;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Card card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Transaction> transactionList=new ArrayList<>();
}
