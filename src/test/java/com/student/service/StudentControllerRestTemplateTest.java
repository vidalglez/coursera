package com.student.service;

import com.student.core.Course;
import com.student.core.Student;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class StudentControllerRestTemplateTest {

    @Test
    public void testPost(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", MediaType.APPLICATION_JSON_VALUE);
        Student s = new Student();
        s.setDept("History");
        s.setFirstName("Fred");
        s.setSurname("Flinstone");
        s.setFees(122.00);

        Course course = new Course();
        course.setLocation("Universit of Miami");
        course.setStudent(s);
        course.setTitle("History of Carthage");
        s.getCourses().add(course);

        ResponseEntity<String> response = new RestTemplate().postForEntity("http://localhost:8080/student", new HttpEntity(s, headers), String.class);
        String url = response.getHeaders().get("location").get(0);
        Student attendee = new RestTemplate().getForObject("http://localhost:8080/" + url, Student.class);
        System.out.println(attendee);
    }
}
