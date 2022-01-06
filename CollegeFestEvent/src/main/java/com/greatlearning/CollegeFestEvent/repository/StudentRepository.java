package com.greatlearning.CollegeFestEvent.repository;

import com.greatlearning.CollegeFestEvent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}