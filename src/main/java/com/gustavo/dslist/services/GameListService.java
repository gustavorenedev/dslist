package com.gustavo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.entities.GameList;
import com.gustavo.dslist.projections.GameMinProjection;
import com.gustavo.dslist.repositories.GameListRepository;
import com.gustavo.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	// findall que retorna um gamelistDTO
	public List<GameListDTO> finAll(){
		//gameListRepository.findAll() retornando numa lista de GameList
 		List<GameList> result = gameListRepository.findAll();
 		// pega cada objeto da lista original e transforma em uma GameList
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	// função para mover um array para outra posição
					// id da lista	index origem		e o destino
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		// remove o game da posição
		GameMinProjection obj = list.remove(sourceIndex);
		// transfere para a posição desejada
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
	
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
