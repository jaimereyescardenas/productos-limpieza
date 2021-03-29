package com.desafiolatam.dto;

import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

public class ProductoCategoria {
	
	private Producto producto;
	private Categoria categoria;
	
	// Constructores, getters y setters

	public ProductoCategoria() {
		super();
	}

	public ProductoCategoria(Producto producto, Categoria categoria) {
		super();
		this.producto = producto;
		this.categoria = categoria;
	}

	public Producto getProducto() { return producto; }

	public void setProducto(Producto producto) { this.producto = producto; }

	public Categoria getCategoria() { return categoria; }

	public void setCategoria(Categoria categoria) { this.categoria = categoria; }

}
