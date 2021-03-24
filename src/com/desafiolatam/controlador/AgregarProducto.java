package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.CategoriaDao;
import com.desafiolatam.dao.CategoriaDaoImpl;
import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dao.ProductoDaoImpl;
import com.desafiolatam.modelo.Categoria;
import com.desafiolatam.modelo.Producto;

/**
 * Servlet implementation class AgregarProducto
 */
@WebServlet("/AgregarProducto")
public class AgregarProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProductoDao productoDao = new ProductoDaoImpl();
	
	private CategoriaDao categoriaDao = new CategoriaDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> categorias = categoriaDao.listarCategorias();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("AgregarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String nombreParam = request.getParameter("nombre");
		String descripcionParam = request.getParameter("descripcion");
		String precioParam = request.getParameter("precio");
		String categoriaParam = request.getParameter("categoria");
		
		int precio = Integer.parseInt(precioParam);
		int categoria = Integer.parseInt(categoriaParam);
		
		Producto producto = new Producto();
		
		int id = productoDao.obtenerUltimoId();
		
		if (id < 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}
		
		producto.setId(id+1);
		producto.setNombre(nombreParam);
		producto.setDescripcion(descripcionParam);
		producto.setPrecio(precio);
		producto.setIdCategoria(categoria);
		
		Producto productoResponse = productoDao.agregarProducto(producto);
		
		if (productoResponse.getId() == 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		
	}

}
