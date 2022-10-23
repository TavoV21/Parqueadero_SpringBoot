package com.clientes.parqueo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.parqueo.excepciones.ResourceNotFoundException;
import com.clientes.parqueo.modelo.Cliente;
import com.clientes.parqueo.modelo.Factura;
import com.clientes.parqueo.repositorio.FacturaRepositorio;

@RestController
@RequestMapping("api/backend/")
@CrossOrigin(origins = "http://localhost:4200" )
public class FacturaControlador {

	@Autowired
	private FacturaRepositorio repositorio;
	
	@GetMapping("/factura")
	public List<Factura> ListarFactura(){
		return repositorio.findAll();
	}
	
    @GetMapping("/factura/{id_cliente}")
   	public Factura obtenerIdFactura(@PathVariable Long id_cliente){
		return repositorio.obtenerPorElId(id_cliente);
   	}
	
	@PostMapping("/factura")
	public Factura guardarFactura(@RequestBody Factura miFactura){
		return repositorio.save(miFactura);
	}
	
	@PutMapping("/factura/{id_factura}")
	public Integer modfificarFactura(@RequestBody Factura miFactura, @PathVariable Long id_factura) {	    
	Factura f=new Factura();
	String fechayHora=f.obtenerFechaYHoraActual();
	return repositorio.actualizarFactura(id_factura, miFactura.getFicha(), miFactura.getTiempo(), miFactura.getPrecio(), miFactura.getTotal(), fechayHora);
		     
    }
	  
	@DeleteMapping("/factura/{id_factura}")
	public void eliminarFactura(@PathVariable Long id_factura) {
	   repositorio.deleteById(id_factura);
	}
	  
	@GetMapping("/contarFacturas/{id}")
	public long contar(@PathVariable Long id){
		return repositorio.contarFacturaPorElId(id);
	}
	  
	  
	
	
}
