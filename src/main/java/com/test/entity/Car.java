package com.test.entity;


import javax.persistence.*;

@Entity
@Table(name = "car")
@NamedQuery(name="Car.getAll", query = "select c from Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public Car() {
    }

    public Car(String name, Owner owner) {
        this.name = name;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {

        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner.getId() +
                '}';
    }
}
