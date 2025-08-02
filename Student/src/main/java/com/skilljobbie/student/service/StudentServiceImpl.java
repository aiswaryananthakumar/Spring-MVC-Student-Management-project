package com.skilljobbie.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilljobbie.student.DAO.StudentDAO;
import com.skilljobbie.student.StudentBO.StudentBO;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
    private StudentDAO studentDAO;

    @Override
    public void create(StudentBO student) {
        studentDAO.create(student);
    }
    
    @Override
    public List<StudentBO> getAllStudents() {
        return studentDAO.getAllStudents();
    }
    
    @Override
    public StudentBO getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void updateStudent(StudentBO student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
