package com.gustavo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.entities.GameList;
import com.gustavo.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	// findall que retorna um gamelistDTO
	public List<GameListDTO> finAll(){
		//gameListRepository.findAll() retornando numa lista de GameList
 		List<GameList> result = gameListRepository.findAll();
 		// pega cada objeto da lista original e transforma em uma GameList
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
}
