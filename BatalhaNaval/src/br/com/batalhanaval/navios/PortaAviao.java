package br.com.batalhanaval.navios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Linha;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;

public class PortaAviao extends Navio {

	public PortaAviao(Linha linha, int coluna,Rotacao rotacao){
		Item posicaoInicial = new Item(linha, coluna, true, TipoItem.PortaAviao, 100);
		this.fator = (new BigDecimal(1.25)).setScale(2,RoundingMode.CEILING);
		switch (rotacao) {
		case Direita:
			getPosicoesOcupadas().addAll(gerarPosicoesDireita(posicaoInicial));
			break;
		case Esquerda:
			getPosicoesOcupadas().addAll(gerarPosicoesEsquerda(posicaoInicial));
			break;
		case Cima:
			getPosicoesOcupadas().addAll(gerarPosicoesCima(posicaoInicial));
			break;
		case Baixo:
			getPosicoesOcupadas().addAll(gerarPosicoesBaixo(posicaoInicial));
			break;
		default:
			break;
		}
	}

	//  #   
	// *###  *posicao central   
	//  #
	private ArrayList<Item> gerarPosicoesDireita (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial.posicaoNova(-1, 0));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		posicoes.add(posicaoInicial.posicaoNova(0, 2));
		
		return posicoes;
		
	}
	
	//    #   
	//  ###*  *posicao central   
	//    #
	private ArrayList<Item> gerarPosicoesEsquerda (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial.posicaoNova(-1, 0));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(1, 0));
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial.posicaoNova(0, -2));
		
		return posicoes;
	}
	

	//  #     
	//  #        *posicao central
	// ###   
 	//  *            
	private ArrayList<Item> gerarPosicoesCima (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		
		posicoes.add(posicaoInicial.posicaoNova(-1,0));
		posicoes.add(posicaoInicial.posicaoNova(-2,0));
		
		return posicoes;
	}
	
	//  *     
	// ###        *posicao central
	// 	#   
 	//  #            
	private ArrayList<Item> gerarPosicoesBaixo (Item posicaoInicial){
		ArrayList<Item> posicoes = new ArrayList<Item>();
		
		posicoes.add(posicaoInicial.posicaoNova(0, -1));
		posicoes.add(posicaoInicial);
		posicoes.add(posicaoInicial.posicaoNova(0, 1));
		
		posicoes.add(posicaoInicial.posicaoNova(1,0));
		posicoes.add(posicaoInicial.posicaoNova(2,0));
		
		return posicoes;
	}

	
}
