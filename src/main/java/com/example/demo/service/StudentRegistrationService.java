package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentRegistration;
import com.example.demo.repository.StudentRegistrationRepository;

@Service
public interface StudentRegistrationService {
	List<StudentRegistration> getAllStudents();
	
	StudentRegistration saveStudent(StudentRegistration student);
	
	StudentRegistration getStudentById(Long id);
	StudentRegistration updateStudent(StudentRegistration student);
	
	void deleteStudentById(Long id);

}
