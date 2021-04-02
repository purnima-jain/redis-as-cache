package com.purnima.jain.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Integer customerId;	
	private final String firstName;	
	private final String lastName;

}
