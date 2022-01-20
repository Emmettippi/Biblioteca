package it.etlabora.biblioteca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.etlabora.biblioteca.dto.LibroDto;
import it.etlabora.biblioteca.dto.UtenteDto;
import it.etlabora.biblioteca.mapper.UtenteMapper;
import it.etlabora.biblioteca.model.Libro;
import it.etlabora.biblioteca.model.Utente;
import it.etlabora.biblioteca.util.DbConnection;

public class UtenteService {
	private UtenteMapper  utentemapper = new UtenteMapper();
	public void Registrazione(UtenteDto dto) {
		try {
			Connection conn= DbConnection.getConnection();
			Utente entity = utentemapper.toModel(dto);
			String sql = "INSERT INTO Utente \n " + "(nome,cognome,email,username,pass) \n" + "VALUES(?,?,?,?,md5(?)) \n";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, entity.getNome());
			statement.setString(2, entity.getCognome());
			statement.setString(3, entity.getEmail());
			statement.setString(4, entity.getUsername());
			statement.setString(5, entity.getPassword());
			statement.executeUpdate();





		}catch(Exception e) {
			e.printStackTrace();
		}


	}
	public UtenteDto login(String username, String password) {
		String sql = "SELECT * FROM utente WHERE username = ? AND pass = md5(?)";
		UtenteDto dto= new UtenteDto();
		try {Connection conn= DbConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		if(statement.executeQuery().next()) {
			
		
			ResultSet rs = statement.executeQuery();
			rs.next();
			Utente untente = new Utente();
			untente.setId(rs.getLong("id"));
			untente.setNome(rs.getString("titolo"));
			untente.setCognome(rs.getString("autori"));
			untente.setUsername(rs.getString("categoria"));
			untente.setEmail(rs.getString("stato"));
			dto = utentemapper.toDto(untente);
			
			return dto;
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;
	}

}



