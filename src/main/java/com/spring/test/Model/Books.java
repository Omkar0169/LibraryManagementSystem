package com.spring.test.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String author;
	private float price;
	private int copies;
	private boolean bookstatusavaliable;
	

}
