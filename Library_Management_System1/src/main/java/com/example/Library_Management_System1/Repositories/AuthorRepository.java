package com.example.Library_Management_System1.Repositories;

import com.example.Library_Management_System1.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    
    public Author findByEmail(String name);

    Author findByName(String name);

    void deleteByName(String name);
}
