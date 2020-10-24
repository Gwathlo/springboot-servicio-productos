package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	public final ProductoRepository productoRepository;

	public ProductoServiceImpl(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		
	}

}
