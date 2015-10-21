package br.com.batalhanaval.itens;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;

public class Navio1Cano extends Navio {
	public Navio1Cano(Item posicaoInicial,Rotacao rotacao){
		posicaoInicial.setTipo(TipoItem.Navio);
		switch (rotacao) {
		case Direita:
		case Esquerda:
		case Cima:
		case Baixo:
			getPosicoesOcupadas().add(posicaoInicial);
			break;
		default:
			break;
		}
	}
}
