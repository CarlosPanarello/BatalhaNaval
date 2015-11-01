package br.com.batalhanaval.navios;

import java.math.BigDecimal;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Linha;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;

public class Navio1Cano extends Navio {
	public Navio1Cano(Linha linha, int coluna,Rotacao rotacao){
		Item posicaoInicial = new Item(linha, coluna, true, TipoItem.Navio1, 20);
		this.fator = BigDecimal.ONE;
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
