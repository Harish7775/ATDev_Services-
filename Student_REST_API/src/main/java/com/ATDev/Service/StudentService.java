package com.ATDev.Service;

import java.util.List;

import com.ATDev.Entity.Student;
import com.ATDev.Exception.StudentException;

public interface StudentService {

	public List<Student> getAllStudent() throws StudentException;
	
	public Student getStudentByRollNo(Integer roll) throws StudentException;
	
	public Student insertStudnt(Student student) throws StudentException;
	
	public Student deleteStudent(Integer roll) throws StudentException;
	
	public Student updateStudentDetails(Student student) throws StudentException;
}
