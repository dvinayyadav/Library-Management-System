package com.example.Library_Management_System1.Entities;

import com.example.Library_Management_System1.Enum.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String transactionNumber;

    @UpdateTimestamp
    private Date transactionDate;

    private boolean isIssue;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @JoinColumn
    @ManyToOne
    @JsonBackReference
    private Card card;

    @JoinColumn
    @ManyToOne
    @JsonBackReference
    private Book book;

}
