package com.example.Library_Management_System1.Repositories;

import com.example.Library_Management_System1.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(Book bookId);
}
