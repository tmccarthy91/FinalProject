package catvet.dao;

import java.util.List;
import java.util.Optional;

import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.entity.Owner;

public interface CatVetDao {

	
	List<Doctor> fetchDoctors(String doctorId);
	
	List<Cat> fetchCats(String catId);
	Optional <Cat> addCats(String catId, Long owner_pk, String catName, Integer catAge, Breed breed, String color, boolean neutered, String personality, String notes);
	Optional<Cat> updateCats(String catId, String catName, Integer catAge, Breed breed, String color, boolean neutered,
			String personality, String notes);
	Optional<Cat> deleteCats(String catId);
	Optional<Cat> updateCatDoctor(Long cat_pk, Long doctor_pk);
	
	List<Owner> fetchOwner(String ownerId);
	Optional<Owner> addOwner(String ownerId, String firstName, String lastName);
	Optional<Owner> updateOwner(String ownerId, String firstName, String lastName);
	Optional<Owner> deleteOwner(String ownerId);
	
	
}
