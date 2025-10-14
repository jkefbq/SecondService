package myPacket.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import myPacket.dto.ResponseDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "response", groupId = "my_consumer")
    public void listen(String jsonMessage) throws JsonProcessingException {
        System.out.println();
        System.out.println("---------------- RESPONSE: ----------------");
        System.out.println(objectMapper.readValue(jsonMessage, ResponseDTO.class).toString());
        System.out.println("-------------------------------------------");
    }
}