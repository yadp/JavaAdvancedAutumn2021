package com.example.Lecture15.service;

import com.example.Lecture15.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    /**
     * Add Student
     * Find Student
     * List all Students
     */
    private List<Student> studentList;

    @Autowired
    PersonService personService;

    StudentService(){
        studentList= new ArrayList<>();
    }

    /**
     * Add student to the student list
     * @param student to add to the list
     * @return Student object that was added to the list
     */
    public Student addStudent(Student student){
        studentList.add(student);
        personService.addPerson(student.getPerson());
        return student;
    }

    /**
     * Find student by student Id
     * @param id the id that we are searching
     * @return Student that we found or null if we didn't find it
     */
    public Student findById(int id){
        for(Student student:studentList){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    /**
     * Lists all students
     * @return list of the Students
     */
    public List<Student> findAll(){
        return studentList;
    }
}
