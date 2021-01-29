package com.commons.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2029916456710031685L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String username;
	
	@Column(unique = true, length = 60)
	private String password;
	
	private Boolean enabled;
	private String nombre;
	private String apellido;
	
	//@Email
	@Column(unique = true, length = 100)
	public String email;
	
	
	@ManyToMany(fetch =  FetchType.LAZY)
	@JoinTable(name = "usuarios_roles",
	joinColumns = @JoinColumn(name="usuario_id", referencedColumnName="id"), 
	inverseJoinColumns = @JoinColumn(name="roles_id" ,referencedColumnName="id"), //Referenciabas  a una tabla externa como el FOREIGN KEY de MYSQL
	uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "roles_id"})})
	private List<Rol> roles;
	
	
	private String company;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	
	

}