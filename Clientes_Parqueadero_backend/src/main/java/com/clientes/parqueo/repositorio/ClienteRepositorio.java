package com.clientes.parqueo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clientes.parqueo.modelo.Cliente;
import com.clientes.parqueo.modelo.Factura;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

	@Query(value = "SELECT c FROM Cliente c WHERE c.vehiculo LIKE %:palabraClave%")
	 public List<Cliente> obtenerVehiculo(@Param("palabraClave")String palabraClave);
	
}
