package br.com.batalhanaval;

import java.util.ArrayList;

public class PortaAviao extends Navio {

	public PortaAviao(Posicao posicaoInicial,Rotacao rotacao){
		switch (rotacao) {
		case Direita:
			gerarPosicoesDireita(posicaoInicial);
			break;
		case Esquerda:
			gerarPosicoesEsquerda(posicaoInicial);
			break;
		case Cima:
			gerarPosicoesCima(posicaoInicial);
			break;
		case Baixo:
			gerarPosicoesBaixo(posicaoInicial);
			break;
		default:
			break;
		}
	}

	//  #   
	// *###  *posicao central   
	//  #
	private void gerarPosicoesDireita (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.add(posicaoInicial.posicaoNova(-1, 0));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		posicoes.add(posicaoInicial.posicaoNova(0, 2));
	}
	
	//    #   
	//  ###*  *posicao central   
	//    #
	private void gerarPosicoesEsquerda (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.add(posicaoInicial.posicaoNova(-1, 0));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial.posicaoNova(0, -2));
	}
	

	//  #     
	//  #        *posicao central
	// ###   
 	//  *            
	private void gerarPosicoesCima (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		
		posicoes.add(posicaoInicial.posicaoNova(-1,0));
		posicoes.add(posicaoInicial.posicaoNova(-2,0));
	}
	
	//  *     
	// ###        *posicao central
	// 	#   
 	//  #            
	private void gerarPosicoesBaixo (Posicao posicaoInicial){
		ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		
		posicoes.add(posicaoInicial.posicaoNova(1,0));
		posicoes.add(posicaoInicial.posicaoNova(2,0));
	}

	
}
