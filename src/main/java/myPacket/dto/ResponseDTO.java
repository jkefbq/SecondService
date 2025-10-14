package myPacket.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponseDTO {
    private String result;

    @Override
    public String toString() {
        return "{\n" +
                "\"result\": " + "\"" + result + "\"" +
                "\n}";
    }
}