package fr.tsupa.mysecondapp.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
			item.setTypeName(itemDTO.getTypeName());
			item.setCategoriesName(itemDTO.getCategoriesName());

			return item;
		}
	}

	public List<ItemDTO> mapItemsToItemDTOs(List<Item> items) {
		return items.stream().filter(Objects::nonNull)
				.map(this::mapItemToItemDTO).collect(Collectors.toList());
	}

}
