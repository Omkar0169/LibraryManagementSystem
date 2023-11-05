package com.spring.test.Service;

import java.util.List;

import com.spring.test.Model.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	public List<Student> showStudent();
	public Student getStudentbyId(int id);
	public Student updateStudent(Student student);
	public void deleteStudent(int id);
}
