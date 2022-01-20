package it.etlabora.biblioteca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import it.etlabora.biblioteca.dto.LibroDto;
import it.etlabora.biblioteca.mapper.LibroMapper;
import it.etlabora.biblioteca.model.Libro;
import it.etlabora.biblioteca.util.DbConnection;

public class LibroService {
	private LibroMapper  libromapper = new LibroMapper();

	public void Prenotazione(Long id, Long  id_utente) {
		if( id != null) ;
		try {
			Connection conn= DbConnection.getConnection();
			String sql1 = "UPDATE Libro set id_utente=?, stato= 'PRENOTATO' where id=?";
			PreparedStatement statement = conn.prepareStatement(sql1);
			statement.setLong(1, id_utente);
			statement.setLong(2, id);		
			statement.executeQuery();


		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String CancPrenotazione(Long id, Long  id_utente) {
		if( id_utente != null) {
			try {
				Connection conn= DbConnection.getConnection();
				String sql2 = "UPDATE Libro set id_utente =null, stato= 'DISPONIBILE' where id=?";
				PreparedStatement statement1 = conn.prepareStatement(sql2);
				statement1.setLong(1, id);
				if(1==statement1.executeUpdate()) {

				}

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "error.jsp";
	}



	//creazione 
	public void creazioneLibro(LibroDto dto) {
		try {
			Connection conn= DbConnection.getConnection();
			Libro entity = libromapper.toModel(dto);
			String sql = "INSERT INTO Utente \n " + "(titolo,casa_editrice,autori,categoria,isbn,note,stato,id_utente) \n" + "VALUES(?,?,?,?,?,?,?,?) \n";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getTitolo());
			statement.setString(2, entity.getCasaEditrice());
			statement.setString(3, entity.getAutori());
			statement.setString(4, entity.getCategoria());
			statement.setString(5, entity.getIsbn());
			statement.setString(6, entity.getNote());
			statement.setLong(7, entity.getIdUtente());

			statement.executeUpdate();





		}catch(Exception e) {
			e.printStackTrace();
		}


	}






	//UPDATE metà
	public void Update(LibroDto dto) {
		try {
			Connection conn = DbConnection.getConnection();
			Libro entity = libromapper.toModel(dto);
			String sql = "UPDATE Libro \n"
					+ "SET titolo=?, casa_editrice=?, autori=?, categoria=? \n"
					+ ", isbn=?, note=?, stato=?, id_utente=? \n"
					+ "WHERE ID=? \n";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(2, entity.getTitolo());
			statement.setString(3, entity.getCasaEditrice());
			statement.setString(4, entity.getAutori());
			statement.setString(5, entity.getCategoria());
			statement.setString(6, entity.getIsbn());
			statement.setString(7, entity.getNote());
			statement.setString(8, entity.getStato());
			statement.setLong(9, entity.getIdUtente());
			statement.executeUpdate();


		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	public LibroDto getOne(Long id) {
		if (id == null) {
			return null;
		}
		LibroDto dto = null;

		try {
			Connection conn = DbConnection.getConnection();
			String sql = "SELECT * FROM libro WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			rs.next();
			Libro libro = new Libro();
			libro.setId(rs.getLong("id"));
			libro.setTitolo(rs.getString("titolo"));
			libro.setAutori(rs.getString("autore"));
			libro.setCategoria(rs.getString("categoria"));
			libro.setStato(rs.getString("stato"));
			libro.setCasaEditrice(rs.getString("casa editrice"));
			dto = libromapper.toDto(libro);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
