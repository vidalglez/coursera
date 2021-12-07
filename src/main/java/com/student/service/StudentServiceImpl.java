package com.student.service;

import com.student.core.Student;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Named
public class StudentServiceImpl implements StudentService{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Student get(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return entityManager.createQuery("SELECT student FROM Student student", Student.class).getResultList();
    }

    @Override
    public Collection<Student> getStudentsByDepartment(String department) {
        TypedQuery<Student> query =  entityManager.createQuery("SELECT student FROM Student student WHERE student.dept = :dept", Student.class);
        query.setParameter("dept", department);
        return query.getResultList();
    }
}
