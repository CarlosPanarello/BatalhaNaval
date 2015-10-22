package br.com.batalhanaval.itens;

import java.util.ArrayList;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.mapa.Ponto;
import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;

public class Navio4Canos extends Navio {
	public Navio4Canos(Ponto pontoInicial,Rotacao rotacao){
		super(new Posicao(pontoInicial,true, "N"), rotacao, 700);

		switch (rotacao) {
		case Direita:
		case Esquerda:
			getPosicoes().addAll(gerarPosicoesHorizontal(pontoInicial));
			break;
		case Cima:
		case Baixo:
			getPosicoes().addAll(gerarPosicoesVertical(pontoInicial));
			break;
		default:
			break;
		}
	}

	// *####  *posicao central   
	private ArrayList<Posicao> gerarPosicoesHorizontal (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		Ponto novoPonto = pontoInicial.novoPonto(0, 1);
		posicoes.add(new Posicao(novoPonto, true, "N"));

		novoPonto = pontoInicial.novoPonto(0, 2);
		posicoes.add(new Posicao(novoPonto, true, "N"));
		
		novoPonto = pontoInicial.novoPonto(0, 3);
		posicoes.add(new Posicao(novoPonto, true, "N"));
		
		return posicoes;
	}

	//  #     
	//  #        *posicao central
	//  #
	//  #
 	//  *            
	private ArrayList<Posicao> gerarPosicoesVertical (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		
		Ponto novoPonto = pontoInicial.novoPonto(1, 0);
		posicoes.add(new Posicao(novoPonto, true, "N"));

		novoPonto = pontoInicial.novoPonto(2, 0);
		posicoes.add(new Posicao(novoPonto, true, "N"));
		
		novoPonto = pontoInicial.novoPonto(3, 0);
		posicoes.add(new Posicao(novoPonto, true, "N"));
		
		return posicoes;
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
			
			return Mensagens.AFUNDOU_N4;
		} else {
			return Mensagens.TIRO_POSICAO_INVALIDA;
		}
	}
}
