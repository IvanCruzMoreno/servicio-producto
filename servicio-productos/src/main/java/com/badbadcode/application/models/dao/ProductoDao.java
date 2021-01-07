package com.badbadcode.application.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.badbadcode.application.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
