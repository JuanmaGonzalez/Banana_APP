package com.netmind.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netmind.db.TareasDAO;
import com.netmind.db.TareasDAOImpl;
import com.netmind.db.ProyectosDAO;
import com.netmind.db.ProyectosDAOImpl;
import com.netmind.models.Tarea;
import com.netmind.models.Proyecto;
import com.netmind.models.Usuario;

@WebServlet("/comprar")
public class ComprarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {
			ProyectosDAO mDAO=(ProyectosDAO)ProyectosDAOImpl.getInstance();
			List<Proyecto> listaMaquillajes = mDAO.getMaquillajes();
			request.setAttribute("listaMaquillajesAMostrar", listaMaquillajes);

			request.getRequestDispatcher("comprar.jsp").forward(request, response);
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession = (HttpSession) request.getSession();

		if (misession.getAttribute("usuario") != null) {

			int cosmetico = request.getParameter("cosmetico") != null
					? Integer.parseInt(request.getParameter("cosmetico")) : 0;
			int cantidad = request.getParameter("cantidad") != null
					? Integer.parseInt(request.getParameter("cantidad")) : 0;

			if (cosmetico > 0 && cantidad > 0) {

				Usuario elUsuario = (Usuario) misession.getAttribute("usuario");
				ProyectosDAO mDAO=(ProyectosDAO)ProyectosDAOImpl.getInstance();
				TareasDAO cDAO=(TareasDAO)TareasDAOImpl.getInstance();

				Calendar today = Calendar.getInstance();
				Date todayDate = today.getTime();
				
				Proyecto unMaq= mDAO.getMaquillaje(cosmetico);

				Tarea nuevaCompra = new Tarea(0, elUsuario, unMaq, cantidad, todayDate);

				if (!cDAO.insertCompra(nuevaCompra)) {
					request.setAttribute("error", "No se ha podido terminar el proceso :-(. Vuelve a intentarlo...");
					doGet(request, response);
				} else {
					request.getRequestDispatcher("lista_maquillajes").forward(request, response);
				}
				
			} else {
				request.setAttribute("error", "Selecciona un cosmético e indica una cantidad igual o mayor a uno");
				doGet(request, response);
			}
		} else {
			misession.invalidate();
			response.sendRedirect("login");
		}
	}

}
