/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package de.itasgmbh.workshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.itasgmbh.workshop.model.Joke;

/**
 * @author vkutsenko
 *
 */
@Component
public class ChuckNorrisService {

	static final Logger log = LoggerFactory.getLogger(ChuckNorrisService.class);
	static final String CHUCK_NORRIS_SERVICE_URL = "http://chucknorris-service:8080/";
	@Autowired
	RestTemplate restTemplate;

	public Joke replaceHeroe(String newHeroe) {
		Joke joke = getChuckNorrisFact();
		joke.setJoke(joke.getJoke().replaceAll("Chuck Norris", newHeroe));
		return joke;
	}

	private Joke getChuckNorrisFact() {
		return restTemplate.getForObject(CHUCK_NORRIS_SERVICE_URL, Joke.class);
	}

}
