package fr.tsupa.mysecondapp.service.dto;

import java.time.Instant;
import java.util.Set;

import fr.tsupa.mysecondapp.domain.Category;
import fr.tsupa.mysecondapp.domain.Item;
import fr.tsupa.mysecondapp.domain.Type;

public class ItemDTO {
	private String id;

	private boolean active = false;

	private String description;

	private int duration;

	private String name;

	private int number;

	private String imageUrl;

	private Type type;

	private Set<Category> categories;

	private Instant lastModifiedDate;

	public ItemDTO() {

	}

	public ItemDTO(Item item) {
		this(item.getId(), item.isActive(), item.getDescription(),
				item.getDuration(), item.getName(), item.getNumber(),
				item.getImageUrl(), item.getType(), item.getCategories(),
				item.getLastModifiedDate());
	}

	public ItemDTO(String id, boolean active, String description, int duration,
			String name, int number, String imageUrl, Type type,
			Set<Category> categories, Instant lastModifiedDate) {
		this.id = id;
		this.active = active;
		this.description = description;
		this.duration = duration;
		this.name = name;
		this.number = number;
		this.imageUrl = imageUrl;
		this.type = type;
		this.categories = categories;
		this.lastModifiedDate = lastModifiedDate;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "ItemDTO [active=" + active + ", description=" + description
				+ ", duration=" + duration + ", name=" + name + ", number="
				+ number + ", imageUrl=" + imageUrl + ", type=" + type
				+ ", categories=" + categories + "]";
	}
}
