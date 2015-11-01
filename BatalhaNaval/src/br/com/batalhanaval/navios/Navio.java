package br.com.batalhanaval.navios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;

import br.com.batalhanaval.mapa.Item;

public abstract class Navio {
	
	protected BigDecimal fator;
	
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
	
	public BigDecimal pontuacao (){
		BigDecimal valorTotal = BigDecimal.ZERO;
		int qtdAcertos = 0;
		for(Item i: posicoesOcupadas){
			if(i.isPosicaoAtingida()){
				valorTotal = valorTotal.add(new BigDecimal(i.getPontuacao()));
				qtdAcertos++;
				
			}
		}
		
		if(qtdAcertos == posicoesOcupadas.size()){
			return (valorTotal.multiply(fator)).setScale(2,RoundingMode.CEILING);
		}
		
		return valorTotal.setScale(2,RoundingMode.CEILING);
	}
	
	public boolean navioAfundou(){
		int qtdAtingido =0 ;
		for(Item i: posicoesOcupadas){
			if (i.isPosicaoAtingida()){
				qtdAtingido++;
			}
		}
		
		return posicoesOcupadas.size() == qtdAtingido;
	}
	
}
