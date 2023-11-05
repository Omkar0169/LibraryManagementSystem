package com.spring.test.Dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.spring.test.Model.Books;
import com.spring.test.Model.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowDto {
	private int id;
	@CreatedDate
	private Date issueddate;
	private LocalDate returndate;
	private Student student;
	private Books books;
	private int booksId;
	private int studentId;
}
