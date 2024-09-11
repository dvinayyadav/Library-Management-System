package com.example.Library_Management_System1.Converters;

import com.example.Library_Management_System1.DTO.ResposeDTO.IsIssueResponseDto;
import com.example.Library_Management_System1.Entities.Transaction;

public class TransactionConverters {

    public static IsIssueResponseDto TransactionToIsissueDto(Transaction transaction){
       return IsIssueResponseDto.builder()
                .transactionNumber(transaction.getTransactionNumber())
                .bookName(transaction.getBook().getTitle())
                .transactionStatus(transaction.getTransactionStatus())
                .build();
    }
}
