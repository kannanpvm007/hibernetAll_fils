package src.main.java.com.kgisl.service;

/**
 * StudentService
 */

public interface StudentService {

	public void saveStudentObj(Student studentObj);

	public List<Student> getAllStudents();

	public Student getStudentObj(int theId);

	public void removeStudentObj(int theId);

}