package com.gustavo.dslist.projections;

// colocando métodos GET correspondente a minha consulta sql
public interface GameMinProjection {
	
	// pegando todas as propriedades do GameRepository
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
