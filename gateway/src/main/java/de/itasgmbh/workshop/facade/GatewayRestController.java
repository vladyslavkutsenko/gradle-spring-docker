/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package de.itasgmbh.workshop.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.itasgmbh.workshop.model.Joke;
import de.itasgmbh.workshop.service.ChuckNorrisService;

/**
 * @author vkutsenko
 *
 */
@RestController
@RequestMapping("/api")
public class GatewayRestController {

	static final Logger log = LoggerFactory.getLogger(GatewayRestController.class);
	@Autowired
	ChuckNorrisService chuckNorrisService;

	@RequestMapping(method = RequestMethod.GET, path = "/heroe/{heroe}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Joke> replaceHeroe(@PathVariable String heroe) {
		log.info("Changing heroe to {}", heroe);
		return new ResponseEntity<>(chuckNorrisService.replaceHeroe(heroe), HttpStatus.OK);
	}
}
