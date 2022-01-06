package com.greatlearning.CollegeFestEvent.service;

import com.greatlearning.CollegeFestEvent.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> findAll();

    public Student getById(int id);

    public void save(Student student);

    public void deleteById(int id);
}

