package br.com.batalhanaval;

import java.util.ArrayList;

public abstract class Navio {
	
	ArrayList<Posicao> posicoesOcupadas;
	
	protected Navio(ArrayList<Posicao> posicoes){
		this.posicoesOcupadas = posicoes;
	}
	
	protected Navio(){
		this.posicoesOcupadas = new ArrayList<Posicao>();
	}
	
}
