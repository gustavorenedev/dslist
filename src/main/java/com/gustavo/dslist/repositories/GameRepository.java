package com.gustavo.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.dslist.entities.Game;

// nome da entidade + sufixo do tipo de componente(repository,service,controller)
// extendemos com o JPA e dentro do <"tipo da entidade", "tipo do ID da entidade">
// consulta do banco de dados
public interface GameRepository extends JpaRepository<Game, Long> {
	 
}
