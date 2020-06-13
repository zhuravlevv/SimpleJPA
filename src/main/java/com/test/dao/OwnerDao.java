package com.test.dao;

import com.test.entity.Car;
import com.test.entity.Owner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OwnerDao {

    private EntityManager em;

    public OwnerDao(EntityManager em){
        this.em = em;
    }

    public List<Owner> getAll(){
        TypedQuery<Owner> query = em.createNamedQuery("Owner.getAll", Owner.class);
        return query.getResultList();
    }

    public Owner getById(Integer id){
        return em.find(Owner.class, id);
    }

    public Owner add(Owner owner){
        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();
        return owner;
    }

    public Owner update(Owner newOwner, Integer id){
        em.getTransaction().begin();
        Owner owner = getById(id);
        if(newOwner.getCars()!=null)
            owner.setCars(newOwner.getCars());
        owner.setName(newOwner.getName());
        em.getTransaction().commit();
        return owner;
    }

    public void delete(Integer id){
        em.getTransaction().begin();
        em.remove(getById(id));
        em.getTransaction().commit();
    }
}
