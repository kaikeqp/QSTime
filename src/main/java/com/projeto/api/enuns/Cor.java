package com.projeto.api.enuns;

public enum Cor {

	Vermelho("red"),
	Amarelo("yellow"),
	Azul("blue"),
	Verde("green"),
	Preto("black");
	
	private String cor;
	
	private Cor (String cor) {
		this.cor = cor;
	}
}
