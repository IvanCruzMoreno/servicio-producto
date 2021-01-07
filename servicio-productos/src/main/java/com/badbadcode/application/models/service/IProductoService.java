package com.badbadcode.application.models.service;

import java.util.List;

import com.badbadcode.application.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id);
}
