/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package chuck.norris.facade;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chuck.norris.service.JokeService;
import de.itasgmbh.workshop.model.Joke;

/**
 * @author vkutsenko
 *
 */
@RestController
@RequestMapping("/")
public class JokeRestController {
	@Autowired
	JokeService jokeService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Joke> nextJoke() {
		return new ResponseEntity<>(jokeService.getNextJoke(), HttpStatus.OK);
	}
}
