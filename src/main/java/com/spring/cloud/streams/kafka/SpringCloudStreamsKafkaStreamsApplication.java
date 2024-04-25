package com.spring.cloud.streams.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@Slf4j
public class SpringCloudStreamsKafkaStreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamsKafkaStreamsApplication.class, args);
	}
	//https://blog.devgenius.io/spring-cloud-streams-kafka-streams-binder-and-publishing-to-multiple-topics-7a3cc9a374b7
	//https://github.com/spring-cloud/spring-cloud-stream-binder-kafka/issues/793


	@Bean
	public Function<KStream<String, String>, KStream<String, String>> upperCaseProcessor(){
		return stringStringKStream -> stringStringKStream
				.mapValues((ValueMapper<String, String>) String::toUpperCase);
	}

}
