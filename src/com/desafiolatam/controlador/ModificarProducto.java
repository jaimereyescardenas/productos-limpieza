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

@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProductoDao productoDao = new ProductoDaoImpl();
	private CategoriaDao categoriaDao = new CategoriaDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		
		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		Producto producto = productoDao.buscarProducto(id);
		List<Categoria> categorias = categoriaDao.listarCategorias();
		request.setAttribute("categorias", categorias);
		request.setAttribute("producto", producto);
		
		request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String idParam = request.getParameter("id");
		String nombreParam = request.getParameter("nombre");
		String descripcionParam = request.getParameter("descripcion");
		String precioParam = request.getParameter("precio");
		String categoriaParam = request.getParameter("categoria");
		
		int precio = Integer.parseInt(precioParam);
		int categoria = Integer.parseInt(categoriaParam);
		int id = Integer.parseInt(idParam);
		
		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(nombreParam);
		producto.setDescripcion(descripcionParam);
		producto.setPrecio(precio);
		producto.setIdCategoria(categoria);
		
		Producto productoResponse = productoDao.modificarProducto(producto);
		
		if (productoResponse.getId() == 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		
	}

}
