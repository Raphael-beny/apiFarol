package com.farol.models;

public enum DisponibilidadeEnum {
	
	DISPONIVEL('D'),
	INDISPONIVEL('I');
	
	private char disponibilidade;
	
	DisponibilidadeEnum(char disponibilidade){
		this.disponibilidade = disponibilidade;
	}
	
	public char getDisponibilidade() {
		return disponibilidade; 
	}

}
