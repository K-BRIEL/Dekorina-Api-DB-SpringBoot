package com.fullstack.app.Service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.app.Dao.IPedidoDao;
import com.fullstack.app.entity.Pedido;


@Service
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	private IPedidoDao pedidoDao;
	
	@Override
	@Transactional(readOnly = true) // aca le digo que es de solo lectura
	public Iterable<Pedido> findAll() {
		
		return pedidoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pedido> findAll(Pageable pageable) {
		
		return pedidoDao.findAll(pageable);
	}
	


	@Override
	@Transactional
	public Pedido save(Pedido pedido) {
		
		return pedidoDao.save(pedido);
	}

	@Override
	@Transactional  
	public void deleteById(Long id) {
		
		pedidoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Long id) {
		
		return pedidoDao.findById(id);
	}

	

	
}
