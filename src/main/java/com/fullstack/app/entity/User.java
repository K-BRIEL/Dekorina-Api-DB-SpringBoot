package com.fullstack.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String name;
	private String surname;
	private int phone;
	private String email;
	private double adeuda;
	private String compras;
	private String nota;
	private String contacto;
	private LocalDate fechaIngreso ;
	private LocalDate ultimaCompra;
	
	public String getCompras() {
		return compras;
	}
	public void setCompras(String compras) {
		this.compras = compras;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAdeuda() {
		return adeuda;
	}
	public void setAdeuda(double adeuda) {
		this.adeuda = adeuda;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public LocalDate getUltimaCompra() {
		return ultimaCompra;
	}
	public void setUltimaCompra(LocalDate ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}
	
	
}
