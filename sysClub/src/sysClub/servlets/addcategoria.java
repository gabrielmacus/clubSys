package sysClub.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysClub.DAOs.CategoriaDAO;
import sysClub.entidades.Categoria;

/**
 * Servlet implementation class addcategoria
 */
@WebServlet("/addcategoria")
public class addcategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcategoria() {
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
	
	try{
		CategoriaDAO categoriadao = new CategoriaDAO();
		
		
		String nombre=request.getParameter("nombre");
		String descripcion=request.getParameter("descripcion");
		Double importe=Double.parseDouble(request.getParameter("importe"));
		
		Categoria c = new Categoria(nombre, descripcion, importe);
		
		categoriadao.AddCategoria(c);
		
		
	}catch(Exception ex){
		ex.printStackTrace();
		out.println("no se pudo agregar la categoría");
	}
	response.sendRedirect("index.jsp");
	
	
	}

}
