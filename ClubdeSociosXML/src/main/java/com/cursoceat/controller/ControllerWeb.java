package com.cursoceat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cursoceat.xml.schema.Club;
import com.cursoceat.xml.schema.Club.Socio;

/**
 * Servlet implementation class ControllerWeb
 */
@WebServlet("/ControllerWeb")
public class ControllerWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Club miClub=new Club();
	List <Club> miSociosAlta=null;
	

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nombre=request.getParameter("nombreSocio");
			String direccion=request.getParameter("direccionSocio");
			String alta=request.getParameter("altaSocio");
			
			Socio socio=new Socio();
			
			socio.setNombreSocio(nombre);
			socio.setDireccion(direccion);
			socio.setFechaAlta(alta);
			miClub.getSocio().add(socio);
			
			System.out.println(socio.toString());
			
			//para que recague la pagina incluyendo un nuevo registro
			//request.getRequestDispatcher("index.jsp").forward(request, response);	
			
			response.sendRedirect("index.jsp");
					
		}catch (Exception e) {
			request.setAttribute("msn", "Todo ok...");
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
