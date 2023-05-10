package com.gustavo.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.dslist.dto.GameListDTO;
import com.gustavo.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping // mapeando o método como um Get 
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.finAll();
		return result;
	}
	
}
