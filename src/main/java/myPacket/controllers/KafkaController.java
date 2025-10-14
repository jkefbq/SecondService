package myPacket.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import myPacket.dto.RequestDTO;
import myPacket.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/kafka/send")
    public void send(@RequestBody RequestDTO requestDTO) throws JsonProcessingException {
        kafkaProducer.sendMessage(requestDTO);
    }
}
