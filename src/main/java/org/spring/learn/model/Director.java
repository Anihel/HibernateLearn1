package org.spring.learn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL)
    private School school;

    public Director() {
    }

    public Director(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school=" +
                '}';
    }
}
