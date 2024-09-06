package com.example.Library_Management_System1.DTO.RequestDTO;

import com.example.Library_Management_System1.Entities.Book;
import com.example.Library_Management_System1.Entities.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IsReceivedRequestDto {

    private int transactionId;

    private int cardId;

    private int bookId;
}
