package com.kafka.kafkaspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service; 
@Service
public class KafKaConsumerService 
{
    private static final String GROUP_ID = "groooo";
private static final String TOPIC_NAME = "quickstart";
private final Logger logger = 
            LoggerFactory.getLogger(KafKaConsumerService.class);
 
    @KafkaListener(topics =GROUP_ID ,  groupId = GROUP_ID)
    public void consume(String message) 
    {
        logger.info(String.format("Message recieved -> %s", message));
    }
}