package com.example.Library_Management_System1.Controllers;

import com.example.Library_Management_System1.Entities.Card;
import com.example.Library_Management_System1.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;
    @GetMapping("/getAll")
    public List<Card> getAll(){
        return cardService.getAll();

    }

}
