package catvet.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Owner {
	private Long ownerPk;
	private String ownerId;
	private String firstName;
	private String lastName;
}
