package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private long year;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name="MOVIE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ACTOR_ID",
                    referencedColumnName = "ID"))
    private Set<Actor> cast;
    public void addActor(Actor actor)
    {cast.add(actor);}


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Set<Actor> getCast() {
        return cast;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCast(Set<Actor> cast) {
        this.cast = cast;
    }
}
