package com.gustavo.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	// A grosso modo a referencia seria assim em um relacionamento N para N
//	private Game game;
//	private GameList list;
//	private Integer position;
	// BelongingPK = uma classe auxiliar que compõem duas chaves primárias em uma só
	@EmbeddedId //
	private BelongingPK id = new BelongingPK();
	private Integer position;
	
	public Belonging() {
		
	}

	// instanciando os objetos para receber seus respectivos id's e depois jogar para o BelongingPK
	public Belonging(Game game, GameList list, Integer position) {
		this.id.setGame(game);
		this.id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
