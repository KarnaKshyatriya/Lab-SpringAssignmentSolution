package com.greatlearning.CollegeFestEvent.controller;

import com.greatlearning.CollegeFestEvent.entity.Student;
import com.greatlearning.CollegeFestEvent.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudents(Model model) {

        // get list of students from db
        List<Student> students = studentService.findAll();


        // add to the spring model
        model.addAttribute("Student",students);
        return "list-student";
    }


    @RequestMapping("/add")
    public String addStudent(Model model) {

        // create model attribute to bind form data
        Student student = new Student();

        model.addAttribute("Student", student);

        return "student-form";
    }


    @RequestMapping("/update")
    public String updateStudent(@RequestParam("studentId") int id, Model model) {

        // get the student from the service
        Student student = studentService.getById(id);

        model.addAttribute("Student", student);

        return "student-form";
    }


    @PostMapping("/save")
    public String save(@RequestParam("id") int id, @RequestParam("name") String name,
                       @RequestParam("department") String department, @RequestParam("country") String country) {

        Student student;

        if(id != 0) {
            student = studentService.getById(id);
            student.setName(name);
            student.setCountry(country);
            student.setDepartment(department);
        }
        else {
            student = new Student(name,department,country);
        }

        studentService.save(student);

        return "redirect:/student/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") int id) {

        studentService.deleteById(id);

        return "redirect:/student/list";
    }
    @RequestMapping(value="/403")
    public ModelAndView accesssDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg", "You do not have permission to access this page!");
        }
        model.setViewName("403");
        return model;
    }

}
