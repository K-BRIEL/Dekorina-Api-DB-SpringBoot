package com.fullstack.app.Dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fullstack.app.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM users WHERE users.name LIKE %:nombre% OR users.surName LIKE %:nombre% "  , nativeQuery = true)
	public ArrayList<User> findByNameContainingOrSurnameContaining(@Param("nombre")String nombre);

}
