package com.desafiolatam.dao;

import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.dto.ProductoCategoria;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

public class ProductoCategoriaDaoImpl implements ProductoCategoriaDao {
	
	private ProductoDao productoDao = new ProductoDaoImpl();
	
	private CategoriaDao categoriaDao = new CategoriaDaoImpl();

	@Override
	public List<ProductoCategoria> listarProductosCategoria() {
		
		List<ProductoCategoria> lista = new ArrayList<>();
		List<Producto> productos = productoDao.listarProductos();
		
		for (Producto p: productos) {
			
			ProductoCategoria pc = new ProductoCategoria();
			
			Categoria c = categoriaDao.buscarCategoria(p.getIdCategoria());
			pc.setProducto(p);
			pc.setCategoria(c);
			
			lista.add(pc);
			
		}
		
		return lista;
	}

}
