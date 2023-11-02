package com.todolist.ToDoList.DAO;

import com.todolist.ToDoList.Models.ListItem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

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


    // Use mapper for below method??
    @Override
    public boolean editListItem(ListItem listItem) {
        boolean success = false;
        String sqlUpdate = "UPDATE item SET item = ? WHERE item_id = ?;";
        String sqlSelect = "SELECT * FROM item WHERE item_id = ?;";
//        try {
//            String before = jdbcTemplate.queryForObject(sqlSelect, String.class, listItem.getItemId());
//        } catch(DataAccessException e) {
//            System.out.println("Error");
//        }
        jdbcTemplate.update(sqlUpdate, listItem.getItem(), listItem.getItemId());
//        if(!before.equals(after)) {
//            success = true;
//        }
        return success;
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

    @Override
    public List<ListItem> getAllListItems() {
        List<ListItem> itemList = new ArrayList<>();
        String sql = "SELECT * FROM item;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            itemList.add(mapRowToListItem(results));
        }
        return itemList;
    }

    private ListItem mapRowToListItem(SqlRowSet results) {
        ListItem listItem = new ListItem();
        listItem.setItemId(results.getInt("item_id"));
        listItem.setItem(results.getString("item"));
        return listItem;
    }
}
