package it.etlabora.biblioteca.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.etlabora.biblioteca.dto.LibroDto;
import it.etlabora.biblioteca.service.LibroService;


public class CatalogoServlet extends HttpServlet{
	LibroService libroService=new  LibroService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println("No id: returning catalogo ");
		}

		if (id == null) {
			List<LibroDto> libri = libroService.getAll() ;
			req.setAttribute("libri", libri);
			req.getRequestDispatcher("jsp/catalogo.jsp").forward(req, resp);
		} else {
			LibroDto dto = libroService.getOne(id);
			req.setAttribute("libro", dto);
			req.getRequestDispatcher("jsp/dettaglio.jsp").forward(req, resp);
		}
	}
}