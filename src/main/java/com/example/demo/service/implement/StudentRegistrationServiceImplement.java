package com.example.demo.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentRegistration;
import com.example.demo.repository.StudentRegistrationRepository;
import com.example.demo.service.StudentRegistrationService;

@Service
public class StudentRegistrationServiceImplement implements StudentRegistrationService  {

	private StudentRegistrationRepository studentRepository;
	public StudentRegistrationServiceImplement(StudentRegistrationRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<StudentRegistration> getAllStudents(){
		return studentRepository.findAll();
	}
	
	@Override
	public StudentRegistration saveStudent(StudentRegistration student) {
		return studentRepository.save(student);
	}
	
	@Override
	public StudentRegistration getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	@Override
	public StudentRegistration updateStudent(StudentRegistration student) {
		return studentRepository.save(student);
	}
	
	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
}