package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Producto;

public interface ProductoDao {
	
	public Producto buscarProducto(int id);
	public List<Producto> listarProductos();
	public Producto agregarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public boolean eliminarProducto(int id);
	public int obtenerUltimoId();

}
