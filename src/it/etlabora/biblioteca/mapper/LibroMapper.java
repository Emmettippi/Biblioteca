package it.etlabora.biblioteca.mapper;
import java.util.ArrayList;
import java.util.List;

import it.etlabora.biblioteca.dto.LibroDto;
import it.etlabora.biblioteca.model.Libro;


public class LibroMapper {
	 public LibroDto toDto(Libro libro) {
		 if(libro == null) {
			 return null;
		 }
		 
		 LibroDto dto = new LibroDto();
		 dto.setId(libro.getId());
		 dto.setTitolo(libro.getTitolo());
		 dto.setCasaEditrice(libro.getCasaEditrice());
		 dto.setAutori(libro.getAutori());
		 dto.setCategoria(libro.getCategoria());
		 dto.setIsbn(libro.getIsbn());
		 dto.setNote(libro.getNote());
		 dto.setStato(libro.getStato());
		 dto.setIdUtente(libro.getIdUtente());
		 return dto;
		 
	 }
	 
	 public Libro toModel(LibroDto dto) {
		 if(dto == null) {
			 return null;
		 }
		 Libro libro = new Libro();
		 libro.setId(dto.getId());
		 libro.setTitolo(dto.getTitolo());
		 libro.setCasaEditrice(dto.getCasaEditrice());
		 libro.setAutori(dto.getAutori());
		 libro.setCategoria(dto.getCategoria());
		 libro.setIsbn(dto.getIsbn());
		 libro.setNote(dto.getNote());
		 libro.setStato(dto.getStato());
		 libro.setIdUtente(dto.getIdUtente());
		 return libro;
	 }
	 
	 public List<LibroDto> toDto(List<Libro> libri){
		 if(libri == null) {
			 return null;
		 }
		 
		 List<LibroDto> dtos = new ArrayList<>();
		 for(Libro libro: libri) {
			 dtos.add(toDto(libro));
		 }
		 
		 return dtos;
	 }
	 
	 public List<Libro> toModel(List<LibroDto> dtos){
		 if(dtos == null) {
			 return null;
		 }
		 
		 List<Libro> libri = new ArrayList<>();
		 for(LibroDto dto: dtos) {
			 libri.add(toModel(dto));
		 }
		 return libri;
	 }
}
