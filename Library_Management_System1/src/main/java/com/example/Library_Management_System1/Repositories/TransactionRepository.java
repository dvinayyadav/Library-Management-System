package com.example.Library_Management_System1.Repositories;

import com.example.Library_Management_System1.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
