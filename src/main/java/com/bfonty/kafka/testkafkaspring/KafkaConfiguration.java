package com.bfonty.kafka.testkafkaspring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="kafka")
@Getter
@Setter
public class KafkaConfiguration {
    private String bootstrap;
    private String groupid;
}
