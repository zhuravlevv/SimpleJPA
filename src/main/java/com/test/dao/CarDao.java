package com.test.dao;

import com.test.entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarDao {

    private EntityManager em;

    public CarDao(EntityManager em){
        this.em = em;
    }

    public Car getById(Integer id){
        return em.find(Car.class, id);
    }

    public List<Car> getAll(){
        TypedQuery<Car> query = em.createNamedQuery("Car.getAll", Car.class);
        return query.getResultList();
    }

    public Car add(Car car){
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        return car;
    }

    public Car update(Car newCar, Integer id){
        em.getTransaction().begin();
        Car car = getById(id);
        car.setName(newCar.getName());
        if(newCar.getOwner()!= null)
            car.setOwner(newCar.getOwner());
        em.getTransaction().commit();
        return car;
    }

    public void delete(Integer id){
        em.getTransaction().begin();
        em.remove(getById(id));
        em.getTransaction().commit();
    }

}
