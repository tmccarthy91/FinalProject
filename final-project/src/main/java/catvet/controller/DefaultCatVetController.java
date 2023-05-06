package catvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.service.CatVetService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultCatVetController implements CatVetController {

	@Autowired
	private CatVetService catVetService;
	
	@Override
	public Optional<Cat> addCats(String catId, Long owner_pk, String catName, Integer catAge, Breed breed, String color,
			boolean neutered, String personality, String notes) {
		
		return catVetService.addCats(catId, owner_pk, catName, catAge, breed, color, neutered, personality, notes);
	}

	@Override
	public List<Cat> fetchCats(String catId) {
		
		return catVetService.fetchCats(catId);
	}

	@Override
	public Optional<Cat> updateCats(String catId, String catName, Integer catAge, Breed breed, String color,
			boolean neutered, String personality, String notes) {
		
		return catVetService.updateCats(catId, catName, catAge, breed, color, neutered, personality, notes);
	}

	@Override
	public Optional<Cat> deleteCats(String catId) {
		
		return catVetService.deleteCats(catId);
				
	}



}
