package com.kafka.kafkaspring.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@AllArgsConstructor
@Component
public class KafkaProducer {
      
      private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);


      private final KafkaTemplate<String, String> kafkaTemplate;

      public void sendMessage(String message) {

            logger.info(String.format("input-topic Message sent -> %s", message));
            kafkaTemplate.send("input-topic", message);
      }
}