package br.com.batalhanaval.navios;

import java.util.HashSet;

import br.com.batalhanaval.mapa.Posicao;

public abstract class Navio {
	
	private HashSet<Posicao> posicoesOcupadas;
	
	protected Navio(HashSet<Posicao> posicoes){
		this.posicoesOcupadas = posicoes;
	}
	
	protected Navio(){
		this.posicoesOcupadas = new HashSet<Posicao>();
	}

	public HashSet<Posicao> getPosicoesOcupadas() {
		return posicoesOcupadas;
	}
	
	
	
}
