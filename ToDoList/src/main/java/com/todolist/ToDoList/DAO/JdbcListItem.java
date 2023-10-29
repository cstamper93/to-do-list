package com.todolist.ToDoList.DAO;

import com.todolist.ToDoList.Models.ListItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class JdbcListItem implements ListItemDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcListItem(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ListItem createListItem(ListItem listItem) {
        // run queryForObject method and use another query to return the newly created ListItem?
        String sqlInsert = "INSERT INTO item (item) VALUES (?) " +
                "RETURNING item_id";
        Integer newItemId = jdbcTemplate.queryForObject(sqlInsert, Integer.class, listItem.getItem());
        ListItem newListItem = new ListItem();
        String sqlSelect = "SELECT * FROM item where item_id = ?;";
        int newListItemId = 0;
        String newListItemContent = "";
        try {
            newListItemId = jdbcTemplate.queryForObject(sqlSelect, Integer.class, listItem.getItemId());
            newListItemContent = jdbcTemplate.queryForObject(sqlSelect, String.class, listItem.getItemId());
            // maybe I need to separate this into 2 queries for each data type?
        } catch(DataAccessException e) {
            System.out.println("Error");
        }
        newListItem.setItemId(newListItemId);
        newListItem.setItem(newListItemContent);
        return newListItem;
    }

    @Override
    public ListItem editListItem(ListItem listItem) {
        ListItem updatedItem = new ListItem();
        int updatedId = 0;
        String updatedContent = "";
        String sqlUpdate = "UPDATE item SET item = ? WHERE item_id = ?;";
        jdbcTemplate.update(sqlUpdate, listItem.getItemId());
        String sqlSelect = "SELECT * FROM item WHERE item_id = ?;";
        try {
            jdbcTemplate.queryForObject(sqlSelect, Integer.class, listItem.getItemId());
            jdbcTemplate.queryForObject(sqlSelect, String.class, listItem.getItemId());
        } catch(DataAccessException e) {
            System.out.println("Error");
        }
        updatedItem.setItemId(updatedId);
        updatedItem.setItem(updatedContent);
        return updatedItem;
    }

    @Override
    public boolean deleteListItem(ListItem listItem) {
        boolean success = false;
        String sqlDelete = "DELETE FROM item WHERE item_id = ?;";
        int linesUpdated =jdbcTemplate.update(sqlDelete, listItem.getItemId());
        if(linesUpdated == 1) {
            success = true;
        }
        return success;
    }
}
