package com.netmind.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netmind.db.DAOFactory;
import com.netmind.db.UsuarioDAO;
import com.netmind.db.UsuarioDAOImpl;
import com.netmind.models.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger("LoginServlet");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession misession= (HttpSession)request.getSession();
		
		if( misession.getAttribute("usuario")!=null ){
			request.getRequestDispatcher("/lista_proyectos").forward(request, response);			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String contrasena = request.getParameter("password");
		
		UsuarioDAO userDAO = (UsuarioDAO) DAOFactory.getInstance().getDAO("usuario");
		
		Usuario elUsuario = userDAO.getUsuario(email, contrasena);
		
		if( elUsuario!=null ){
			HttpSession misession= (HttpSession)request.getSession();
			misession.setAttribute("usuario", elUsuario);
			
			request.getRequestDispatcher("/lista_proyectos").forward(request, response);
			//request.getRequestDispatcher("/lista_maquillajes").forward(request, response);
		}else{
			request.setAttribute("mierror", "Email y contraseņa erroneos");
			doGet(request, response);
		}
		
	}

}














