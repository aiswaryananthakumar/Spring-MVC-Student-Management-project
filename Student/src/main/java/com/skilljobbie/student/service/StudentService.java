package com.skilljobbie.student.service;

import java.util.List;

import com.skilljobbie.student.StudentBO.StudentBO;

public interface StudentService {
	
	void create(StudentBO student);
	
	List<StudentBO> getAllStudents();
	
	StudentBO getStudentById(int id);
	
    void updateStudent(StudentBO student);
    
    void deleteStudent(int id);
    
}
