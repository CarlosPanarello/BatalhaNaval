package br.com.batalhanaval.itens;

import java.util.ArrayList;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;

public class Navio2Canos extends Navio {
	public Navio2Canos(Item posicaoInicial,Rotacao rotacao){
		posicaoInicial.setTipo(TipoItem.Navio);

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

	// *##  *posicao central   
	private ArrayList<Item> gerarPosicoesHorizontal (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		return posicoes;
	}

	//  #        
	//  #
 	//  *    *posicao central        
	private ArrayList<Item> gerarPosicoesVertical (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		return posicoes;

	}
}
