package sysClub.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysClub.DAOs.SocioDAO;
import sysClub.entidades.Socio;

/**
 * Servlet implementation class loadsocios
 */
@WebServlet("/loadsocios")
public class loadsocios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadsocios() {
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
		PrintWriter out = response.getWriter();
		try
		{
			
			SocioDAO socioDAO=new SocioDAO();
			
			List<Socio>socios = socioDAO.getListaSocio();
		
			System.out.println(socios.size());
			for (int i = 0; i <socios.size(); i++) {
		
				out.println("<li >"+socios.get(i).getNombre()+" "+socios.get(i).getApellido()+"</li>");
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("f");
		}
		
		
		
		
	}

}
