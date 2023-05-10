package com.gustavo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavo.dslist.dto.GameDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.entities.Game;
import com.gustavo.dslist.repositories.GameRepository;

// ditamos sobre alguma regra que precisa acontecer, uma regra de negócio basicamente
@Service // registra o GameService como um componente do sistema
public class GameService {
	
	// injetando uma instancia do GameRepository dentro do GameService
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) // assegurando que não vou fazer nenhuma operação de escrita  
	public GameDTO findByid(Long id) {
		// .findById() = ele recebe um id
		// .get() = sem ele é retornado um tipo "optional" e para o find pegar este id
		// ele precisa do get para pegar
		Game result = gameRepository.findById(id).get();
		// convertendo um objeto Game para GameDTO
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	// criando um método que devolve o construtor GameMinDTO
	@Transactional(readOnly = true)
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
