package fr.tsupa.mysecondapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.tsupa.mysecondapp.domain.Type;
import fr.tsupa.mysecondapp.repository.TypeRepository;
import fr.tsupa.mysecondapp.service.dto.TypeDTO;
import fr.tsupa.mysecondapp.service.mapper.TypeMapper;
import fr.tsupa.mysecondapp.web.rest.vm.TypeVM;

@Service
public class TypeService {

	private final TypeRepository typeRepository;

	private final ItemService itemService;

	private final TypeMapper typeMapper;

	public TypeService(TypeRepository typeRepository, TypeMapper typeMapper,
			ItemService itemService) {
		this.typeRepository = typeRepository;
		this.typeMapper = typeMapper;
		this.itemService = itemService;
	}

	public Type createType(TypeDTO typeDTO) {
		Type type = typeMapper.mapTypeDTOToType(typeDTO);
		typeRepository.save(type);
		return type;
	}

	public List<TypeDTO> getAllTypes() {
		return typeMapper.mapTypesToTypeDTOs(this.typeRepository.findAll());
	}

	public List<TypeDTO> getActivableTypes(boolean active) {
		return typeMapper.mapTypesToTypeDTOs(
				this.typeRepository.findAllByActive(active));
	}

	public List<TypeVM> getActivableTypesForView(boolean active) {
		List<TypeDTO> listType = typeMapper.mapTypesToTypeDTOs(
				this.typeRepository.findAllByActive(active));
		List<TypeVM> typesVM = getListTypeForView(listType);
		return typesVM;

	}

	private List<TypeVM> getListTypeForView(List<TypeDTO> listType) {
		return listType.stream().map(type -> {
			TypeVM typeView = new TypeVM(type.getId(), type.isActive(),
					type.getDescription(), type.getDuration(), type.getName(),
					type.getImageUrl());
			int numberAssociatedItems = itemService
					.getItemsByTypeName(type.getName()).size();
			typeView.setNumberAssociatedItems(numberAssociatedItems);
			return typeView;
		}).collect(Collectors.toList());
	}

	public Type getTypeByName(String name) {
		return this.typeRepository.findOneByName(name).orElse(null);
	}

	public Type getTypeById(String id) {
		return this.typeRepository.findOneById(id).orElse(null);
	}

	public void removeType(String id) {
		this.typeRepository.findOneById(id).ifPresent(item -> {
			this.typeRepository.delete(item);
		});

	}

}
