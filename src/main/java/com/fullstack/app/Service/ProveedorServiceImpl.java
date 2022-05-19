package com.fullstack.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.app.Dao.IProveedorDao;
import com.fullstack.app.entity.Producto;
import com.fullstack.app.entity.Proveedor;


@Service
public class ProveedorServiceImpl implements IProveedorService {
	@Autowired
	private IProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true) // aca le digo que es de solo lectura
	public Iterable<Proveedor> findAll() {
		
		return proveedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Proveedor> findAll(Pageable pageable) {
		
		return proveedorDao.findAll(pageable);
	}
	


	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional  
	public void deleteById(Long id) {
		
		proveedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedor> findById(Long id) {
		
		return proveedorDao.findById(id);
	}



	

}
