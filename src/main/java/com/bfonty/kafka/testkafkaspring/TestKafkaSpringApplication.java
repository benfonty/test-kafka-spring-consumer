package com.bfonty.kafka.testkafkaspring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.flogger.Flogger;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;

@SpringBootApplication
@Flogger
public class TestKafkaSpringApplication {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static void main(String[] args) {
        SpringApplication.run(TestKafkaSpringApplication.class, args);
    }

    @KafkaListener(topics = {"tweets"}, containerFactory = "myContainerFactory")
    public void listen(List<ConsumerRecord<Long, Tweet>> records, Acknowledgment acknowledgment) {
        log.atFine().log("reveived %d tweets", records.size());
        /*for (ConsumerRecord<Long, Tweet> record: records) {
            log.atFine().log("received tweet %d in partition %d", record.key(), record.partition());
        }*/
        acknowledgment.acknowledge();
    }


}

