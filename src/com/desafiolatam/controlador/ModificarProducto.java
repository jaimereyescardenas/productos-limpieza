package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dao.ProductoDaoImpl;
import com.desafiolatam.modelo.Producto;

/**
 * Servlet implementation class ModificarProducto
 */
@WebServlet("/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProductoDao productoDao = new ProductoDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AgregarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParam = request.getParameter("id");
		String nombreParam = request.getParameter("nombre");
		String descripcionParam = request.getParameter("descripcion");
		String precioParam = request.getParameter("precio");
		String categoriaParam = request.getParameter("categoria");
		
		int precio = Integer.parseInt(precioParam);
		int categoria = Integer.parseInt(categoriaParam);
		
		int id = Integer.parseInt(idParam);
		
		Producto producto = new Producto();
		
		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
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
