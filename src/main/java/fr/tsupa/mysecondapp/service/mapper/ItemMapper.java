package fr.tsupa.mysecondapp.service.mapper;

import org.springframework.stereotype.Service;

import fr.tsupa.mysecondapp.domain.Item;
import fr.tsupa.mysecondapp.service.dto.ItemDTO;

@Service
public class ItemMapper {

	public ItemDTO mapItemToItemDTO(Item item) {
		return new ItemDTO(item);
	}

	public Item mapItemDTOToItem(ItemDTO itemDTO) {
		if (itemDTO == null) {
			return null;
		} else {
			Item item = new Item();

			item.setId(itemDTO.getId());
			item.setActive(itemDTO.isActive());
			item.setDescription(itemDTO.getDescription());
			item.setDuration(itemDTO.getDuration());
			item.setName(itemDTO.getName());
			item.setNumber(itemDTO.getNumber());
			item.setImageUrl(itemDTO.getImageUrl());
			// TODO : Creer des mapper pour ces deux types
			item.setType(itemDTO.getType());
			item.setCategories(itemDTO.getCategories());

			return item;
		}
	}

}