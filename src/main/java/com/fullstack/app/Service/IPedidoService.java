package com.fullstack.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fullstack.app.entity.Pedido;

public interface IPedidoService {

	public Iterable<Pedido> findAll();
	
	public Page<Pedido> findAll(Pageable pageable);
	
	public Optional<Pedido> findById(Long id);
	
	public Pedido save(Pedido producto);
	
	public void deleteById(Long id);

}
