package com.fullstack.app.Service;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fullstack.app.entity.User;

public interface IUserService {
	
	public Iterable<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);

	public ArrayList<User> searchByName(String name);
	

}
