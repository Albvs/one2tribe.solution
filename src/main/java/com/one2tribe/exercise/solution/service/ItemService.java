package com.one2tribe.exercise.solution.service;

import com.one2tribe.exercise.solution.dao.ItemDao;
import com.one2tribe.exercise.solution.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<Item> findAllAndShuffle(){
        List<Item> foundItems = itemDao.findAll();
        Collections.shuffle(foundItems);
        return foundItems;
    }

    public Item save(Item givenItem) {
        return itemDao.save(givenItem);
    }

    public Item deleteById(int id) {
        return itemDao.deleteById(id);
    }
}
