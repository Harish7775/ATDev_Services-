package com.ATDev.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ATDev.Entity.Student;
import com.ATDev.Exception.StudentException;
import com.ATDev.Repository.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudent() throws StudentException{
		// TODO Auto-generated method stub
		
		List<Student> students = studentRepo.findAll();
		
		if(students == null)
			throw new StudentException("No Student available.");
		else
			return students;
	}

	@Override
	public Student getStudentByRollNo(Integer roll) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> studeOptional = studentRepo.findById(roll);
		
		if(studeOptional.isEmpty()) {
			throw new StudentException("Roll not found");
		}else {
			return studeOptional.get();
		}
	}

	@Override
	public Student insertStudnt(Student student) throws StudentException {
		// TODO Auto-generated method stub
		Student st = studentRepo.save(student);
		
		return st;
	}

	@Override
	public Student deleteStudent(Integer roll) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> ds = studentRepo.findById(roll);
		
		if(ds.isPresent()) {
			studentRepo.deleteById(roll);
		}

		else {
			throw new StudentException("Invalid roll for delete Student");
		}
		return ds.get();
	}

	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> updateStudent = studentRepo.findById(student.getRollNo());
		
		if(updateStudent.isEmpty()) {
			throw new StudentException("roll not found ");
		}else {
			studentRepo.save(student);
		}
		return updateStudent.get();
	}
	
	

}
