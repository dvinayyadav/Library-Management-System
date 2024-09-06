package com.example.Library_Management_System1.Controllers;

import com.example.Library_Management_System1.DTO.RequestDTO.IsIssueRequestDto;
import com.example.Library_Management_System1.DTO.RequestDTO.IsReceivedRequestDto;
import com.example.Library_Management_System1.DTO.ResposeDTO.IsIssueResponseDto;
import com.example.Library_Management_System1.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {


    @Autowired
    TransactionService transactionService;
    @PutMapping("/isIssueBook")
    public IsIssueResponseDto issueBook(@RequestBody IsIssueRequestDto isIssueRequestDto)throws Exception{
        return transactionService.issueBook(isIssueRequestDto);
    }

    @PutMapping("/isReceived")
    public String isBookReceived(@RequestBody IsReceivedRequestDto isReceivedRequestDto){
        return transactionService.isBookReceived(isReceivedRequestDto);
    }


}
