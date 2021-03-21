package com.desafiolatam.dao;

import java.sql.Connection;
import java.util.List;

import com.desafiolatam.modelo.Producto;

public class ProductoDaoImpl implements ProductoDao {
	
	private Connection conn;
	
	@Override
	public Producto buscarProducto(int id) {
		return null;
	}
	
	@Override
	public List<Producto> listarProductos() {
		return null;
	}
	
	@Override
	public Producto agregarProducto(Producto producto) {
		return null;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		return null;
	}

	@Override
	public boolean eliminarProducto(int id) {
		return false;
	}

}
