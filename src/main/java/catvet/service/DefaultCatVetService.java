package catvet.service;

import org.springframework.beans.factory.annotation.Autowired;

import catvet.dao.CatVetDao;
import catvet.entity.Cat;

public class DefaultCatVetService implements CatVetService {
	
	@Autowired
	private CatVetDao catVetDao;
	
	public Cat addCat(Cat cat) {
		catVetDao.add
		return null;
	}

	public Cat fetchCatById(String catId) {
		// TODO Auto-generated method stub
		return null;
	}

}
