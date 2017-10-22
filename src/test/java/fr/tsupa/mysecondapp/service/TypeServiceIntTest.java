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
import fr.tsupa.mysecondapp.domain.Type;
import fr.tsupa.mysecondapp.service.dto.TypeDTO;
import fr.tsupa.mysecondapp.service.mapper.TypeMapper;
import fr.tsupa.mysecondapp.web.rest.vm.TypeVM;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySecondApp.class)
public class TypeServiceIntTest {

	@Autowired
	private TypeService typeService;

	@Autowired
	private TypeMapper typeMapper;

	@Test
	public void testCreateAndRemoveType() {
		TypeDTO typeDTO = getTypeDTOTest();
		Type typeMapped = typeMapper.mapTypeDTOToType(typeDTO);

		Type typeCreate = typeService.createType(typeDTO);

		assertThat(typeCreate).isEqualTo(typeMapped);

		typeService.removeType(typeCreate.getId());

		assertThat(typeService.getTypeById(typeCreate.getId())).isNull();
	}

	@Test
	public void testGetAllTypes() {
		int nbBeforeInsert = typeService.getAllTypes().size();
		Type typeCreate = typeService.createType(getTypeDTOTest());
		int nbAfterInsert = typeService.getAllTypes().size();
		assertThat(nbBeforeInsert + 1).isEqualTo(nbAfterInsert);

		typeService.removeType(typeCreate.getId());

	}

	@Test
	public void testGetActivableTypes() {
		List<TypeDTO> typesActivable = typeService.getActivableTypes(true);
		assertThat(typesActivable.stream()
				.allMatch(type -> type.isActive() == true)).isTrue();
	}

	@Test
	public void testgetActivableTypesForView() {
		List<TypeVM> typesActivable = typeService
				.getActivableTypesForView(true);
		assertThat(typesActivable.stream()
				.allMatch(type -> type.isActive() == true)).isTrue();
	}

	@Test
	public void testGetTypeById() {
		TypeDTO typeActual = typeService.getAllTypes().get(0);

		Type typeObtainedById = typeService.getTypeById(typeActual.getId());

		assertThat(typeObtainedById)
				.isEqualTo(typeMapper.mapTypeDTOToType(typeActual));

	}

	@Test
	public void testGetTypeByName() {
		TypeDTO typeActual = typeService.getAllTypes().get(0);

		Type typeObtainedById = typeService.getTypeByName(typeActual.getName());

		assertThat(typeObtainedById)
				.isEqualTo(typeMapper.mapTypeDTOToType(typeActual));
	}

	private TypeDTO getTypeDTOTest() {
		Type type = new Type();
		type.setId("idTypeTest");
		type.setName("nameTypeTest");
		type.setDescription("descriptionTest");
		type.setActive(true);
		type.setDuration(10);
		type.setCreatedBy("system");
		type.setCreatedDate(Instant.now());

		return new TypeDTO(type);
	}
}
