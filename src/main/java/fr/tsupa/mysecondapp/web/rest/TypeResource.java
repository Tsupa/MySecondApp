package fr.tsupa.mysecondapp.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import fr.tsupa.mysecondapp.service.TypeService;
import fr.tsupa.mysecondapp.web.rest.vm.TypeVM;

@RestController
@RequestMapping("/api")
public class TypeResource {

	private final TypeService typeService;

	public TypeResource(TypeService typeService) {
		this.typeService = typeService;
	}

	@GetMapping("/types/all")
	@Timed
	public ResponseEntity<List<TypeVM>> getActivableTypes() {
		List<TypeVM> types = typeService.getActivableTypesForView(true);
		return new ResponseEntity<>(types, HttpStatus.OK);
	}

}
