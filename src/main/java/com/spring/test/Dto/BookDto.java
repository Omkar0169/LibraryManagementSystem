package com.spring.test.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

	private int id;
	private String title;
	private String author;
	private float price;
	private int copies;
}
