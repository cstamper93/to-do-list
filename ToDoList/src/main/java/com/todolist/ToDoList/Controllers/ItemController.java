package com.todolist.ToDoList.Controllers;

import com.todolist.ToDoList.DAO.ListItemDao;
import com.todolist.ToDoList.Models.ListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path="/item")
public class ItemController {

    @Autowired
    private ListItemDao listItemDao;

//    @GetMapping(path="/{id}")
//    public ListItem getListItem(@PathVariable int id) {
//        return listItemDao.get
//    }

    @GetMapping()
    public List<ListItem> getAllListItems() {
        return listItemDao.getAllListItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/{item}")
    public void createListItem(@PathVariable String item) {
        listItemDao.createListItem(item);
    }

    @PutMapping
    public void editListItem(@RequestBody ListItem listItem) {
        listItemDao.editListItem(listItem);
    }

    @DeleteMapping
    public void deleteListItem(@RequestBody ListItem listItem) {
        listItemDao.deleteListItem(listItem);
    }
}
