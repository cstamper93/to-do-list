package com.todolist.ToDoList.DAO;

import com.todolist.ToDoList.Models.ListItem;

import java.util.List;

public interface ListItemDao {

    // We want to be able to add, edit, retrieve and delete list items

    ListItem createListItem(ListItem item);

    boolean editListItem(ListItem listItem);

    void deleteListItem(int id); // or use int listId?

    List<ListItem> getAllListItems();

}
