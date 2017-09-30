package fr.tsupa.mysecondapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.tsupa.mysecondapp.domain.Item;
import fr.tsupa.mysecondapp.repository.ItemRepository;
import fr.tsupa.mysecondapp.service.dto.ItemDTO;
import fr.tsupa.mysecondapp.service.mapper.ItemMapper;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	private final ItemMapper itemMapper;

	public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
		this.itemRepository = itemRepository;
		this.itemMapper = itemMapper;
	}

	public Item createItem(ItemDTO itemDTO) {
		Item item = itemMapper.mapItemDTOToItem(itemDTO);
		itemRepository.save(item);
		return item;
	}

	public List<Item> getAllItems() {
		return this.itemRepository.findAll();
	}

	public List<Item> getActivableItems(boolean active) {
		return this.itemRepository.findAllByActive(active);
	}

	public Item getItemById(String id) {
		return this.itemRepository.findOneById(id).orElse(null);
	}

	public Item getItemByName(String name) {
		return this.itemRepository.findOneByName(name).orElse(null);
	}

	public void removeItem(String id) {
		this.itemRepository.findOneById(id).ifPresent(item -> {
			this.itemRepository.delete(item);
		});
	}

}
