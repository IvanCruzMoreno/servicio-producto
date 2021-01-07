package com.badbadcode.application.models.service;

import com.badbadcode.application.models.entity.Producto;

public interface IProductoService {

	public Iterable<Producto> findAll();
	public Producto findById(Long id);
}
