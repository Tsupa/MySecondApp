package fr.tsupa.mysecondapp.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import fr.tsupa.mysecondapp.domain.Category;
import fr.tsupa.mysecondapp.service.dto.CategoryDTO;

@Service
public class CategoryService {

	public Category createCategory(CategoryDTO category) {
		return null;
	}

	public Set<Category> getAllCategories() {
		return null;
	}

	public Set<Category> getActivableCategories(boolean active) {
		return null;
	}

	public Category getCategory(String id) {
		return null;
	}

	public void removeCategory(String id) {

	}

}
