package com.gustavo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
	 
}
