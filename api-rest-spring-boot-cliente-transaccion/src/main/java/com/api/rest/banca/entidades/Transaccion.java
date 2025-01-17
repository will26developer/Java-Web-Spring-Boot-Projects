package com.api.rest.banca.entidades;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacciones")
public class Transaccion { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaccion_id")
	private Long id;
	@Column(name = "transaccion_iban1")
	private String ibanProp;
	@Column(name = "trassacion_iban2")
	private String ibanDest;
	@Column(name = "transsacion_monto")
	private Double monto;
	@Column(name = "transaccion_descprt")
	private String descripcion;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "cliente_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cliente cliente;
	
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIbanProp() {
		return ibanProp;
	}

	public void setIbanProp(String ibanProp) {
		this.ibanProp = ibanProp;
	}

	public String getIbanDest() {
		return ibanDest;
	}

	public void setIbanDest(String ibanDest) {
		this.ibanDest = ibanDest;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
