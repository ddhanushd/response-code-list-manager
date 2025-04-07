package com.springboot.moEngage.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.moEngage.entities.ListEntity;
import com.springboot.moEngage.entities.ListItem;
import com.springboot.moEngage.repository.ListItemRepository;
import com.springboot.moEngage.repository.ListRepository;



@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private ListRepository listRepository;

	@Autowired
	private ListItemRepository listItemRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ListEntity> getAllLists() {
		return listRepository.findAll();
	}

	

	@Override
	@Transactional
	public void deleteList(Long id) {
		listRepository.deleteById(id);
	}



	@Override
	@Transactional
	public ListEntity saveList(ListEntity list) {
		return listRepository.save(list);
	}



	@Override
	@Transactional
	public void saveAllItems(List<ListItem> items) {
		listItemRepository.saveAll(items);
	}



	@Override
	@Transactional
	public ListEntity updateList(Long id, String newName, List<Map<String, String>> newItemsData) {
		Optional<ListEntity> existingListOptional = listRepository.findById(id);
	    if (existingListOptional.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "List not found");
	    }

	    ListEntity existingList = existingListOptional.get();
	    existingList.setName(newName);  

	    listItemRepository.deleteAll(existingList.getItems());

	    List<ListItem> newItems = newItemsData.stream()
	        .map(data -> {
	            ListItem item = new ListItem();
	            item.setResponseCode(data.get("responseCode"));
	            item.setImageUrl(data.get("imageUrl"));
	            item.setList(existingList);
	            return item;
	        })
	        .collect(Collectors.toList());

	    listItemRepository.saveAll(newItems);
	    existingList.setItems(newItems);

	    return listRepository.save(existingList);
	}



	@Override
	@Transactional
	public ListEntity getListById(Long id) {
		 return listRepository.findById(id)
			        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "List not found"));
	}

}
