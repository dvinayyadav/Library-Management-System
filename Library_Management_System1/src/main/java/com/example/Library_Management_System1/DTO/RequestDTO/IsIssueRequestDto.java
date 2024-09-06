package com.example.Library_Management_System1.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IsIssueRequestDto {
    private int cardId;

    private int bookId;
}
