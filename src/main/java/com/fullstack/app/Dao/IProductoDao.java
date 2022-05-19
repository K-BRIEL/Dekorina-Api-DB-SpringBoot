package com.fullstack.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.app.entity.Producto;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Long>{

}
