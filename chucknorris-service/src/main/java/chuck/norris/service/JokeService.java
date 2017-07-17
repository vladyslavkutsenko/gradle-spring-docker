/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package chuck.norris.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import chuck.norris.repository.JokeRepository;
import de.itasgmbh.workshop.model.Joke;

/**
 * @author vkutsenko
 *
 */
@Component
public class JokeService {

	static final Logger log = LoggerFactory.getLogger(JokeService.class);
	@Autowired
	JokeRepository jokeRepository;
	Random random = new Random();

	@Transactional
	public Joke getNextJoke() {
		int count = (int) jokeRepository.count();
		long idCandidate = (long) random.nextInt(count - 1) + 1;
		for (int i = 0; i < 5; i++) {
			Joke joke = jokeRepository.findOne(idCandidate);
			if (joke != null) {
				log.debug("Returning joke {}", joke);
				return joke;
			}
		}
		throw new IllegalStateException("Joke not found");

	}

}
