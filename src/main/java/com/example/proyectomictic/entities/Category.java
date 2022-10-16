package com.example.proyectomictic.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
//@JsonIgnoreProperties("categorys")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(length = 45)
    private String name;
   // @Column(length = 250)
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Bike> bikes;

    public Category() {
    }

    public Category(Integer id, String name, String description, List<Bike> bikes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.bikes = bikes;
    }

    public Category(String name, String description, List<Bike> bikes) {
        this.name = name;
        this.description = description;
        this.bikes = bikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
