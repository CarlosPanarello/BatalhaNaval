package br.com.batalhanaval.itens;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.mapa.ItemMapa;
import br.com.batalhanaval.mapa.Ponto;
import br.com.batalhanaval.mapa.Posicao;

public class Agua extends ItemMapa {
	
	public Agua(Ponto ponto) {
		super(new Posicao(ponto, false, "~"));
	}

	public Mensagens recebeTiro(Ponto p) {
		if(this.itemAtingido(p)){
			return Mensagens.TIRO_NA_AGUA;
		} else {
			return Mensagens.TIRO_POSICAO_INVALIDA;
		}
	}

}
