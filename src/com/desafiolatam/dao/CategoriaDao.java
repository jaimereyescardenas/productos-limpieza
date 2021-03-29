package com.desafiolatam.dao;

import java.util.List;

import com.desafiolatam.modelo.Categoria;

public interface CategoriaDao {
	
	public Categoria buscarCategoria(int id);
	public List<Categoria> listarCategorias();

}
