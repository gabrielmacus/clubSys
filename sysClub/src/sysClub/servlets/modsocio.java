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
 * Servlet implementation class modsocio
 */
@WebServlet("/modsocio")
public class modsocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modsocio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       PrintWriter out=	response.getWriter();
       
try
{
		CategoriaDAO catDao= new CategoriaDAO(); 
		String nombreCategoria =request.getParameter("categoria");
		String nombre = request.getParameter("nombre");
		String apellido =request.getParameter("apellido");
	String direccion = request.getParameter("direccion");
	String telefonos = request.getParameter("telefonos");
	String dni = request.getParameter("dni");
  
Categoria categoria =catDao.getCategoriaByName(nombreCategoria);

            Socio socio =new Socio(nombre, apellido, direccion, telefonos,Long.parseLong(dni), categoria);
		 new SocioDAO().updateSocio(socio);
}
catch(Exception ex)
{
	out.println("Error al modificar el socio");
	ex.printStackTrace();
}
		
	}

}
