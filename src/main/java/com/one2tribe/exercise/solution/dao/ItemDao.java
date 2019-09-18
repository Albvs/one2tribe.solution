package com.one2tribe.exercise.solution.dao;

import com.one2tribe.exercise.solution.entity.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Item save(Item item){
        entityManager.persist(item);
        entityManager.flush();
        return item;
    }

    @Transactional
    public List<Item> findAll(){
        TypedQuery<Item> query = entityManager.createQuery("SELECT i FROM item i", Item.class);
        return query.getResultList();
    }

    @Transactional
    public Item deleteById(int id) {
        Item foundItem = entityManager.find(Item.class, id);
        if(foundItem!=null)
            entityManager.remove(foundItem);

        return foundItem;
    }
}
