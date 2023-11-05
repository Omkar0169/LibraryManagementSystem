package com.spring.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.Model.Student;
import com.spring.test.Service.StudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<?> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> showStudent()
	{
		return new ResponseEntity<>(studentService.showStudent(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> showStudentById(@PathVariable("id") int id)
	{
		return new ResponseEntity<>(studentService.getStudentbyId(id),HttpStatus.OK);
	}
	
}
