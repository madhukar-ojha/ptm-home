package ptm.home.vo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "displayName", "fullName", "nickName", "gender", "department", "role", "designation",
		"dateOfBirth", "fatherName", "motherName", "phone", "mobile", "email", "address", "pincode", "state", "active",
		"deleted", "createdBy", "createdOn", "updatdeBy", "updatdeOn" })
public class EmployeeJSonVO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("displayName")
	private String displayName;
	@JsonProperty("fullName")
	private Object fullName;
	@JsonProperty("nickName")
	private Object nickName;
	@JsonProperty("gender")
	private Object gender;
	@JsonProperty("department")
	private Integer department;
	@JsonProperty("role")
	private Integer role;
	@JsonProperty("designation")
	private String designation;
//	@JsonProperty("dateOfBirth")
//	private Date dateOfBirth;
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	@JsonProperty("fatherName")
	private String fatherName;
	@JsonProperty("motherName")
	private String motherName;
	@JsonProperty("phone")
	private Object phone;
	@JsonProperty("mobile")
	private String mobile;
	@JsonProperty("email")
	private Object email;
	@JsonProperty("address")
	private Object address;
	@JsonProperty("pincode")
	private Integer pincode;
	@JsonProperty("state")
	private Object state;
	@JsonProperty("active")
	private Object active;
	@JsonProperty("deleted")
	private Object deleted;
	@JsonProperty("createdBy")
	private Integer createdBy;
	@JsonProperty("createdOn")
	private Object createdOn;
	@JsonProperty("updatdeBy")
	private Integer updatdeBy;
	@JsonProperty("updatdeOn")
	private Object updatdeOn;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("displayName")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("displayName")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonProperty("fullName")
	public Object getFullName() {
		return fullName;
	}

	@JsonProperty("fullName")
	public void setFullName(Object fullName) {
		this.fullName = fullName;
	}

	@JsonProperty("nickName")
	public Object getNickName() {
		return nickName;
	}

	@JsonProperty("nickName")
	public void setNickName(Object nickName) {
		this.nickName = nickName;
	}

	@JsonProperty("gender")
	public Object getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(Object gender) {
		this.gender = gender;
	}

	@JsonProperty("department")
	public Integer getDepartment() {
		return department;
	}

	@JsonProperty("department")
	public void setDepartment(Integer department) {
		this.department = department;
	}

	@JsonProperty("role")
	public Integer getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(Integer role) {
		this.role = role;
	}

	@JsonProperty("designation")
	public String getDesignation() {
		return designation;
	}

	@JsonProperty("designation")
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/*
	 * @JsonProperty("dateOfBirth") public Date getDateOfBirth() { return
	 * dateOfBirth; }
	 * 
	 * @JsonProperty("dateOfBirth") public void setDateOfBirth(Date dateOfBirth) {
	 * this.dateOfBirth = dateOfBirth; }
	 */

	@JsonProperty("dateOfBirth")
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	@JsonProperty("dateOfBirth")
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@JsonProperty("fatherName")
	public String getFatherName() {
		return fatherName;
	}

	@JsonProperty("fatherName")
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@JsonProperty("motherName")
	public String getMotherName() {
		return motherName;
	}

	@JsonProperty("motherName")
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@JsonProperty("phone")
	public Object getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(Object phone) {
		this.phone = phone;
	}

	@JsonProperty("mobile")
	public String getMobile() {
		return mobile;
	}

	@JsonProperty("mobile")
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@JsonProperty("email")
	public Object getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(Object email) {
		this.email = email;
	}

	@JsonProperty("address")
	public Object getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Object address) {
		this.address = address;
	}

	@JsonProperty("pincode")
	public Integer getPincode() {
		return pincode;
	}

	@JsonProperty("pincode")
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@JsonProperty("state")
	public Object getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(Object state) {
		this.state = state;
	}

	@JsonProperty("active")
	public Object getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(Object active) {
		this.active = active;
	}

	@JsonProperty("deleted")
	public Object getDeleted() {
		return deleted;
	}

	@JsonProperty("deleted")
	public void setDeleted(Object deleted) {
		this.deleted = deleted;
	}

	@JsonProperty("createdBy")
	public Integer getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("createdBy")
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("createdOn")
	public Object getCreatedOn() {
		return createdOn;
	}

	@JsonProperty("createdOn")
	public void setCreatedOn(Object createdOn) {
		this.createdOn = createdOn;
	}

	@JsonProperty("updatdeBy")
	public Integer getUpdatdeBy() {
		return updatdeBy;
	}

	@JsonProperty("updatdeBy")
	public void setUpdatdeBy(Integer updatdeBy) {
		this.updatdeBy = updatdeBy;
	}

	@JsonProperty("updatdeOn")
	public Object getUpdatdeOn() {
		return updatdeOn;
	}

	@JsonProperty("updatdeOn")
	public void setUpdatdeOn(Object updatdeOn) {
		this.updatdeOn = updatdeOn;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}