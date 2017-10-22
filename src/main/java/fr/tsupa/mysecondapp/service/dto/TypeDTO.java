package fr.tsupa.mysecondapp.service.dto;

import fr.tsupa.mysecondapp.domain.Type;

public class TypeDTO {
	private String id;

	private boolean active;

	private String description;

	private int duration;

	private String name;

	private String imageUrl;

	public TypeDTO() {

	}

	public TypeDTO(Type type) {
		this(type.getId(), type.isActive(), type.getDescription(),
				type.getDuration(), type.getName(), type.getImageUrl());
	}

	public TypeDTO(String id, boolean active, String description, int duration,
			String name, String imageUrl) {
		this.id = id;
		this.active = active;
		this.description = description;
		this.duration = duration;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "TypeDTO [id=" + id + ", active=" + active + ", description="
				+ description + ", duration=" + duration + ", name=" + name
				+ "]";
	}
}
