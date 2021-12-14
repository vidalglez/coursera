package com.student.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@JsonIgnoreProperties({"hibernetLazyInitializer", "handler"})
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="STUDENTID")
    private long id;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String surname;

    @Column(name="DEPARTMENT")
    private String dept;

    @Column(name="FEES")
    private Double fees;

    @JsonManagedReference
    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
    private Collection<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
    }
}
