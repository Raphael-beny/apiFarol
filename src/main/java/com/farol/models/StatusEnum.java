package com.farol.models;

public enum StatusEnum {
	
	ATIVO('A'),
	INATIVO('I');
	
	private char status;
	
	StatusEnum(char status){
		this.status = status;
	}
	
	public char getStatus() { return status; }

}
