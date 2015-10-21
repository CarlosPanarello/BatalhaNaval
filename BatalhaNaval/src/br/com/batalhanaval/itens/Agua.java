package br.com.batalhanaval.itens;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.mapa.ItemMapa;
import br.com.batalhanaval.mapa.Posicao;

public class Agua extends ItemMapa {

	public Agua(Posicao p) {
		super(p,false,"~");
	}

	@Override
	public Mensagens recebeTiro() {
		this.setPosicaoAtingida(true);
		return Mensagens.TIRO_NA_AGUA;
	}

}
