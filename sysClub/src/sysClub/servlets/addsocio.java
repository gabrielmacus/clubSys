package sysClub.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysClub.DAOs.CategoriaDAO;
import sysClub.DAOs.SocioDAO;
import sysClub.entidades.Categoria;
import sysClub.entidades.Socio;

/**
 * Servlet implementation class addsocio
 */
@WebServlet("/addsocio")
public class addsocio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addsocio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		
		
		try {
			CategoriaDAO catDao = new CategoriaDAO();
			
			String nombreCategoria = request.getParameter("categoria");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String direccion = request.getParameter("direccion");
			String telefonos = request.getParameter("telefonos");
			String dni = request.getParameter("dni");

			Categoria categoria = catDao.getCategoriaByName(nombreCategoria);

			SocioDAO socioDao = new SocioDAO();
			
			Socio socio = new Socio(nombre, apellido, direccion, telefonos, Long.parseLong(dni), categoria);

			socioDao.addSocio(socio);

			response.sendRedirect("socios.jsp");
			out.print("t");
		} catch (Exception ex) {
			ex.printStackTrace();
			out.println("Error al ingresar nuevo socio");
		}
		response.sendRedirect("socios.jsp");
	}

}
