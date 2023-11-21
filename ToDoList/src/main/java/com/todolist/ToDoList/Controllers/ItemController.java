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

    @GetMapping()
    public List<ListItem> getAllListItems() {
        return listItemDao.getAllListItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createListItem(@RequestBody ListItem item) {
        listItemDao.createListItem(item);
    }

    @PutMapping()
    public void editListItem(@RequestBody ListItem listItem) {
        listItemDao.editListItem(listItem);
    }

    @DeleteMapping(path="/{id}")
    public void deleteListItem(@PathVariable int id) {
        listItemDao.deleteListItem(id);
    }
}
