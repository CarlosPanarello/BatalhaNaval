package br.com.batalhanaval.itens;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.mapa.Ponto;
import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;

public class Navio1Cano extends Navio {
	
	public Navio1Cano(Ponto pontoInicial,Rotacao rotacao){
		super(new Posicao(pontoInicial,true, "N"), rotacao, 50);
	}

	@Override
	public int getPontuacao() {
	int qtdPosicoes = this.getPosicoes().size();
		
		int qtdAtingidos = 0;
		
		for(Posicao p: getPosicoes()){
			if(p.isPosicaoAtingida()){
				qtdAtingidos++;
			}
		}
		
		if(qtdAtingidos == 0 )
			return 0;
		
		return (qtdPosicoes/qtdAtingidos ) * this.pontuacao;
	}

	@Override
	public Mensagens recebeTiro(Ponto p) {
		if(this.itemAtingido(p)){
			
			for(Posicao pos:getPosicoes()){
				if(!pos.isPosicaoAtingida()){
					return Mensagens.TIRO_ACERTOU;
				}
			}
			
			return Mensagens.AFUNDOU_N1;
		} else {
			return Mensagens.TIRO_POSICAO_INVALIDA;
		}
	}	
}
