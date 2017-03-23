/*
 * Copyright (C) 2017 ITAS GmbH. All rights reserved.
 */
package de.itasgmbh.workshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author vkutsenko
 *
 */
@Entity
@Table(name = "jokes")
public class Joke {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(columnDefinition = "text")
	private String joke;
	@Column(name = "lang")
	private String language;

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getId() {
		return id;
	}

}
