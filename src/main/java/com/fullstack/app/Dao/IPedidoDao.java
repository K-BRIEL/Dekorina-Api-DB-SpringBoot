package com.fullstack.app.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fullstack.app.entity.Pedido;
import com.fullstack.app.entity.User;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Long>{

}
