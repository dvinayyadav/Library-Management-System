package com.example.Library_Management_System1.Services;

import com.example.Library_Management_System1.DTO.RequestDTO.IsIssueRequestDto;
import com.example.Library_Management_System1.DTO.RequestDTO.IsReceivedRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.IsIssueResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    IsIssueResponseDto issueBook(IsIssueRequestDto isIssueRequestDto) throws Exception;

    String isBookReceived(IsReceivedRequestDto isReceivedRequestDto);
}
