package com.kafka.kafkaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafkaspring.service.KafKaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
      private final KafKaProducerService producerService;

      @Autowired
      public KafkaProducerController(KafKaProducerService producerService) {
            this.producerService = producerService;
      }

      @PostMapping(value = "/publish")
      public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
            this.producerService.sendMessage(message);
      }

      @GetMapping(value = "/publish/{msg}")
      public void sendMessageToKafkaTopicGet(@PathVariable String msg) {
            this.producerService.sendMessage(msg);
      }

}