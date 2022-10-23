package com.clientes.parqueo.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clientes.parqueo.modelo.Factura;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long>{

	
	 @Query(value = "SELECT * FROM Factura WHERE id_cliente = ?1", nativeQuery = true)
	 public Factura obtenerPorElId(Long id_cliente);
	 
	 @Query("SELECT COUNT(*) FROM Factura WHERE id_cliente =?1")
	 public long contarFacturaPorElId(Long id);
	 
	 @Modifying
	 @Transactional
	 @Query(value = "UPDATE Factura SET ficha=:ficha, tiempo=:tiempo, precio=:precio, total=:total, hora=:hora WHERE id_cliente=:id_cliente")
	 Integer actualizarFactura(@Param("id_cliente")Long id_cliente,@Param("ficha") String ficha,@Param("tiempo") String tiempo,
	 @Param("precio") String precio,@Param("total")String total,@Param("hora")String hora);


}
