package com.ATDev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ATDev.Entity.Student;
import com.ATDev.Exception.StudentException;
import com.ATDev.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/viewallStudents")
	  public ResponseEntity<List<Student>> viewAllStudents()throws StudentException{
		  
		  List<Student> vie = studentService.getAllStudent();
		  
		  return new ResponseEntity<List<Student>>(vie,HttpStatus.ACCEPTED);
		  
	  }

	  @GetMapping("/viwadbyid/{roll}")
		 public ResponseEntity<Student> viewbyid(@PathVariable("roll") Integer roll)throws StudentException{
			  
			  Student student = studentService.getStudentByRollNo(roll);
			  
			  return new ResponseEntity<Student>(student,HttpStatus.OK);
			  
		  }
	  @PostMapping("/insertStudent")
		public ResponseEntity<Student> insertStudent(@RequestBody Student student)throws StudentException{
			
			Student add = studentService.insertStudnt(student);
			
			return new ResponseEntity<Student>(add,HttpStatus.CREATED);
			
		}
	  @DeleteMapping("/deleteStudent/{roll}")
	    public ResponseEntity<Student> deleteStudent( @PathVariable("roll") Integer roll)throws StudentException{
	    	
		  Student ds = studentService.deleteStudent(roll);
		  
		  return new ResponseEntity<Student>(ds,HttpStatus.OK);
		 
	    }
	  @PutMapping("/updateStudent")
	  public ResponseEntity<Student> updateStudent(@RequestBody Student student)throws StudentException{
		  
		  Student st = studentService.updateStudentDetails(student);
		  
		  return new ResponseEntity<Student>(st,HttpStatus.CREATED);
		  
		  
	  }
}
