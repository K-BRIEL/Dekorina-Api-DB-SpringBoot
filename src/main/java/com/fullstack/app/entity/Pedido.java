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
@Table(name = "pedidos")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private String clientName;
	private Long idClient;
	private String productos;
	private double importe;
	private double adelanto;
	private double restaPagar;
	private Boolean terminado;
	private Boolean entregado;
	private Boolean pago;
	private String nota;
	private LocalDate fechaEntregaPactada;
	private LocalDate fechaEntrega;
	
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Boolean getTerminado() {
		return terminado;
	}
	public void setTerminado(Boolean terminado) {
		this.terminado = terminado;
	}
	public Boolean getEntregado() {
		return entregado;
	}
	public void setEntregado(Boolean entregado) {
		this.entregado = entregado;
	}
	public Boolean getPago() {
		return pago;
	}
	public void setPago(Boolean pago) {
		this.pago = pago;
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
		return clientName;
	}
	public void setName(String name) {
		this.clientName = name;
	}

	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getProductos() {
		return productos;
	}
	public void setProductos(String productos) {
		this.productos = productos;
	}
	public double getAdelanto() {
		return adelanto;
	}
	public void setAdelanto(double adelanto) {
		this.adelanto = adelanto;
	}
	public double getRestaPagar() {
		return restaPagar;
	}
	public void setRestaPagar(double restaPagar) {
		this.restaPagar = restaPagar;
	}
	
	
}
