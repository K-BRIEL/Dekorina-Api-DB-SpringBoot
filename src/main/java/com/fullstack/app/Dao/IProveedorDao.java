package com.fullstack.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fullstack.app.entity.Proveedor;

@Repository
public interface IProveedorDao extends JpaRepository<Proveedor, Long>{

}
