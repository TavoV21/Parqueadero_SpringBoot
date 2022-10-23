package com.clientes.parqueo.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;
	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;
	@Column(name = "vehiculo", length = 60, nullable = false)
	private String vehiculo;
	@Column(name = "placa", length = 30, nullable = false)
	private String placa;
	//@OneToMany(targetEntity = Factura.class)
	@OneToMany(mappedBy= "cliente")
	private List<Factura> facturas= new ArrayList<Factura>();


	public Cliente(Long id, String nombre, String apellido, String vehiculo, String placa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.vehiculo = vehiculo;
		this.placa = placa;
	}


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	
	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}







}
