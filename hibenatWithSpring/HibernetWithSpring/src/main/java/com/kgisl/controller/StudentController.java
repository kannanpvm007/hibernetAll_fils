package com.kgisl.controller;


import com.kgisl.entity.Student;
import com.kgisl.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value ="/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		System.out.println("2222222222222");
		model.addAttribute("student", new Student());
		return "student-form";
	}

	@RequestMapping("/saveProcess")
	public String saveStudentObj(@ModelAttribute("student") Student studentObj) {
		studentService.saveStudentObj(studentObj);
		return "redirect:/student/list";
	}

	@RequestMapping("/list")
	public String listOfStudents(Model model) {
		model.addAttribute("studentsList", studentService.getAllStudents());
		System.out.println("111111a");
		return "list-students";
	}

	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("studentId") int theId, Model model) {
		model.addAttribute("student", studentService.getStudentObj(theId));
		return "student-form";
	}

	@RequestMapping("/displayDeleteForm")
	public String deleteStudentObj(@RequestParam("studentId") int theId, Model model) {
		studentService.removeStudentObj(theId);
		return "redirect:/student/list";
	}
}