package com.student.core;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COURSEID")
    private long id;

    private String title;

    private String location;

    @Version
    private long version;

    @ManyToOne @JoinColumn(name="STUDENTID")
    @JsonBackReference
    private Student student;

    public String display() {
        return String.format("%n%-10s %-10s %-20s %-20s", student.getFirstName(), student.getSurname(), title, location );
    }
}
