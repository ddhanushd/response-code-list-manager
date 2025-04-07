package com.springboot.moEngage.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.moEngage.entities.ListEntity;
import com.springboot.moEngage.entities.ListItem;
import com.springboot.moEngage.service.ListService;

@RestController
@RequestMapping("/api/lists")
@CrossOrigin(origins = "http://localhost:4200")
public class ListController {
	
	@Autowired
	 private ListService listService;
	
	 @GetMapping
	    public List<ListEntity> getAllLists() {
	        return listService.getAllLists();
	    }

	 @PostMapping
	 public ResponseEntity<ListEntity> saveList(@RequestBody Map<String, Object> request) {
	     String name = (String) request.get("name");
	     List<Map<String, String>> itemsData = (List<Map<String, String>>) request.get("items");

	     ListEntity list = new ListEntity();
	     list.setName(name);
	     list.setCreatedAt(LocalDateTime.now());

	     ListEntity savedList = listService.saveList(list);

	     List<ListItem> items = itemsData.stream()
	         .map(data -> {
	             ListItem item = new ListItem();
	             item.setResponseCode(data.get("responseCode"));
	             item.setImageUrl(data.get("imageUrl"));
	             item.setList(savedList); 
	             return item;
	         })
	         .collect(Collectors.toList());

	     savedList.setItems(items);
	     listService.saveAllItems(items);  

	     return ResponseEntity.ok(savedList);
	 }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
	        listService.deleteList(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<ListEntity> updateList(
	        @PathVariable Long id, 
	        @RequestBody Map<String, Object> request) {

	        String newName = (String) request.get("name");
	        List<Map<String, String>> newItems = (List<Map<String, String>>) request.get("items");

	        ListEntity updatedList = listService.updateList(id, newName, newItems);
	        return ResponseEntity.ok(updatedList);
	    }

	    @GetMapping("/{id}") 
	    public ResponseEntity<ListEntity> getListById(@PathVariable Long id) {
	        ListEntity list = listService.getListById(id);
	        return ResponseEntity.ok(list);
	    }

}
