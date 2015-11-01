package br.com.batalhanaval.navios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Linha;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;

public class Navio3Canos extends Navio {
	public Navio3Canos(Linha linha, int coluna,Rotacao rotacao){
		Item posicaoInicial = new Item(linha, coluna, true, TipoItem.Navio3, 60);
		this.fator = (new BigDecimal(1.15)).setScale(2,RoundingMode.CEILING);
		switch (rotacao) {
		case Direita:
		case Esquerda:
			getPosicoesOcupadas().addAll(gerarPosicoesHorizontal(posicaoInicial));
			break;
		case Cima:
		case Baixo:
			getPosicoesOcupadas().addAll(gerarPosicoesVertical(posicaoInicial));
			break;
		default:
			break;
		}
	}

	// *###  *posicao central   
	private ArrayList<Item> gerarPosicoesHorizontal (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		posicoes.add(posicaoInicial.posicaoNova(0, 2));
		return posicoes;


	}

	//  #        *posicao central
	//  #
	//  #
 	//  *            
	private ArrayList<Item> gerarPosicoesVertical (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		posicoes.add(posicaoInicial.posicaoNova(2, 0));
		return posicoes;

	}
}
