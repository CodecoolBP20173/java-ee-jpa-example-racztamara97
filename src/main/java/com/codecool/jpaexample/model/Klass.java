package com.codecool.jpaexample.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "Class")
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();
    @Enumerated
    private CCLocation location;

    public Klass() {}

    public Klass(String name, CCLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
