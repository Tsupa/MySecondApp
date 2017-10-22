package fr.tsupa.mysecondapp.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.tsupa.mysecondapp.domain.Type;
import fr.tsupa.mysecondapp.service.dto.TypeDTO;

@Service
public class TypeMapper {

	public TypeDTO mapTypeToTypeDTO(Type type) {
		return new TypeDTO(type);
	}

	public Type mapTypeDTOToType(TypeDTO typeDTO) {
		if (typeDTO == null) {
			return null;
		} else {
			Type type = new Type();

			type.setId(typeDTO.getId());
			type.setActive(typeDTO.isActive());
			type.setDescription(typeDTO.getDescription());
			type.setDuration(typeDTO.getDuration());
			type.setName(typeDTO.getName());
			type.setImageUrl(typeDTO.getImageUrl());

			return type;
		}
	}

	public List<TypeDTO> mapTypesToTypeDTOs(List<Type> types) {
		return types.stream().filter(Objects::nonNull)
				.map(this::mapTypeToTypeDTO).collect(Collectors.toList());
	}

}
