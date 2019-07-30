package com.kgisl.dao;

import java.util.List;

import com.kgisl.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
@Autowired
SessionFactory sessionFactory;

	public void saveStudentObj(Student studentObj) {
		sessionFactory.getCurrentSession().saveOrUpdate(studentObj);
		

	}

	public List<Student> getAllStudents() {
		Session 	 currentSession =sessionFactory.getCurrentSession();
		List<Student> theQuery =currentSession.createQuery("from student").list();

		return theQuery;
	}

	public Student getStudentObj(int theId) {
	Student studentobj=  (Student)sessionFactory.getCurrentSession().get(Student.class,theId);
		return studentobj;
	
	}

	public void removeStudentObj(int theId) {
Student studentObj=sessionFactory.getCurrentSession().get(Student.class,theId);
sessionFactory.getCurrentSession().delete(studentObj);
	}

}