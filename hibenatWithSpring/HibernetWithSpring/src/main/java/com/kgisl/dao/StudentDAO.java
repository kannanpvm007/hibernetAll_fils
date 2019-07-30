package com.kgisl.dao;

/**
 * StudentDAO
 */
 
public interface StudentDAO {
	
	public void saveStudentObj(Student studentObj);
	 
	public List<Student> getAllStudents();
	 
	public Student getStudentObj(int theId);
	 
	public void removeStudentObj(int theId);
}