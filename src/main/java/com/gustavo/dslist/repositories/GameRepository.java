package com.gustavo.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavo.dslist.entities.Game;
import com.gustavo.dslist.projections.GameMinProjection;

// nome da entidade + sufixo do tipo de componente(repository,service,controller)
// extendemos com o JPA e dentro do <"tipo da entidade", "tipo do ID da entidade">
// consulta do banco de dados
public interface GameRepository extends JpaRepository<Game, Long> {
	 
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	// escrever um método colocando um parametro do que você quer consultar
	// Long listId = :listId
	List<GameMinProjection> searchByList(Long listId);
}
