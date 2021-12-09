package com.student.service;

import com.student.core.Student;
import com.student.repository.StudentRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Named
public class StudentServiceImpl implements StudentService{

    @Inject
    StudentRepository studentRepository;

    @Override
    public Student get(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsByDepartment(String department) {
        return studentRepository.getByDept(department);
    }
}
