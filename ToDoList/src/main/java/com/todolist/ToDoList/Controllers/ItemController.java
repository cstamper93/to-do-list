package com.todolist.ToDoList.Controllers;

import com.todolist.ToDoList.DAO.ListItemDao;
import com.todolist.ToDoList.Models.ListItem;
import org.springframework.beans.factory.annotation.Autowired;
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

}
