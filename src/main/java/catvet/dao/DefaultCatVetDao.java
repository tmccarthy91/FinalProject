package catvet.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.promineotech.jeep.dao.DefaultJeepOrderDao.SqlParams;
import com.promineotech.jeep.entity.Color;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.Tire;

import catvet.entity.Breed;
import catvet.entity.Cat;
import catvet.entity.Doctor;
import catvet.entity.Owner;

public class DefaultCatVetDao implements CatVetDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<Cat> fetchCatById(String catId) {

		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM cats "
				+ "WHERE catId = :catId";
		// @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("catId", catId);

		return Optional.ofNullable(jdbcTemplate.query(sql, params, new CatResultSetExtractor()));
	}

	@Override
	public Optional<Doctor> fetchDoctors(String doctorId) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM doctors "
	        + "WHERE doctorId = :doctorId";
	    // @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("doctorId", doctorId);

		return Optional.ofNullable(jdbcTemplate.query(sql, params, new DoctorResultSetExtractor()));
	}

	@Override
	public Optional<Owner> fetchOwner(String ownerId) {
		// @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM owners "
	        + "WHERE ownerId = :ownerId";
	    // @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("ownerId", ownerId);

		return Optional.ofNullable(jdbcTemplate.query(sql, params, new OwnerResultSetExtractor()));
	}

	
	//data set extractors
	
	class DoctorResultSetExtractor implements ResultSetExtractor<Doctor> {
		    @Override
		    public Doctor extractData(ResultSet rs) throws SQLException {
		      rs.next();

		      // @formatter:off
		      return Doctor.builder()
		          .doctorId(rs.getString("doctorId"))
		          .doctorPk(rs.getLong("doctor_pk"))
		          .firstName(rs.getString("firstName"))
		          .lastName(rs.getString("lastName"))
		          .build();
		      // @formatter:on

		    }
		  }
	
	class CatResultSetExtractor implements ResultSetExtractor<Cat> {
	    @Override
	    public Cat extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Cat.builder()
	          .catId(rs.getString("catId"))
	          .catPk(rs.getLong("cat_pk"))
	          .catName(rs.getString("catName"))
	          .catAge(rs.getInt("age"))
	          .breed(Breed.valueOf(rs.getString("breed")))
	          .color(rs.getString("color"))
	          .personality(rs.getString("personality"))
	          .notes(rs.getString("notes"))
	          .build();
	      // @formatter:on

	    }
	  }
	
	class OwnerResultSetExtractor implements ResultSetExtractor<Owner> {
	    @Override
	    public Owner extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Owner.builder()
	          .ownerId(rs.getString("ownerId"))
	          .ownerPk(rs.getLong("owner_pk"))
	          .firstName(rs.getString("firstName"))
	          .lastName(rs.getString("lastName"))
	          .build();
	      // @formatter:on

	    }
	  }
	class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }
	
	private SqlParams generateInsertSql(String ownerId, String firstName, String lastName) {
		SqlParams params = new SqlParams();
		
		// @formatter:off
		params.sql = ""
				+ "INSERT INTO owners ("
				+ "ownerId, firstName, lastName" 
				+ ") VALUES ("
				+ ":ownerId, :firstname, :lastName"
				+ ")";
		
		return params;
	}
	
	private SqlParams generateInsertSql
	(String catId, String catName, Integer catAge, Breed breed, String color, boolean neutered, String personality, String notes) {
		SqlParams params = new SqlParams();
		
		// @formatter:off
		params.sql = ""
				+ "INSERT INTO cats ("
				+ "catId, catName, catAge, breed, color, neutered, personality, notes" 
				+ ") VALUES ("
				+ ":catId, :catName, :catAge, :breed, :color, :neutered, :personality, :notes" 
				+ ")";
		
		return params;
	}
	
	private SqlParams generateInsertSql(Long catPk, Long doctorPk) {
	    SqlParams params = new SqlParams();
	    
	    // @formatter:off
	    params.sql = ""
	        + "INSERT INTO cat_doctor ("
	        + "cat_fk, doctor_fk"
	        + ") VALUES ("
	        + ":cat_fk, :doctor_fk"
	        + ")";
	    // @formatter:on
	    
	    params.source.addValue("cat_fk", catPk);
	    params.source.addValue("doctor_fk", doctorPk);
	    
	    return params;
	  }
	
	@Override
	public Cat addCat
	(String catId, String catName, Integer catAge, Breed breed, String color, boolean neutered, String personality, String notes){
		
		SqlParams params = generateInsertSql(customer, jeep, color, engine, tire, price);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		
		Long catPK = keyHolder.getKey().longValue();
		saveOptions(options, orderPK);
		
		// @formatter:off
		return Cat.builder()
				.orderPK(catPk)
				.customer(customer)
				.model(jeep)
				.color(color)
				.engine(engine)
				.tire(tire)
				.options(options)
				.price(price)
				.build();
		// @formatter:on
	}
}
