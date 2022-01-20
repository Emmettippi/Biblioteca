package it.etlabora.biblioteca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import it.etlabora.biblioteca.dto.LibroDto;
import it.etlabora.biblioteca.dto.UtenteDto;
import it.etlabora.biblioteca.mapper.UtenteMapper;
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

}



