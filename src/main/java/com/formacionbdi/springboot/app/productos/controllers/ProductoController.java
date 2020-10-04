package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.ProductoService;

@RestController
public class ProductoController {

	//public final Environment environment;
	@Autowired
	public ProductoService productoService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/listar")
	List<Producto> listar() {
		List<Producto> llista = productoService.findAll().stream().map(producto-> {
			//producto.setPort(environment.getProperty("local.server.port", Integer.class));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
		return llista;
		
	}
	
	@GetMapping("/listar/{id}")
	Producto obtenerProducto(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(environment.getProperty("local.server.port", Integer.class));
		producto.setPort(port);
		
//		try {
//			Thread.sleep(2000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return producto;
	}

}
