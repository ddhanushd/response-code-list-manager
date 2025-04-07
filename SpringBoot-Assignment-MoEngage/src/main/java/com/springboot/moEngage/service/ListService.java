package com.springboot.moEngage.service;

import java.util.List;
import java.util.Map;

import com.springboot.moEngage.entities.ListEntity;
import com.springboot.moEngage.entities.ListItem;

public interface ListService {

	public List<ListEntity> getAllLists();
	public ListEntity saveList(ListEntity list);
	public void saveAllItems(List<ListItem> items);
	public void deleteList(Long id);
	
	public ListEntity getListById(Long id);

	public ListEntity updateList(Long id, String newName, List<Map<String, String>> newItemsData);

}
