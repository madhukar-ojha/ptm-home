package ptm.home.vo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Map;


@Component
@RequestScope
public class EmployeeVO {
	private int id;
	private DesignationVO designation;
	@NotBlank
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	private String displayName;
	private String fullName;
//	private Gender gender;
	private String dateOfBirth;
	private String fatherName;
	private String motherName;
	private int role;
	private int department;
	private String action;
	private String phone;
	private String mobile;
	private String email;
	private String address;
	private int pincode;
	private int state;
	private boolean enabled;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	private Map<Integer, String> departmentMap;
	private Map<Integer, String> roleMap;
	private Map<Integer, String> stateMap;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DesignationVO getDesignation() {
		return designation;
	}

	public void setDesignation(DesignationVO designation) {
		this.designation = designation;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public Map<Integer, String> getStateMap() {
		return stateMap;
	}

	public void setStateMap(Map<Integer, String> stateMap) {
		this.stateMap = stateMap;
	}

	public Map<Integer, String> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Map<Integer, String> departmentMap) {
		this.departmentMap = departmentMap;
	}

	public Map<Integer, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<Integer, String> roleMap) {
		this.roleMap = roleMap;
	}
}
