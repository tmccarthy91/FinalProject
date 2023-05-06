package catvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.service.CatVetService;

@RestController

public class DefaultDoctorController implements DoctorController {
	@Autowired
	private CatVetService catVetService;
	
	@Override
	public List<Doctor> fetchDoctors(String doctorId) {
		// TODO Auto-generated method stub
		return catVetService.fetchDoctors(doctorId);
	}
	
	@Override
	public Optional<Cat> updateCatDoctor(Long cat_pk, Long doctor_pk) {

		return catVetService.updateCatDoctor(cat_pk, doctor_pk);
	}
}
