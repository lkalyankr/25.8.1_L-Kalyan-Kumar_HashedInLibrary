package com.example.EmailNotificationService;

import com.example.EmailNotificationService.DTO.OverDueDtlsDTO;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;


public class OverDueBookKafkaConsumer {

    @KafkaListener(topics = "Due-Users-EmailId", groupId = "overdue-book-group")
    public void consume(List<OverDueDtlsDTO> overDueDtlsDTOS){

    }
}
