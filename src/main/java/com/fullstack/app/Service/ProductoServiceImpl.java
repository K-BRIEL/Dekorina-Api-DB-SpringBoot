package com.fullstack.app.Service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.app.Dao.IProductoDao;
import com.fullstack.app.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true) // aca le digo que es de solo lectura
	public Iterable<Producto> findAll() {
		
		return productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		
		return productoDao.findAll(pageable);
	}
	


	@Override
	@Transactional
	public Producto save(Producto producto) {
		
		return productoDao.save(producto);
	}

	@Override
	@Transactional  
	public void deleteById(Long id) {
		
		productoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {
		
		return productoDao.findById(id);
	}

	

	
}
