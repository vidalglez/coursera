package com.student.repository;

import com.student.core.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "student", path = "enrollments", excerptProjection = Person.class)
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT student FROM Student student WHERE student.dept=:dept")
    Collection<Student> getByDept(@Param("dept") String department);
}
