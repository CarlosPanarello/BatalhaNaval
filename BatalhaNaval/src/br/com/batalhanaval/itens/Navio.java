package br.com.batalhanaval.itens;

import br.com.batalhanaval.mapa.ItemMapa;
import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;


public abstract class Navio extends ItemMapa {
	private Rotacao rotacao;
	protected int pontuacao;
	
	protected Navio(Posicao posicaoInicial, Rotacao rotacao, int pontuacao) {
		super(posicaoInicial);
		this.rotacao = rotacao;
		this.pontuacao = pontuacao;
	}

	public Rotacao getRotacao() {
		return rotacao;
	}
	
	public abstract int getPontuacao();
}
