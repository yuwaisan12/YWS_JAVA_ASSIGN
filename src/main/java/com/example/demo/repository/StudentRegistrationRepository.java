package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.StudentRegistration;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
	

}
