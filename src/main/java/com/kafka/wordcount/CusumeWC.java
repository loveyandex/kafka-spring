package com.kafka.wordcount;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CusumeWC {

      private static final Logger log = LoggerFactory.getLogger(CusumeWC.class);

      public static void main(String[] args) {

            Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092");
            props.put("group.id", "CountryCounter");
            props.put("key.deserializer",
                        "org.apache.kafka.common.serialization.StringDeserializer");
            props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
            props.put("value.deserializer", LongDeserializer.class.getName());

            KafkaConsumer<String, Long> consumer = new KafkaConsumer<String, Long>(props);

            consumer.subscribe(Collections.singleton("WordsWithCountsTopic"));

            // poll for new data
            while (true) {
                  ConsumerRecords<String, Long> records = consumer.poll(Duration.ofMillis(100));

                  for (ConsumerRecord<String, Long> record : records) {
                        log.info("Key: " + record.key() + ", Value: " + record.value());
                        log.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                  }
            }

      }
}
