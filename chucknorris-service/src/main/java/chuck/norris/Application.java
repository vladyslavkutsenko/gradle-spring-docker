/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package chuck.norris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author vkutsenko
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = { "chuck.norris", "de.itasgmbh.workshop.model" })
@EntityScan(basePackages = "de.itasgmbh.workshop.model")
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
