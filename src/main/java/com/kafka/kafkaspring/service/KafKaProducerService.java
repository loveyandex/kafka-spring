package com.kafka.kafkaspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {
      private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);

      public static final String TOPIC_NAME = "quickstart";

      @Autowired
      private KafkaTemplate<String, String> kafkaTemplate;

      public void sendMessage(String message) {
            logger.info(String.format("Message sent -> %s", message));
            this.kafkaTemplate.send(TOPIC_NAME, message);
      }
}