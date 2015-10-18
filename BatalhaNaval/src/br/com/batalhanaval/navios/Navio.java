package br.com.batalhanaval.navios;

import java.util.HashSet;

import br.com.batalhanaval.mapa.Item;

public abstract class Navio {
	
	private HashSet<Item> posicoesOcupadas;
	
	protected Navio(HashSet<Item> posicoes){
		this.posicoesOcupadas = posicoes;
	}
	
	protected Navio(){
		this.posicoesOcupadas = new HashSet<Item>();
	}

	public HashSet<Item> getPosicoesOcupadas() {
		return posicoesOcupadas;
	}
	
	
	
}
