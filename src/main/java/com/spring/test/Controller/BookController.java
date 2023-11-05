package com.spring.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.Dto.BookDto;
import com.spring.test.Model.Books;
import com.spring.test.Service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> saveBooks(@RequestBody BookDto bookDto)
	{
		Books b = bookService.saveBook(bookDto);
		return new ResponseEntity<>(b,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> showBooks()
	{
		List<Books>  b = bookService.showBooks();
		return new ResponseEntity<>(b,HttpStatus.OK);
	}

}
