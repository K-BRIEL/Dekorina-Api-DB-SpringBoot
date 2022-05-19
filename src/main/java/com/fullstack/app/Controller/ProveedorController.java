package com.fullstack.app.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fullstack.app.Service.IProductoService;
import com.fullstack.app.Service.IProveedorService;
import com.fullstack.app.entity.ConsultaByName;
import com.fullstack.app.entity.Producto;
import com.fullstack.app.entity.Proveedor;

@RestController
@RequestMapping("/dk/proveedores")
@CrossOrigin("*")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	//CREAR UN NUEVO USUARIO
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor){
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
		
	}	
	//READ AN USER	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
		Optional<Proveedor> oUser = proveedorService.findById(userId);
		
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
		
	//ACTUALIZAR
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor userDetails, @PathVariable(value = "id") Long userId){
		
		Optional<Proveedor> proveedor = proveedorService.findById(userId);
		
		if(!proveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		proveedor.get().setName(userDetails.getName());
		proveedor.get().setDirection(userDetails.getDirection());
		proveedor.get().setTel(userDetails.getTel());
		proveedor.get().setNota(userDetails.getNota());
		proveedor.get().setContacto(userDetails.getContacto());


		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor.get()));

		
	}	
	
	//BORRAR
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		
		if(!proveedorService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		proveedorService.deleteById(userId);
		return ResponseEntity.ok().build();
		
	}	
	
	//READ ALL USERS
	

	@GetMapping
	public List<Proveedor> readAll(){
		List<Proveedor> proveedores = StreamSupport.stream(proveedorService.findAll().spliterator(), false).collect(Collectors.toList());
		return proveedores;		
	}
	
	@PostMapping("/getproveedorbyname")
	public List<Proveedor> readAllByName(@RequestBody ConsultaByName consulta){
		List<Proveedor> proveedores = StreamSupport.stream(proveedorService.findAll().spliterator(), false).collect(Collectors.toList());
		return proveedores.stream().filter(u->u.getName().equals(consulta.name)).collect(Collectors.toList());		
	
	}
}
