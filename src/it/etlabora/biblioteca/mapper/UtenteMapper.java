package it.etlabora.biblioteca.mapper;
import java.util.ArrayList;
import java.util.List;

import it.etlabora.biblioteca.dto.UtenteDto;
import it.etlabora.biblioteca.model.Utente;

public class UtenteMapper {
	public UtenteDto toDto(Utente utente) {
		if(utente == null) {
			return null;
		}
		
		UtenteDto dto = new UtenteDto();
		dto.setId(utente.getId());
		dto.setNome(utente.getNome());
		dto.setCognome(utente.getCognome());
		dto.setEmail(utente.getEmail());
		dto.setUsername(utente.getUsername());
		dto.setPassword(utente.getPassword());
		dto.setAdmin(utente.isAdmin());
		
		return dto;
	}
	
	public Utente toModel(UtenteDto dto) {
		if(dto == null) {
			return null;
		}
		
		Utente utente = new Utente();
		utente.setId(dto.getId());
		utente.setNome(dto.getNome());
		utente.setCognome(dto.getCognome());
		utente.setEmail(dto.getEmail());
		utente.setUsername(dto.getUsername());
		utente.setPassword(dto.getPassword());
		utente.setAdmin(dto.isAdmin());
		return utente;
	}
	
	public List<UtenteDto> toDto(List<Utente> utenti ){
		if(utenti == null) {
			return null;
		}
		
		List<UtenteDto> dtos = new ArrayList<>();
		for(Utente utente:utenti) {
			dtos.add(toDto(utente));
		}
		return dtos;
	}
	
	public List<Utente> toModel(List<UtenteDto> dtos){
		if(dtos == null) {
			return null;
		}
		List<Utente> utenti = new ArrayList<>();
		for(UtenteDto dto: dtos) {
			utenti.add(toModel(dto));
		}
		return utenti;
		
	}
}
