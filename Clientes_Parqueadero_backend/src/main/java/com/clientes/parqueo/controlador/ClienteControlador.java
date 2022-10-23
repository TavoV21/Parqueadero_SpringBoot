package com.clientes.parqueo.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.parqueo.excepciones.ResourceNotFoundException;
import com.clientes.parqueo.modelo.Cliente;
import com.clientes.parqueo.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("api/backend/")
@CrossOrigin(origins = "http://localhost:4200" )
public class ClienteControlador {

	@Autowired
	private ClienteRepositorio repositorio;

	
	@GetMapping("/clientes")
	 public List<Cliente> ListaClientes() {
	    return repositorio.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/clientes")
	  public Cliente guardarCliente(@RequestBody Cliente miCliente) {
	    return repositorio.save(miCliente);
	  }

	  // Single item
	  
	  @GetMapping("/clientes/{id}")
	  public Cliente obtenerClientePorElId(@PathVariable Long id) {
	    
		  return repositorio.findById(id)
			      .orElseThrow(() -> new ResourceNotFoundException("No hay resultados por el id: "+id));
	  }

		
	  @PutMapping("/clientes/{id}")
	  public Cliente modfificarCliente(@RequestBody Cliente miCliente, @PathVariable Long id) {
		    
		    return repositorio.findById(id)
		      .map(cliente -> {	  
		        cliente.setNombre(miCliente.getNombre());
		        cliente.setApellido(miCliente.getApellido());
		        cliente.setVehiculo(miCliente.getVehiculo());
		        cliente.setPlaca(miCliente.getPlaca());
		        return repositorio.save(cliente);
		      })
		      .orElseGet(() -> {
		    	  miCliente.setId(id);
		        return repositorio.save(miCliente);
		      });
		  }
	  
	  @DeleteMapping("/clientes/{id}")
	  public void eliminarCliente(@PathVariable Long id) {
	    repositorio.deleteById(id);
	  }
	  
	  @GetMapping("/contarClientes")
		public long contarClientes(){
			return repositorio.count();
	  }
	  
	  @GetMapping("/filtro/{palabraClave}")
	  public List<Cliente> FiltrarVehiculo(@PathVariable String palabraClave){
		  if(palabraClave!=null) {
			return repositorio.obtenerVehiculo(palabraClave);	  
		  }
		return repositorio.findAll();
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
