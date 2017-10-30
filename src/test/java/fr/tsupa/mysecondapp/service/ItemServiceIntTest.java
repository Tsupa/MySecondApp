package fr.tsupa.mysecondapp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.tsupa.mysecondapp.MySecondApp;
import fr.tsupa.mysecondapp.domain.Item;
import fr.tsupa.mysecondapp.service.dto.ItemDTO;
import fr.tsupa.mysecondapp.service.mapper.ItemMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySecondApp.class)
public class ItemServiceIntTest {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ItemMapper itemMapper;

	private final String TYPE_NAME = "DVD";

	@Test
	public void testCreateAndRemoveItem() {
		ItemDTO itemDTO = getItemDTOTest();
		Item itemMapped = itemMapper.mapItemDTOToItem(itemDTO);

		Item itemCreate = itemService.createItem(itemDTO);

		assertThat(itemCreate).isEqualTo(itemMapped);

		itemService.removeItem(itemCreate.getId());

		assertThat(itemService.getItemById(itemCreate.getId()).isPresent())
				.isFalse();
	}

	@Test
	public void testGetAllItems() {
		int nbBeforeInsert = itemService.getAllItems().size();
		Item itemCreate = itemService.createItem(getItemDTOTest());
		int nbAfterInsert = itemService.getAllItems().size();
		System.out.println("nb : " + nbBeforeInsert);
		assertThat(nbBeforeInsert + 1).isEqualTo(nbAfterInsert);

		itemService.removeItem(itemCreate.getId());

	}

	@Test
	public void testGetItemsByTypeName() {
		int nbBeforeInsert = itemService.getItemsByTypeName(TYPE_NAME).size();
		Item itemCreate = itemService.createItem(getItemDTOTest());
		int nbAfterInsert = itemService.getItemsByTypeName(TYPE_NAME).size();
		// int nbAfterInsert = itemService.getAllItems().size();
		System.out.println("nbBeforeInsert : " + nbBeforeInsert);
		System.out.println("nbAfterInsert : " + nbAfterInsert);
		assertThat(nbBeforeInsert + 1).isEqualTo(nbAfterInsert);

		itemService.removeItem(itemCreate.getId());

	}

	@Test
	public void testGetActivableItems() {
		List<Item> itemsActivable = itemService.getActivableItems(true);
		assertThat(itemsActivable.stream()
				.allMatch(item -> item.isActive() == true)).isTrue();
	}

	@Test
	public void testGetItemById() {
		ItemDTO itemActual = itemService.getAllItems().get(0);

		Item itemObtainedById = itemService.getItemById(itemActual.getId())
				.get();

		assertThat(itemObtainedById)
				.isEqualTo(itemMapper.mapItemDTOToItem(itemActual));

	}

	@Test
	public void testGetItemByName() {
		ItemDTO itemActual = itemService.getAllItems().get(0);

		Item itemObtainedById = itemService.getItemByName(itemActual.getName());

		assertThat(itemObtainedById)
				.isEqualTo(itemMapper.mapItemDTOToItem(itemActual));
	}

	private ItemDTO getItemDTOTest() {
		Item item = new Item();
		item.setId("idItemTest");
		item.setName("nameItemTest");
		item.setDescription("descriptionTest");
		item.setActive(true);
		item.setNumber(1);
		item.setDuration(10);
		item.setCreatedBy("system");
		item.setCreatedDate(Instant.now());
		item.setTypeName(TYPE_NAME);

		return new ItemDTO(item);
	}
}
