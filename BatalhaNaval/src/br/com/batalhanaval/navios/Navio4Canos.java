package br.com.batalhanaval.navios;

import java.util.ArrayList;

import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;

public class Navio4Canos extends Navio {
	public Navio4Canos(Posicao posicaoInicial,Rotacao rotacao){
		switch (rotacao) {
		case Direita:
		case Esquerda:
			gerarPosicoesHorizontal(posicaoInicial);
			break;
		case Cima:
		case Baixo:
			gerarPosicoesVertical(posicaoInicial);
			break;
		default:
			break;
		}
	}

	// *####  *posicao central   
	private void gerarPosicoesHorizontal (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		posicoes.add(posicaoInicial.posicaoNova(0, 2));
		posicoes.add(posicaoInicial.posicaoNova(0, 3));

	}

	//  #     
	//  #        *posicao central
	//  #
	//  #
 	//  *            
	private void gerarPosicoesVertical (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		posicoes.add(posicaoInicial.posicaoNova(2, 0));
		posicoes.add(posicaoInicial.posicaoNova(3, 0));
	}
}
