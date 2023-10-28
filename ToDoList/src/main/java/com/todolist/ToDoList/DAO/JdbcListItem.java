package com.todolist.ToDoList.DAO;

import com.todolist.ToDoList.Models.ListItem;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcListItem implements ListItemDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcListItem(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ListItem createListItem(ListItem listItem) {
        return null;
    }

    @Override
    public ListItem editListItem(ListItem listItem) {
        return null;
    }

    @Override
    public boolean deleteListItem(ListItem listItem) {
        return false;
    }
}
