package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ProductoController {

	public final Environment environment;
	public final ProductoService productoService;
	
	@GetMapping("/listar")
	List<Producto> listar() {
		List<Producto> llista = productoService.findAll().stream().map(producto-> {
			producto.setPort(environment.getProperty("local.server.port", Integer.class));
			return producto;
		}).collect(Collectors.toList());
		return llista;
		
	}
	
	@GetMapping("/listar/{id}")
	Producto obtenerProducto(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(environment.getProperty("local.server.port", Integer.class));
		return producto;
	}

}
