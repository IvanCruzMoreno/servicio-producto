package com.badbadcode.application.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badbadcode.application.commons.models.entity.Producto;
import com.badbadcode.application.models.dao.ProductoDao;


@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
