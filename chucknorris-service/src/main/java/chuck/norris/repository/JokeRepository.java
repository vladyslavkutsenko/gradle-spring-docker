/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package chuck.norris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.itasgmbh.workshop.model.Joke;

/**
 * @author vkutsenko
 *
 */
public interface JokeRepository extends JpaRepository<Joke, Integer> {

}
