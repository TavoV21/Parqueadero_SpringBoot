package com.clientes.parqueo.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {

	@Id
	@Column(name="id_factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_factura;
	@Column(name = "ficha", length = 10, nullable = false)
	private String ficha;
	@Column(name = "tiempo", length = 30, nullable = false)
	private String tiempo;
	@Column(name = "precio", length = 30, nullable = false)
	private String precio;
	@Column(name = "total", length = 30, nullable = false)
	private String total;
	@Column(name = "hora", length = 30, nullable = true)
    private String hora;
	@ManyToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="id_cliente",nullable = false)
	private Cliente cliente;
	
	
	public Factura(Long id_factura, String ficha, String tiempo, String precio, String total, String hora,
			Cliente cliente) {
		super();
		this.id_factura = id_factura;
		this.ficha = ficha;
		this.tiempo = tiempo;
		this.precio = precio;
		this.total = total;
		this.hora = hora;
		this.cliente = cliente;
	}

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId_factura() {
		return id_factura;
	}

	public void setId_factura(Long id_factura) {
		this.id_factura = id_factura;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public static String obtenerFechaYHoraActual() {
		String formato = "yyyy-MM-dd HH:mm:ss";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
		LocalDateTime ahora = LocalDateTime.now();
		return formateador.format(ahora);
	}

	
	
	
	
	
}
