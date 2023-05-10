package com.gustavo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.dto.GameMinDTO;
import com.gustavo.dslist.services.GameListService;
import com.gustavo.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping // mapeando o método como um Get 
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.finAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games") // 
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		// filtrando pela lista do id qual o genero do game
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
}
