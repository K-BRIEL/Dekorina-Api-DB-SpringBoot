package com.fullstack.app.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.app.Service.IProductoService;
import com.fullstack.app.entity.ConsultaByName;
import com.fullstack.app.entity.Producto;
import com.fullstack.app.entity.User;



@RestController
@RequestMapping("/dk/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	//CREAR UN NUEVO USUARIO
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
		
	}	
	//READ AN USER	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
		Optional<Producto> oUser = productoService.findById(userId);
		
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
		
	//ACTUALIZAR
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto userDetails, @PathVariable(value = "id") Long userId){
		
		Optional<Producto> producto = productoService.findById(userId);
		
		if(!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		producto.get().setName(userDetails.getName());
		producto.get().setTipo(userDetails.getTipo());
		producto.get().setCantidad(userDetails.getCantidad());
		producto.get().setCosto(userDetails.getCosto());
		producto.get().setPrecio(userDetails.getPrecio());
		producto.get().setDetalle(userDetails.getDetalle());
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));

		
	}	
	
	//BORRAR
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		
		if(!productoService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(userId);
		return ResponseEntity.ok().build();
		
	}	
	
	//READ ALL USERS
	

	@GetMapping
	public List<Producto> readAll(){
		List<Producto> productos = StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
		return productos;		
	}
	
	@PostMapping("/getproductbyname")
	public List<Producto> readAllByName(@RequestBody ConsultaByName consulta){
		List<Producto> productos = StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
		return productos.stream().filter(u->u.getName().equals(consulta.name)).collect(Collectors.toList());		
	
	}
	
}
