package catvet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Cat {
	private Long cat_pk;
	private Long owner_pk;
	private Long doctor_pk;
	private String catId;
	private String catName;
	private Integer catAge;
	private Breed breed;
	private String color;
	private boolean neutered;
	private String personality;
	private String notes;
//	private LocalDateTime createdAt;
	
//	public String toString() {
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
//		String createTime = Objects.nonNull(createdAt) ? fmt.format(createdAt) : "(null)";
//		
//		String cat = "";
//		
//		cat += "\n   ID=" + catId;
//		cat += "\n   Patient Name= " + catName;
//		cat += "\n   Patient Age= " + catName;
//		cat += "\n   Patient Breed= " + breed;
//		cat += "\n   Patient Color= " + color;
//		cat += "\n   Neutered Status= " + neutered;
//		cat += "\n   Personality= " + personality;
//		cat += "\n   Notes= " + notes;
//		cat += "\n   createdAt= " + createTime;
//		
//		return cat;
//	}

	
}
