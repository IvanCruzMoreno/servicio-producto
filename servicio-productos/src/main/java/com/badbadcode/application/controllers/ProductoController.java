package com.badbadcode.application.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.badbadcode.application.commons.models.entity.Producto;
import com.badbadcode.application.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment enviroment;
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private IProductoService productoService;

	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll().stream().map(producto -> {
			// producto.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}

	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		// producto.setPort(Integer.parseInt(enviroment.getProperty("local.server.port")));
		producto.setPort(port);
		return producto;
	}
	@PostMapping("/crear")
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	@PutMapping("/editar/{id}")
	public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
		Producto newProducto = productoService.findById(id);
		
		newProducto.setNombre(producto.getNombre());
		newProducto.setPrecio(producto.getPrecio());
		
		return productoService.save(newProducto);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		productoService.deleteById(id);
	}
	
}
