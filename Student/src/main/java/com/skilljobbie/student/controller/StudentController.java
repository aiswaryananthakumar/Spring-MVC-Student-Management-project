package com.skilljobbie.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.skilljobbie.student.StudentBO.StudentBO;
import com.skilljobbie.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
    private StudentService studentService;
	
	List<StudentBO> list = new ArrayList<>();

    @GetMapping("/createform")
    public String create(Model model) {
        model.addAttribute("student", new StudentBO());
        return "createform"; 
    }

    @PostMapping("/createform")
    public String createStudent(@ModelAttribute("student") StudentBO student, Model model) {
    	studentService.create(student);
        model.addAttribute("student", student);      
        return "success";
    }
    
    @GetMapping("/")
    public String retrieve(Model model) {
        List<StudentBO> list = studentService.getAllStudents();
        model.addAttribute("students", list);
        return "list"; 
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new StudentBO());
        return "addstudent";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentBO student) {
        studentService.create(student);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        StudentBO student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editform";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student") StudentBO student) {
        studentService.updateStudent(student);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
