package DAO;

import Models.ListItem;

public interface ListItemDao {

    // We want to be able to add, edit, and delete list items

    ListItem createListItem(ListItem listItem);

    ListItem editListItem(ListItem listItem);

    boolean deleteListItem(ListItem listItem); // or use int listId?

}
