package com.one2tribe.exercise.solution.controller;

import com.one2tribe.exercise.solution.entity.Item;
import com.one2tribe.exercise.solution.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item")
    public List<Item> findAllItemsShuffled(){
        return itemService.findAllAndShuffle();
    }

    @PostMapping("/item")
    public ResponseEntity saveItem(@RequestBody Item givenItem){
        if(!givenItem.getName().isEmpty())
            return new ResponseEntity(itemService.save(givenItem), HttpStatus.OK);
        else
            return new ResponseEntity("Item name cannot be empty!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity deleteItemById(@PathVariable int id){
        Item deletedItem = itemService.deleteById(id);
        if(deletedItem!=null)
            return new ResponseEntity(deletedItem, HttpStatus.OK);
        else
            return new ResponseEntity("Item with given id doesn't exist!", HttpStatus.BAD_REQUEST);
    }
}
