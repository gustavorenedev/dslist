package com.gustavo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.entities.Game;
import com.gustavo.dslist.repositories.GameRepository;

// ditamos sobre alguma regra que precisa acontecer, uma regra de negócio basicamente
@Service // registra o GameService como um componente do sistema
public class GameService {
	
	// injetando uma instancia do GameRepository dentro do GameService
	@Autowired
	private GameRepository gameRepository;
	
	// criando um método que devolve o construtor GameMinDTO
	public List<GameMinDTO> finAll(){
		// result recebe uma consulta de todos e atribui numa lista
		List<Game> result = gameRepository.findAll();
		// fazendo com que o DTO retorne na api
		// dto recebe result.stream = uma lib que pode fazer operação com uma sequencia de dados
		// .map = transforma objeto de uma coisa em outra, ou seja, todo game x vai passar a ser um GameMinDTO
		// .tolist = volta o stream para uma lista normal
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
