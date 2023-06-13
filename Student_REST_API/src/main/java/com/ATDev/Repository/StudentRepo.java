package com.ATDev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ATDev.Entity.Student;
import com.ATDev.Exception.StudentException;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	

}
