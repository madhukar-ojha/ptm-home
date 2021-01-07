package ptm.home.entity;
// Generated Jun 7, 2020 7:43:22 AM by Hibernate Tools 5.2.12.Final

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "ptm_dev")
public class Role implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedBy")
	private Employee updatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy", nullable = false)
	private Employee createdBy;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "description", length = 50)
	private String description;

	@Column(name = "enabled", nullable = false, length = 5)
	private String enabled;

	@Column(name = "deleted", nullable = false, length = 5)
	private String deleted;

	@Column(name = "createdOn", nullable = false, length = 26)
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "updatedOn", length = 26)
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Designation> designations = new HashSet<Designation>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Designation> designations_1 = new HashSet<Designation>(0);

	public Role() {
	}

	public Role(Employee createdBy, String name, String enabled, String deleted, LocalDateTime createdOn) {
		this.createdBy = createdBy;
		this.name = name;
		this.enabled = enabled;
		this.deleted = deleted;
		this.createdOn = createdOn;
	}

	public Role(Employee updatedBy, Employee createdBy, String name, String description, String enabled, String deleted,
			LocalDateTime createdOn, LocalDateTime updatedOn, Set<Designation> designations,
			Set<Designation> designations_1) {
		this.updatedBy = updatedBy;
		this.createdBy = createdBy;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.deleted = deleted;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.designations = designations;
		this.designations_1 = designations_1;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Employee getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getDeleted() {
		return this.deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Set<Designation> getDesignations() {
		return this.designations;
	}

	public void setDesignations(Set<Designation> designations) {
		this.designations = designations;
	}

	public Set<Designation> getDesignations_1() {
		return this.designations_1;
	}

	public void setDesignations_1(Set<Designation> designations_1) {
		this.designations_1 = designations_1;
	}

}