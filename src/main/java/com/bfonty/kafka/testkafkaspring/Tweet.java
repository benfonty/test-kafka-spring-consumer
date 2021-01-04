package com.bfonty.kafka.testkafkaspring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Tweet {
    private Long id;
    private String text;
}
