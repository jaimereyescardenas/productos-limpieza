package com.desafiolatam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.conexiondatabase.ConexionDatabase;
import com.desafiolatam.modelo.Producto;

public class ProductoDaoImpl implements ProductoDao {
	
	private Connection conn;
	
	@Override
	public Producto buscarProducto(int id) {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new Producto();
		}
		
		String query = "SELECT * FROM producto WHERE id_producto = ?;";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Producto producto = new Producto();
			
			if (rs.next()) {
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
			}
			
			return producto;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new Producto();
		}
	}
	
	@Override
	public List<Producto> listarProductos() {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new ArrayList<Producto>();
		}
		
		String query = "SELECT * FROM producto;";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			List<Producto> lista = new ArrayList<>();
			
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				lista.add(producto);
			}
			
			return lista;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Producto>();
		}
	}
	
	@Override
	public Producto agregarProducto(Producto producto) {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new Producto();
		}
		
		String query = "INSERT INTO producto "
				+ "(id_producto, nombre_producto, descripcion_producto, precio_producto, id_categoria) "
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try {
			
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, producto.getId());
			pstm.setString(2, producto.getNombre());
			pstm.setString(3, producto.getDescripcion());
			pstm.setInt(4, producto.getPrecio());
			pstm.setInt(5, producto.getIdCategoria());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return producto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Producto();
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return new Producto();
		}
		
		String query = "UPDATE producto SET nombre_producto = ?, descripcion_producto = ?, precio_producto = ?, id_categoria = ? "
				+ "WHERE id_producto = ?;";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setString(1, producto.getNombre());
			pstm.setString(2, producto.getDescripcion());
			pstm.setInt(3, producto.getPrecio());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getId());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return producto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Producto();
	}

	@Override
	public boolean eliminarProducto(int id) {
		
		conn = ConexionDatabase.obtenerConexion();
		
		if (conn == null) {
			return false;
		}
		
		String query = "DELETE FROM producto WHERE id_producto = ?;";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int obtenerUltimoId() {
		
		conn = ConexionDatabase.obtenerConexion();

		int resultado = 0;
		
		if (conn == null) {
			return resultado;
		}
		
		String query = "SELECT MAX(id_producto) AS max FROM producto;";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getInt("max");
			}
			
			return resultado;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
	}

}
