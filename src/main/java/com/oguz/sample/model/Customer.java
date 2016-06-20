package com.oguz.sample.model;

import lombok.Setter;
import lombok.Getter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Customer {

	@GraphId
	private Long id;

	private String firstName;
	private String lastName;

	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id,
				firstName, lastName);
	}

}

