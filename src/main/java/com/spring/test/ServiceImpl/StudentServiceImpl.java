package com.spring.test.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.Model.Student;
import com.spring.test.Repo.StudentRepo;
import com.spring.test.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> showStudent() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentbyId(int id) {
		Optional<Student> student = studentRepo.findById(id);
		if (student.isEmpty()) {
			throw new RuntimeException("student id no found");
		}
		Student s = student.get();
		return s;
	}

	@Override
	public Student updateStudent(Student student) {

		return null;
	}

	@Override
	public void deleteStudent(int id) {

	}

}
