package name.beptest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name = "USER_TBL")
@Table(name = "USER_TBL")
public class UserDTO {
	@Id
	@Column
	private String idx;
	@Column
	private String id;
	@Column
	private String password;
	@Column
	private String name;
	@Column
	private String email;
	@Column(name = "USER_ROLE")
	private String userRole;
	@Column(name = "REG_DATE")
	private String regDate;
	@Column(name = "CHG_DATE")
	private String chgDate;
	
	@Override
	public String toString() {
		return "UserDTO [idx=" + idx + ", id=" + id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", userRole=" + userRole + ", regDate=" + regDate + ", chgDate=" + chgDate + "]";
	}
}
