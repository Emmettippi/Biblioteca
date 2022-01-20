package it.etlabora.biblioteca.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.etlabora.biblioteca.service.LibroService;
import it.etlabora.biblioteca.service.UtenteService;
import it.etlabora.biblioteca.util.DbConnection;

public class LoginServlet  extends HttpServlet{

	private UtenteService  utenteSerivce = new UtenteService();
	private LibroService libroService = new LibroService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
			if(utenteSerivce.login(username, password)) {
				HttpSession session= req.getSession();
				session.setAttribute(username, session);
				req.setAttribute("libri", libroService.getAll());
				req.getRequestDispatcher("jsp/catalogo.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("error", "error");
				req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
			}
	}




	public boolean login(String username, String password) {
		String sql = "SELECT * FROM utente WHERE username = ? AND pass = md5(?)";

		try {Connection conn= DbConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		if(1==statement.executeUpdate()) {
			return true;
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}