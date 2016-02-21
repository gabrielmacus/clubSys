package sysClub.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sysClub.DAOs.DisciplinaDAO;
import sysClub.entidades.Disciplina;

/**
 * Servlet implementation class adddisciplina
 */
@WebServlet("/adddisciplina")
public class adddisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adddisciplina() {
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
 {DisciplinaDAO disciplinaDAO=new DisciplinaDAO();
 SimpleDateFormat sdfHora= new SimpleDateFormat("hh:mm");
 SimpleDateFormat sdfFecha= new SimpleDateFormat("dd-mm-yyyy");
Date horaInicio = sdfHora.parse(request.getParameter("hora_ini"));
Date horaFin =  sdfHora.parse(request.getParameter("hora_fin"));
String nombre = request.getParameter("nombre");
Date fechaInicio =sdfFecha.parse(request.getParameter("fecha_ini"));
Date fechaFinal = sdfFecha.parse(request.getParameter("fecha_fin"));


Double importe = Double.parseDouble(request.getParameter("importe"));
Float porcentajeAlProfesor = Float.parseFloat(request.getParameter("porcentaje"));
 Disciplina d =new Disciplina(nombre, horaInicio, horaFin, fechaInicio,fechaFinal, importe, porcentajeAlProfesor);
	 disciplinaDAO.addDisciplina(d);
 }catch(Exception ex)
 {
	 ex.printStackTrace();
	 out.println("Error al agregar disciplina");
 }
 
	}

}
