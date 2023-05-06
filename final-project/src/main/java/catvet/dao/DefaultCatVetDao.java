package catvet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.entity.Owner;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCatVetDao implements CatVetDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
//returns list of doctor

	@Override
	public List<Doctor> fetchDoctors(String doctorId) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM doctors "
	        + "WHERE doctorId = :doctorId";
	    // @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("doctorId", doctorId);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
		    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
		      // @formatter:off
		      return Doctor.builder()
		          .doctorId(rs.getString("doctorId"))
		          .doctor_pk(rs.getLong("doctor_pk"))
		          .firstName(rs.getString("firstName"))
		          .lastName(rs.getString("lastName"))
		          .build();
		      // @formatter:on

		    }});
	}

//cat methods
	
	@Override
	public List<Cat> fetchCats(String catId) {

		// @formatter:off
				String sql = ""
						+ "SELECT * "
						+ "FROM cats "
						+ "WHERE catId = :catId";
				// @formatter:on
				
			Map<String, Object> params = new HashMap<>();
			params.put("catId", catId);
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {

				@Override
				public Cat mapRow(ResultSet rs, int rowNum) throws SQLException {

	      // @formatter:off
	      return Cat.builder()
	          .catId(rs.getString("catId"))
	          .owner_pk(rs.getLong("owner_pk"))
	          .cat_pk(rs.getLong("cat_pk"))
	          .catName(rs.getString("catName"))
	          .catAge(rs.getInt("catAge"))
	          .breed(Breed.valueOf(rs.getString("breed")))
	          .color(rs.getString("color"))
	          .personality(rs.getString("personality"))
	          .notes(rs.getString("notes"))
	          .build();
	      // @formatter:on
		
			   }});
				}
	
	@Override
	public Optional<Cat> addCats
	(String catId, Long owner_pk, String catName, Integer catAge, Breed breed, String color, boolean neutered, String personality, String notes){
		
		// @formatter:off
		String sql = ""
				+ "INSERT INTO cats ("
				+ "catId, owner_pk, catName, catAge, breed, color, neutered, personality, notes" 
				+ ") VALUES ("
				+ ":catId, :owner_pk, :catName, :catAge, :breed, :color, :neutered, :personality, :notes" 
				+ ")";
		// @formatter:on
		Map<String, Object> params = new HashMap<>();
		params.put("catId", catId);
		params.put("owner_pk", owner_pk);
		params.put("catName", catName);
		params.put("catAge", catAge);
		params.put("breed", breed.toString());
		params.put("color", color);
		params.put("neutered", neutered);
		params.put("personality", personality);
		params.put("notes", notes);
		// @formatter:off
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Cat.builder()	
				.catId(catId)
				.owner_pk(owner_pk)
				.catName(catName)
				.catAge(catAge)
				.breed(breed)
				.color(color)
				.neutered(neutered)
				.personality(personality)
				.notes(notes)
				.build());
		// @formatter:on
	}

	@Override
	public Optional<Cat> updateCats
	(String catId, String catName, Integer catAge, Breed breed, String color, boolean neutered, String personality, String notes){
		
		// @formatter:off
		String sql = ""
				+ "UPDATE cats SET "
				+ "catName = :catName, "
				+ "catAge = :catAge, "
				+ "breed = :breed, "
				+ "color = :color, "
				+ "neutered = :neutered, "
				+ "personality = :personality, "
				+ "notes = :notes "
				+ "WHERE catId = :catId";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("catId", catId);
		params.put("catName", catName);
		params.put("catAge", catAge);
		params.put("breed", breed.toString());
		params.put("color", color);
		params.put("neutered", neutered);
		params.put("personality", personality);
		params.put("notes", notes);
		// @formatter:off
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Cat.builder()	
				.catId(catId)
				.catName(catName)
				.catAge(catAge)
				.breed(breed)
				.color(color)
				.neutered(neutered)
				.personality(personality)
				.notes(notes)
				.build());
		// @formatter:on
	}
	
	@Override
	public Optional<Cat> deleteCats(String catId){
		
		// @formatter:off
		String sql = ""
				+ "DELETE FROM cats WHERE "
				+ "catId = :catId";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("catId", catId);
		// @formatter:off
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Cat.builder()	
				.catId(catId)
				.build());
		// @formatter:on
	}

	@Override
	public Optional<Cat> updateCatDoctor (Long cat_pk, Long doctor_pk){
		
		// @formatter:off
		String sql = ""
		        + "INSERT INTO cat_doctor ("
		        + "cat_fk, doctor_fk"
		        + ") VALUES ("
		        + ":cat_pk, :doctor_pk"
		        + ")";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("cat_pk", cat_pk);
		params.put("doctor_pk", doctor_pk);
		
		// @formatter:off
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Cat.builder()	
				.cat_pk(cat_pk)
				.doctor_pk(doctor_pk)
				.build());
		// @formatter:on
	}

//owner methods
	
	@Override
	public List<Owner> fetchOwner(String ownerId) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM owners "
	        + "WHERE ownerId = :ownerId";
	    // @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("ownerId", ownerId);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {
				@Override
			    public Owner mapRow(ResultSet rs, int numRow) throws SQLException {
		
			      // @formatter:off
			      return Owner.builder()
			          .ownerId(rs.getString("ownerId"))
			          .owner_pk(rs.getLong("owner_pk"))
			          .firstName(rs.getString("firstName"))
			          .lastName(rs.getString("lastName"))
			          .build();
			      // @formatter:on
		
				}});
	}

	@Override
	public Optional<Owner> addOwner(String ownerId, String firstName, String lastName) {
		// @formatter:off
				String sql = ""
						+ "INSERT INTO owners ("
						+ "ownerId, firstName, lastName" 
						+ ") VALUES ("
						+ ":ownerId, :firstName, :lastName" 
						+ ")";
				// @formatter:on
				Map<String, Object> params = new HashMap<>();
				params.put("ownerId", ownerId);
				params.put("firstName", firstName);
				params.put("lastName", lastName);
				// @formatter:off
				
				jdbcTemplate.update(sql, params);
				
				return Optional.ofNullable(Owner.builder()	
						.ownerId(ownerId)
						.firstName(firstName)
						.lastName(lastName)
						.build());
				// @formatter:on
	}

	@Override
	public Optional<Owner> updateOwner(String ownerId, String firstName, String lastName) {
		// @formatter:off
				String sql = ""
						+ "UPDATE owners SET "
						+ "firstName = :firstName, "
						+ "lastName = :lastName "
						+ "WHERE ownerId = :ownerId";
				
				// @formatter:on
				Map<String, Object> params = new HashMap<>();
				params.put("ownerId", ownerId);
				params.put("firstName", firstName);
				params.put("lastName", lastName);
				// @formatter:off
				
				jdbcTemplate.update(sql, params);
				
				return Optional.ofNullable(Owner.builder()	
						.ownerId(ownerId)
						.firstName(firstName)
						.lastName(lastName)
						.build());
				// @formatter:on
	}

	@Override
	public Optional<Owner> deleteOwner(String ownerId) {
		// @formatter:off
		String sql = ""
				+ "DELETE FROM owners WHERE "
				+ "ownerId = :ownerId";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("ownerId", ownerId);
		// @formatter:off
		
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Owner.builder()	
				.ownerId(ownerId)
				.build());
		// @formatter:on
	}

}
