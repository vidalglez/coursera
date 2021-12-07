package com.student.controller;

import com.student.core.Student;
import com.student.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/student")
@RestController
@CrossOrigin
public class StudentController {

    @Inject
    private StudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("id") long id) {
        return studentService.get(id);
    }

    @GetMapping(path="/search/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getDepartments() {
        return studentService.getAllStudents().stream().map(Student::getDept).distinct().collect(Collectors.toList());
    }

    @GetMapping(path="/search/department/{department}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Student> getStudentsByDepartments(@PathVariable("department") String department) {
        return studentService.getStudentsByDepartment(department);
    }
}
