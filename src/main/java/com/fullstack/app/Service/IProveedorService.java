package com.fullstack.app.Service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fullstack.app.entity.Proveedor;



public interface IProveedorService {

public Iterable<Proveedor> findAll();
	
	public Page<Proveedor> findAll(Pageable pageable);
	
	public Optional<Proveedor> findById(Long id);
	
	public Proveedor save(Proveedor proveedor);
	
	public void deleteById(Long id);

}
