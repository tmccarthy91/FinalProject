package catvet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import catvet.entity.Owner;
import catvet.service.CatVetService;

@RestController

public class DefaultOwnerController implements OwnerController {
	
	@Autowired
	private CatVetService catVetService;
	
	@Override
	public List<Owner> fetchOwner(String ownerId) {
		// TODO Auto-generated method stub
		return catVetService.fetchOwner(ownerId);
	}

	@Override
	public Optional <Owner> addOwner(String ownerId, String firstName, String lastName) {
		// TODO Auto-generated method stub
		return catVetService.addOwner(ownerId, firstName, lastName);
	}

	@Override
	public Optional<Owner> updateOwner(String ownerId, String firstName, String lastName) {
		// TODO Auto-generated method stub
		return catVetService.updateOwner(ownerId, firstName, lastName);
	}

	@Override
	public Optional<Owner> deleteOwner(String ownerId) {
		// TODO Auto-generated method stub
		return catVetService.deleteOwner(ownerId);
	}

}
