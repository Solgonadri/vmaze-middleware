package com.jsolisg.vmaze_middelware;

import com.jsolisg.vmaze_middelware.config.TvMazeProperties;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.mongodb.autoconfigure.MongoAutoConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(TvMazeProperties.class)
public class VmazeMiddelwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmazeMiddelwareApplication.class, args);
	}

}
