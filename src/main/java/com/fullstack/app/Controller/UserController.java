package com.fullstack.app.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
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


import com.fullstack.app.Service.IUserService;
import com.fullstack.app.entity.ConsultaByName;
import com.fullstack.app.entity.User;

// @Query(value = "SELECT name FROM users", nativeQuery = true)
// List<User> findAllUsers();

@RestController
@RequestMapping("/dk/clients")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	//CREAR UN NUEVO USUARIO
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
		
	}	
	//READ AN USER	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
		Optional<User> oUser = userService.findById(userId);
		
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	

		
	//ACTUALIZAR
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
		
		Optional<User> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.get().setName(userDetails.getName());
		user.get().setSurname(userDetails.getSurname());
		user.get().setPhone(userDetails.getPhone());
		user.get().setEmail(userDetails.getEmail());
		user.get().setAdeuda(userDetails.getAdeuda());
		user.get().setCompras(userDetails.getCompras());
		user.get().setFechaIngreso(userDetails.getFechaIngreso());
		user.get().setUltimaCompra(userDetails.getUltimaCompra());
		user.get().setNota(userDetails.getNota());
		user.get().setContacto(userDetails.getContacto());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));

	}	
	
	//BORRAR
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		
		if(!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userId);
		return ResponseEntity.ok().build();
		
	}	
	
	//READ ALL USERS
	

	@GetMapping
	public List<User> readAll(){
		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
		return users;		
	}
	

	@PostMapping("/getuserbyname")
	public List<User> readAllByName(@RequestBody ConsultaByName consulta){
		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
		return users.stream().filter(u->u.getName().equals(consulta.name)).collect(Collectors.toList());		
	
	}

	
}
