package com.example.Library_Management_System1.Services;

import com.example.Library_Management_System1.Entities.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardService {
    List<Card> getAll();
}
