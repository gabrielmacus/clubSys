package sysClub.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysClub.PersistenceManager;
import sysClub.DAOs.PersonaDAO;
import sysClub.DAOs.SocioDAO;
import sysClub.entidades.Categoria;
import sysClub.entidades.Disciplina;
import sysClub.entidades.Persona;
import sysClub.entidades.Profesor;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		PrintWriter out = response.getWriter();
		try
		{
			SocioDAO socioDao =new SocioDAO();
			String nombre = request.getParameter("nombre-persona").toString();
			
			String apellido= request.getParameter("apellido-persona");
			String direccion = request.getParameter("direccion-persona");
            System.out.println(request.getParameter("dni-persona"));
			long dni = Long.parseLong(request.getParameter("dni-persona"));
			String telefonos = request.getParameter("telefonos-persona");
			int numerosocio =Integer.parseInt( request.getParameter("numero-socio"));
			
		System.out.println(telefonos);
		//	socioDao.addSocio(new Socio(nombre, apellido, direccion, telefonos, dni, numerosocio, ));
			
			out.print("t");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			out.println("f");
		}
		
		
		
	}

}
