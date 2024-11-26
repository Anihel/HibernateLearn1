package org.spring.learn.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int YearOfProduction;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String name, int yearOfProduction) {
        this.name = name;
        this.YearOfProduction = yearOfProduction;
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

    public int getYearOfProduction() {
        return YearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        YearOfProduction = yearOfProduction;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && YearOfProduction == movie.YearOfProduction && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, YearOfProduction);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", YearOfProduction='" + YearOfProduction + '\'' +
                '}';
    }
}
