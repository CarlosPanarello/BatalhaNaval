package br.com.batalhanaval.navios;

import java.util.ArrayList;

import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;

public class Navio1Cano extends Navio {
	public Navio1Cano(Posicao posicaoInicial,Rotacao rotacao){
		switch (rotacao) {
		case Direita:
		case Esquerda:
		case Cima:
		case Baixo:
			ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
			posicoes.add(posicaoInicial);
			break;
		default:
			break;
		}
	}
}
