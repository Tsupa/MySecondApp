package fr.tsupa.mysecondapp.web.rest.vm;

import fr.tsupa.mysecondapp.service.dto.TypeDTO;

public class TypeVM extends TypeDTO {

	private int numberAssociatedItems;

	public TypeVM() {
		// Empty constructor needed for Jackson.
	}

	public TypeVM(String id, boolean active, String description, int duration,
			String name, String imageUrl) {
		super(id, active, description, duration, name, imageUrl);
	}

	public int getNumberAssociatedItems() {
		return numberAssociatedItems;
	}

	public void setNumberAssociatedItems(int numberAssociatedItems) {
		this.numberAssociatedItems = numberAssociatedItems;
	}
}
