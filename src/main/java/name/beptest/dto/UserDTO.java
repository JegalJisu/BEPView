package name.beptest.dto;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "USER_TBL")
public class UserDTO {
	@Column
	private String idx;
	@Column
	private String id;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String nickname;
	@Column
	private String email;
	@Column(name = "REG_DATE")
	private String regDate;
	@Column(name = "CHG_DATE")
	private String chgDate;
}
