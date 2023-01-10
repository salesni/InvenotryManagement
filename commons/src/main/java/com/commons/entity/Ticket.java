package com.commons.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name = "ticket")
public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 2029916456710031685L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne()
    @JoinColumn(name="usuario", referencedColumnName = "username")
	private Usuario usuario;
	
	private Double impuesto;
	private Double subtotal;
	private Double total;
	
	
	@ManyToMany(fetch =  FetchType.LAZY)
	@JoinTable(name = "ticket_detalles",
	joinColumns = @JoinColumn(name="ticket_id", referencedColumnName="id"), 
	inverseJoinColumns = @JoinColumn(name="detalles_id" ,referencedColumnName="id"), //Referenciabas  a una tabla externa como el FOREIGN KEY de MYSQL
	uniqueConstraints = {@UniqueConstraint(columnNames = {"ticket_id", "detalles_id"})})
	private List<Detalles> detalles;


	
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(Double impuesto) {
		this.impuesto = impuesto;
	}


	public Double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public List<Detalles> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<Detalles> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
	
	
