package com.todolist.ToDoList.DAO;

import com.todolist.ToDoList.Models.ListItem;

import java.util.List;

public interface ListItemDao {

    // We want to be able to add, edit, retrieve and delete list items

    ListItem createListItem(ListItem listItem);

    ListItem editListItem(ListItem listItem);

    boolean deleteListItem(ListItem listItem); // or use int listId?

    List<ListItem> getAllListItems();

}
