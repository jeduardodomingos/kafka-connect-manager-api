package org.kafka.connector.manager.service;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class KafkaMetricsService {

    @Value("${kafka.boostrap.servers}")
    private String kafkaBootstrapServers;

    @Value("${kafka.consumer.group.id}")
    private String kafkaConsumerGroupId;

    @Value("${kafka.auto.commit.enabled}")
    private String kafkaAutoCommitEnabled;

    @Value("${kafka.key.deserializer}")
    private String kafkaKeyDeserializer;

    @Value("${kafka.value.deserializer}")
    private String kafkaValueDeserializer;

    private <K, V> KafkaConsumer<K, V> buildConsumer() {
        Properties consumerProperties = new Properties();

        consumerProperties.put("bootstrap.servers", this.kafkaBootstrapServers);
        consumerProperties.put("group.id", this.kafkaConsumerGroupId);
        consumerProperties.put("enable.auto.commit", this.kafkaAutoCommitEnabled);
        consumerProperties.put("kafka.key.deserializer", this.kafkaKeyDeserializer);
        consumerProperties.put("kafka.value.deserializer", this.kafkaValueDeserializer);

        return new KafkaConsumer<K, V>(consumerProperties);
    }

    public List<String > listKafkaTopics() {
        KafkaConsumer<String, String> consumer = this.buildConsumer();
        return new ArrayList<>(consumer.listTopics().keySet());
    }

}
