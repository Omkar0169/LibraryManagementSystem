package com.spring.test.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.Dto.BookDto;
import com.spring.test.Model.Books;
import com.spring.test.Repo.BookRepo;
import com.spring.test.Service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	
	@Override
	public Books saveBook(BookDto bookDto) {
		
		Books books = new Books();
		books.setTitle(bookDto.getTitle());
		books.setAuthor(bookDto.getAuthor());
		books.setPrice(bookDto.getPrice());
		books.setCopies(bookDto.getCopies());

		return bookRepo.save(books);
	}

	@Override
	public List<Books> showBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public List<Books> getBookbyId(int id) {
	
		return null;
	}

	@Override
	public Books updateBooks(BookDto bookDto) {
		
		return null;
	}

	@Override
	public void deleteBooks(int id) {
		
		
	}

}
