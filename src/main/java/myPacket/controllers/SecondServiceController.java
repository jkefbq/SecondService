package myPacket.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import myPacket.dto.RequestDTO;
import myPacket.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SecondServiceController {

    @Autowired
    private RestTemplate restTemplate;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/kafka/send")
    public ResponseDTO getMessage(@RequestBody RequestDTO request) {
        String URL = "http://localhost:8080/processingRequest";
        return restTemplate.postForObject(URL, request, ResponseDTO.class);
    }
}
