package com.example.Library_Management_System1.DTO.ResposeDTO;

import com.example.Library_Management_System1.Enum.TransactionStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class IsIssueResponseDto {

    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
