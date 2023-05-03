package catvet.dao;

import java.util.List;
import java.util.Optional;

import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.entity.Owner;

public interface CatVetDao {

	Optional<Cat> fetchCat(String catId);
	Optional<Owner> fetchOwner(String ownerId);
	Optional<Doctor> fetchDoctors(String doctorId);
	
	Cat saveCat(Cat cat, Owner owner,)

}
