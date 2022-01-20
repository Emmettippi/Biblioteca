package it.etlabora.biblioteca.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.biblioteca.dto.UtenteDto;
import it.etlabora.biblioteca.service.UtenteService;

public class RegistrazioneServlet extends HttpServlet{
	UtenteService utente = new UtenteService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Registrazione.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		UtenteDto dto = new UtenteDto();
		response.setContentType("text/html");
		// PrintWriter out= response.getWriter();
		String c = req. getParameter("nome");
		String f = req.getParameter("cognome");
		String e= req.getParameter("email");
		String n = req.getParameter("username");
		String p = req.getParameter("password");


		dto.setNome(c);
		dto.setCognome(f);
		dto.setEmail(e);
		dto.setUsername(n);
		dto.setPassword(p);
		utente.Registrazione(dto);
		// out.print("you are successfully registered...");
		req.getRequestDispatcher("jsp/login.jsp").forward(req, response);


	}

}
