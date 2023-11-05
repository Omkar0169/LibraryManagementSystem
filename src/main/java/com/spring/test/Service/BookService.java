package com.spring.test.Service;

import java.util.List;

import com.spring.test.Dto.BookDto;
import com.spring.test.Model.Books;

public interface BookService {

	public Books saveBook(BookDto bookDto);
	public List<Books> showBooks();
	public List<Books> getBookbyId(int id);
	public Books updateBooks(BookDto bookDto);
	public void deleteBooks(int id);
	
}
