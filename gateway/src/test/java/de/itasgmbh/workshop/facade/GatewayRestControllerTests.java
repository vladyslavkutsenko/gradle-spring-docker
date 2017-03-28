/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package de.itasgmbh.workshop.facade;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.itasgmbh.workshop.model.Joke;
import de.itasgmbh.workshop.service.ChuckNorrisService;

/**
 * @author vkutsenko
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = GatewayRestController.class)
public class GatewayRestControllerTests {
	@Autowired
	MockMvc mvc;
	static final String CP_PREFIX = "/api";
	@MockBean
	ChuckNorrisService mockChuckNorrisService;
	static final String HEROE = "heroe";
	Joke joke;
	JacksonTester<Joke> jokeConverter;
	@Autowired
	ObjectMapper objectMapper;

	@Before
	public void setup() {
		joke = new Joke();
		joke.setJoke("sdkljhfjkdfkdfik kdjfkdkfjdkf kdjfkdjfj");
		joke.setLanguage("en");

		JacksonTester.initFields(this, objectMapper);
	}

	@Test
	@Ignore
	public void testReplaceHeroe() throws Exception {
		when(mockChuckNorrisService.replaceHeroe(HEROE)).thenReturn(joke);
		mvc.perform(get(CP_PREFIX + "/heroe/" + HEROE)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(content().json(jokeConverter.write(joke).getJson()));

	}
}
