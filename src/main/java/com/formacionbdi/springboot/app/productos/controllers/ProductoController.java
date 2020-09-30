package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;

@RestController
public class ProductoController {
	
	public final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping("/listar")
	List<Producto> listar() {
		List<Producto> llista = productoService.findAll();
		return llista;
		
	}
	
	@GetMapping("/listar/{id}")
	Producto obtenerProducto(@PathVariable Long id) {
		return productoService.findById(id);
	}

}
