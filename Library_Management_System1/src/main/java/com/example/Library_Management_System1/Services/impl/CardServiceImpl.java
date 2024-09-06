package com.example.Library_Management_System1.Services.impl;

import com.example.Library_Management_System1.Entities.Card;
import com.example.Library_Management_System1.Repositories.CardRepository;
import com.example.Library_Management_System1.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }
}
