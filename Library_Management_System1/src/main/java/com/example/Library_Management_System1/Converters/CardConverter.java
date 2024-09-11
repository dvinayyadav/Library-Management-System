package com.example.Library_Management_System1.Converters;

import com.example.Library_Management_System1.DTO.ResposeDTO.CardResponseDto;
import com.example.Library_Management_System1.Entities.Card;

public class CardConverter {

    public static CardResponseDto cardToCardResponseDto(Card card){
       return  CardResponseDto.builder()
                .cardStatus(card.getCardStatus())
                .issueDate(card.getIssueDate())
                .studentId(card.getStudent().getId())
                .validTill(card.getValidTill())
                .build();
    }
}
