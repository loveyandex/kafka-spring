package com.kafka.kafkaspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class Producer {

      @GetMapping("/{prdouce}")
      public String GEt(@PathVariable String prdouce) {
            return prdouce;

      }

}
