package com.codecool.jpaexample.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column (unique = true, nullable = false)
    private String email;

    @ElementCollection
    @CollectionTable (name = "phone")
    private List<String> phoneNumbers = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private long age;
    @OneToOne
    private Address address;

    @ManyToOne
    private Klass klass;

    public Student() {
    }

    public Student(String name, String email, Date dateOfBirth, String phoneNumbers, Klass klass) {
        this.name = name;
        this.email = email;
        this.phoneNumbers.add(phoneNumbers);
        this.dateOfBirth = dateOfBirth;
        this.age = (Calendar.getInstance().getTimeInMillis() - dateOfBirth.getTime())
                / (60L * 60L * 1000L * 24L * 365L);
        this.klass = klass;

    }

    public Student(String name, String email, Date dateOfBirth, Address address, String phoneNumbers, Klass klass) {
        this(name, email, dateOfBirth, phoneNumbers, klass);
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address id=" + address.getId() +
                '}';
    }

}
