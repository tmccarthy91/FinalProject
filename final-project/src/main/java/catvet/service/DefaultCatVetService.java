package catvet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import catvet.dao.CatVetDao;
import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.entity.Owner;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCatVetService implements CatVetService {
	
	@Autowired
	private CatVetDao catVetDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Owner> fetchOwner(String ownerId) {
		log.info("The fetchOwner method was called with ownerId={}", ownerId);
		
		return catVetDao.fetchOwner(ownerId);
	}

	@Override
	public List<Doctor> fetchDoctors(String doctorId) {
		log.info("The fetchDoctor method was called with doctorId={}", doctorId);
		
		return catVetDao.fetchDoctors(doctorId);
	}

	@Override
	public List<Cat> fetchCats(String catId) {
		log.info("The fetchCats method was called with catId={}", catId);
		
		return catVetDao.fetchCats(catId);
	}

	@Override
	public Optional <Cat> addCats(String catId, Long owner_pk, String catName, Integer catAge, Breed breed, String color, boolean neutered,
			String personality, String notes) {
		log.info("The addCats method was called with catId={}, owner_pk={}, catName={}, catAge={}, breed={}, color={}, neutered={}, personality={}, notes={}",
				catId, owner_pk, catName, catAge, breed, color, neutered, personality, notes);
		
		return catVetDao.addCats(catId, owner_pk, catName, catAge, breed, color, neutered, personality, notes);
	}

	@Override
	public Optional<Cat> updateCats(String catId, String catName, Integer catAge, Breed breed, String color,
			boolean neutered, String personality, String notes) {
		log.info("The updateCats method was called with catId={}, catName={}, catAge={}, breed={}, color={}, neutered={}, personality={}, notes={}",
				catId, catName, catAge, breed, color, neutered, personality, notes);
		
		return catVetDao.updateCats(catId, catName, catAge, breed, color, neutered, personality, notes);
	}

	@Override
	public Optional<Cat> deleteCats(String catId) {
		log.info("The deleteCats method was called with catId={}", catId);
		
		return catVetDao.deleteCats(catId);
	}

	@Override
	public Optional<Cat> updateCatDoctor(Long cat_pk, Long doctor_pk) {
		log.info("The updateCatDoctor method was called with cat_pk={}, doctor_pk={}", cat_pk, doctor_pk);
		
		return catVetDao.updateCatDoctor(cat_pk, doctor_pk);
	}

	@Override
	public Optional<Owner> addOwner(String ownerId, String firstName, String lastName) {
		log.info("The addOwner method was called with ownerId={}, firstName={}, lastName={}", ownerId, firstName, lastName);
		
		return catVetDao.addOwner(ownerId, firstName, lastName);
	}

	@Override
	public Optional<Owner> updateOwner(String ownerId, String firstName, String lastName) {
		log.info("The updateOwner method was called with ownerId={}, firstName={}, lastName={}", ownerId, firstName, lastName);		
		
		return catVetDao.updateOwner(ownerId, firstName, lastName);
	}

	@Override
	public Optional<Owner> deleteOwner(String ownerId) {
		log.info("The deleteOwner method was called with ownerId={}", ownerId);
		
		return catVetDao.deleteOwner(ownerId);
	}


}
