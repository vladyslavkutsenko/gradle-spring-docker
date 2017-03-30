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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author vkutsenko
 *
 */
@Entity
@Table(name = "jokes")
@JacksonXmlRootElement(localName = "fact")
public class Joke {
	@XmlAttribute
	@JacksonXmlProperty(isAttribute = true)
	@Id
	@GeneratedValue
	private Integer id;
	@Column(columnDefinition = "text")
	@JacksonXmlProperty(isAttribute = false)
	private String joke;
	@Column(name = "lang")
	@JacksonXmlProperty(isAttribute = true)
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

	@Override
	public String toString() {
		return "Joke [id=" + id + ", joke=" + joke + ", language=" + language + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joke == null) ? 0 : joke.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joke other = (Joke) obj;
		if (joke == null) {
			if (other.joke != null)
				return false;
		} else if (!joke.equals(other.joke))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
