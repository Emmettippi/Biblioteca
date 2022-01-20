package it.etlabora.biblioteca.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.etlabora.biblioteca.service.LibroService;

public class PrenotaServlet extends HttpServlet {
	LibroService libro = new LibroService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idlibro= req.getParameter("id");
		HttpSession session= req.getSession();
		Long id = (Long) session.getAttribute("id");
		Long id2 =Long.parseLong(idlibro);
		libro.Prenotazione(id2, id);
		req.getRequestDispatcher("jsp/prenota.jsp").forward(req, resp);
	}
}
