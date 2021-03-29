package com.desafiolatam.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.ProductoCategoriaDao;
import com.desafiolatam.dao.ProductoCategoriaDaoImpl;
import com.desafiolatam.dto.ProductoCategoria;

@WebServlet("/ListarProductos")
public class ListarProductos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<ProductoCategoria> productos = productoCategoriaDao.listarProductosCategoria();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("ListarProductos.jsp").forward(request, response);
	}

}
