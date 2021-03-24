package com.desafiolatam.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.dao.ProductoDao;
import com.desafiolatam.dao.ProductoDaoImpl;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProductoDao productoDao = new ProductoDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		
		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		request.setAttribute("id", idParam);
		request.getRequestDispatcher("EliminarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		int id = 0;
		
		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		
		id = Integer.parseInt(idParam);
		productoDao.eliminarProducto(id);
		
		request.getRequestDispatcher("Inicio.jsp").forward(request, response);
		
		
	}

}
