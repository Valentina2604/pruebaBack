package com.example.prueba.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T01_SOLICITUD")
public class T01SolicitudEntity {
	
	@Id
	@Column(name="id")
	private Integer idSolicitud;
	
	@Column(name="estado")
	private Integer estado;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="monto")
	private BigDecimal monto;
	
	@Column(name="id_cliente")
	private String idCliente;


	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}	

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
}
