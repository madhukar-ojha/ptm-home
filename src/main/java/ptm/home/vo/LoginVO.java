package ptm.home.vo;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Component
public class LoginVO implements Serializable{

//	@NumberFormat
//	@Max(value = 999, message = "id must be of 3 digits")
//	@Min(value = 100, message = "id must be of 3 digits")
	private int id;
	@Size(min = 6, max = 20, message = "Password lenght must be between 6 and 20 characters ")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
