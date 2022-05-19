package com.fullstack.app.Service;




import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.app.Dao.IUserDao;
import com.fullstack.app.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true) // aca le digo que es de solo lectura
	public Iterable<User> findAll() {
		
		return userDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		
		return userDao.findAll(pageable);
	}
	


	@Override
	@Transactional
	public User save(User user) {
		
		return userDao.save(user);
	}

	@Override
	@Transactional  
	public void deleteById(Long id) {
		
		userDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		
		return userDao.findById(id);
	}

	@Transactional(readOnly = true) 
	public ArrayList<User> searchByName(String name) {
		
		return userDao.findByNameContainingOrSurnameContaining(name);
	}

	
}
