package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexiondatabase.ConexionDatabase;
import com.desafiolatam.modelo.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {
	
	private Connection conn;
	
	@Override
	public Categoria buscarCategoria(int id) {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return null;
		}
		
		String query = "SELECT * FROM categoria WHERE id_categoria = ?";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Categoria categoria = new Categoria();
			
			if (rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
			}
			
			return categoria;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Categoria> listarCategorias() {

		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return null;
		}
		
		String query = "SELECT * FROM categoria";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			List<Categoria> lista = new ArrayList<>();
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				lista.add(categoria);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
