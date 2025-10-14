package myPacket.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic("request", 1, (short) 1);
    }
}
