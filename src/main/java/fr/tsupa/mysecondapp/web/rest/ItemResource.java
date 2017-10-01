package fr.tsupa.mysecondapp.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import fr.tsupa.mysecondapp.service.ItemService;
import fr.tsupa.mysecondapp.service.dto.ItemDTO;

@RestController
@RequestMapping("/api")
public class ItemResource {

	private final ItemService itemService;

	public ItemResource(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/items")
	@Timed
	public ResponseEntity<List<ItemDTO>> getAllItems() {
		List<ItemDTO> items = itemService.getAllItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

}