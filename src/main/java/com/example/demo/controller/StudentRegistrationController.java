package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.StudentRegistration;
import com.example.demo.service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {
 
	@Autowired
	private StudentRegistrationService studentService;	
	public StudentRegistrationController(StudentRegistrationService service) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "index";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		StudentRegistration student = new StudentRegistration();
		model.addAttribute("student",student);
		return "createstudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") StudentRegistration student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "editstudent";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") StudentRegistration student,Model model) {
		StudentRegistration existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setAge(student.getAge());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setGender(student.getGender());
		existingStudent.setDob(student.getDob());
		existingStudent.setAddress(student.getAddress());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}

