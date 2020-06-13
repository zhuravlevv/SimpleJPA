package com.test.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
@NamedQuery(name="Owner.getAll", query = "select o from Owner o")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Car> cars;

    public Owner() {
    }

    public Owner(String name, Set<Car> cars) {
        this.name = name;
        if(cars!=null)
            this.cars = cars;
        else
            this.cars = new HashSet<Car>();
    }

    public void addCar(Car car){
        cars.add(car);
        car.setOwner(this);
    }

    public void removeCar(Car car){
        cars.remove(car);
        car.setOwner(null);
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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
