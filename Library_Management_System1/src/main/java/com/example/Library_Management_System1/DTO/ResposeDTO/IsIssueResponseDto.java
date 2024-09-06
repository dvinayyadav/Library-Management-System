package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IsIssueResponseDto {

    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
