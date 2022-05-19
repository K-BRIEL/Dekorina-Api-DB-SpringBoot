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

import com.fullstack.app.Service.IPedidoService;
import com.fullstack.app.entity.ConsultaByName;
import com.fullstack.app.entity.Pedido;
import com.fullstack.app.entity.Producto;




@RestController
@RequestMapping("/dk/pedidos")
public class PedidosController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	//CREAR UN NUEVO USUARIO
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pedido pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
		
	}	
	//READ AN USER	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long pedidoId){
		Optional<Pedido> pedido  = pedidoService.findById(pedidoId);
		
		
		if(!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedido);
	}
	

		
	//ACTUALIZAR
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedidoDetails, @PathVariable(value = "id") Long pedidoId){
		
		Optional<Pedido> pedido = pedidoService.findById(pedidoId);
		
		if(!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedido.get().setClientName(pedidoDetails.getClientName());
		pedido.get().setIdClient(pedidoDetails.getIdClient());
		pedido.get().setProductos(pedidoDetails.getProductos());
		pedido.get().setRestaPagar(pedidoDetails.getRestaPagar());
		pedido.get().setAdelanto(pedidoDetails.getAdelanto());
		pedido.get().setImporte(pedidoDetails.getImporte());
		pedido.get().setEntregado(pedidoDetails.getEntregado());
		pedido.get().setTerminado(pedidoDetails.getTerminado());
		pedido.get().setPago(pedidoDetails.getPago());
		pedido.get().setNota(pedidoDetails.getNota());
		

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido.get()));

		
	}	
	
	//BORRAR
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		
		if(!pedidoService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedidoService.deleteById(userId);
		return ResponseEntity.ok().build();
		
	}	
	
	//READ ALL USERS
	

	@GetMapping
	public List<Pedido> readAll(){
		List<Pedido> pedidos = StreamSupport.stream(pedidoService.findAll().spliterator(), false).collect(Collectors.toList());
		return pedidos;		
	}
	
	@PostMapping("/getpedidobycliente")
	public List<Pedido> readAllByName(@RequestBody ConsultaByName consulta){
		List<Pedido> pedidos = StreamSupport.stream(pedidoService.findAll().spliterator(), false).collect(Collectors.toList());
		return pedidos.stream().filter(u->u.getClientName().equals(consulta.name)).collect(Collectors.toList());		
	
	}
	
}
