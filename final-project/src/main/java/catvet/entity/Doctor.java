package catvet.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Doctor {
	private Long doctor_pk;
	private String doctorId;
	private String firstName;
	private String lastName;
}
