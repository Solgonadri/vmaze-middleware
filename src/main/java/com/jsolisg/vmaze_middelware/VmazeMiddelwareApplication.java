package com.jsolisg.vmaze_middelware;

import com.jsolisg.vmaze_middelware.config.TvMazeProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TvMazeProperties.class)
public class VmazeMiddelwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmazeMiddelwareApplication.class, args);
	}

}
