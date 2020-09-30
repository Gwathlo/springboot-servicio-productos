package com.formacionbdi.springboot.app.productos.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
