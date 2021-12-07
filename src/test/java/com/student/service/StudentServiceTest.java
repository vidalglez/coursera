package com.student.service;

import com.student.core.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class StudentServiceTest {

    @Inject
    private StudentService studentService;

    @Test
    void testServiceSingle() {
        Student student = studentService.get(1L);
        assertThat(student.getFirstName(), equalTo("Eric"));
        assertThat(student.getLastName(), equalTo("Colbert"));
    }

    @Test
    void testService() {
        Collection<Student> students= studentService.getAllStudents();
        students.stream().map( s -> String.format("%s %s", s.getFirstName(), s.getLastName())).forEach(System.out::println);
    }
}