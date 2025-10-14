package myPacket.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import myPacket.dto.RequestDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String > kafkaTemplate;

    public KafkaProducer(ObjectMapper objectMapper, KafkaTemplate<String, String > kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RequestDTO requestDTO) throws JsonProcessingException {
            String jsonMessage = objectMapper.writeValueAsString(requestDTO);
            kafkaTemplate.send("request", jsonMessage);
    }
}