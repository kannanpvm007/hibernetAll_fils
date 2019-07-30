package com.kgisl.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kgisl.dao.StudentDAO;
import com.kgisl.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	
	@Transactional
	public void saveStudentObj(Student studentObj) {
		studentDAO.saveStudentObj(studentObj);
	}

	
	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	
	@Transactional
	public Student getStudentObj(int theId) {
		return studentDAO.getStudentObj(theId);
	}

	
	@Transactional
	public void removeStudentObj(int theId) {
		studentDAO.removeStudentObj(theId);
	}

}