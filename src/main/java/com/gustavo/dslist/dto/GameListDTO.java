package com.gustavo.dslist.dto;

import com.gustavo.dslist.entities.GameList;

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	// só getters pois é consulta
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
