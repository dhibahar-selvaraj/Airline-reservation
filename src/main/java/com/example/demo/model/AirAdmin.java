package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AIR_ADMIN database table.
 * 
 */
@Entity
@Table(name="AIR_ADMIN")
@NamedQuery(name="AirAdmin.findAll", query="SELECT a FROM AirAdmin a")
public class AirAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ADMIN_ID")
	private String adminId;

	@Column(name="ADMIN_PASSWORD")
	private String adminPassword;

	public AirAdmin() {
	}

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}