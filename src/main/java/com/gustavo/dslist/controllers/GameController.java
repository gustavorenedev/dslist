package com.gustavo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.dslist.dto.GameDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.services.GameService;

@RestController // Classe controladora
@RequestMapping(value = "/games") // configurando o caminho que vai ser disponibilizado
public class GameController {
	
	// injetando um service no controller
	@Autowired
	private GameService gameService;
	
	@GetMapping // mapeando o método como um Get 
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.finAll();
		return result;
	}
	
	@GetMapping(value = "/{id}") // esse get agora recebe um id na rota
	// @PathVariable = faz a comparação de id's
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findByid(id);
		return result;
	}
}
