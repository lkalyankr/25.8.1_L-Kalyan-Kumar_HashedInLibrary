package com.example.EmailNotificationService.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OverDueDtlsDTO {

    String name;

    String bookTitle;

    LocalDate EndDate;

    String email;
}
