package ptm.home.vo;

import java.util.Map;

public class RoleVO {
	private int id;
	private int role;
	private String name;
	private Map<Integer, String> roleMap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<Integer, String> roleMap) {
		this.roleMap = roleMap;
	}

}
