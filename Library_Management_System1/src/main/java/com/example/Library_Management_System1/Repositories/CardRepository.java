package com.example.Library_Management_System1.Repositories;

import com.example.Library_Management_System1.Entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
