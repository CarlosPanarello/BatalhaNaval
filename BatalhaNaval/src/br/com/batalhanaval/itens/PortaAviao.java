package br.com.batalhanaval.itens;

import java.util.ArrayList;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.mapa.Ponto;
import br.com.batalhanaval.mapa.Posicao;
import br.com.batalhanaval.mapa.Rotacao;

public class PortaAviao extends Navio {

	public PortaAviao(Ponto pontoInicial,Rotacao rotacao){
		super(new Posicao(pontoInicial,true, "P"), rotacao, 1000);
		
		switch (rotacao) {
		case Direita:
			getPosicoes().addAll(gerarPosicoesDireita(pontoInicial));
			break;
		case Esquerda:
			getPosicoes().addAll(gerarPosicoesEsquerda(pontoInicial));
			break;
		case Cima:
			getPosicoes().addAll(gerarPosicoesCima(pontoInicial));
			break;
		case Baixo:
			getPosicoes().addAll(gerarPosicoesBaixo(pontoInicial));
			break;
		default:
			break;
		}
	}

	//  #   
	// *###  *posicao central   
	//  #
	private ArrayList<Posicao> gerarPosicoesDireita (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		 
		
		Ponto novoPonto = pontoInicial.novoPonto(-1, 0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
		novoPonto = pontoInicial.novoPonto(1, 0);
		posicoes.add(new Posicao(novoPonto, true, "P"));

		novoPonto = pontoInicial.novoPonto(0, 1);
		posicoes.add(new Posicao(novoPonto, true, "P"));

		novoPonto = pontoInicial.novoPonto(0, 2);
		posicoes.add(new Posicao(novoPonto, true, "P"));
		
		return posicoes;
	}
	
	//    #   
	//  ###*  *posicao central   
	//    #
	private ArrayList<Posicao> gerarPosicoesEsquerda (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		Ponto novoPonto = pontoInicial.novoPonto(-1, 0);
		posicoes.add(new Posicao(novoPonto, true, "P"));  
		
		novoPonto = pontoInicial.novoPonto(1, 0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(0, -1);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(0, -2);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
		return posicoes;
	}
	

	//  #     
	//  #        *posicao central
	// ###   
 	//  *            
	private ArrayList<Posicao> gerarPosicoesCima (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		
		Ponto novoPonto = pontoInicial.novoPonto(0,-1);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
		novoPonto = pontoInicial.novoPonto(0, 1);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(-1,0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(-2,0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
		return posicoes;
	}
	
	//  *     
	// ###        *posicao central
	// 	#   
 	//  #            
	private ArrayList<Posicao> gerarPosicoesBaixo (Ponto pontoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		Ponto novoPonto = pontoInicial.novoPonto(0,-1);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
		novoPonto = pontoInicial.novoPonto(0, 1);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(1,0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 

		novoPonto = pontoInicial.novoPonto(2,0);
		posicoes.add(new Posicao(novoPonto, true, "P")); 
		
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
			
			return Mensagens.AFUNDOU_PORTA;
		} else {
			return Mensagens.TIRO_POSICAO_INVALIDA;
		}
	}
}
