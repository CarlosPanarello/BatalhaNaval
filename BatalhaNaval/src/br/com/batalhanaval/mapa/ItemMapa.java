package br.com.batalhanaval.mapa;

import java.util.HashSet;

import br.com.batalhanaval.Mensagens;

public abstract class ItemMapa{
	
	private HashSet<Posicao> posicoes;
	
	protected ItemMapa(Posicao p){
		posicoes = new HashSet<Posicao>();
		posicoes.add(p);
	}
	
//	protected ItemMapa(HashSet<Posicao> posicoes){
//		this.posicoes = new HashSet<Posicao>();
//		this.posicoes.addAll(posicoes);
//	}
	
	public abstract Mensagens recebeTiro(Ponto p);
	
	protected boolean itemAtingido(Ponto p){
		Posicao posicao = itemPossuiPosicao(p); 
		if(posicao != null){
			posicao.setPosicaoAtingida(true);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean itemCompletamenteAtingido(){
		for(Posicao p: posicoes){
			if(p.isPosicaoAtingida() == false){
				return false;
			}
		}
		return true;
	}
	
	private Posicao itemPossuiPosicao(Ponto p){
		for(Posicao posicao:posicoes){
			if(posicao.getPonto().equals(p)){
				return posicao;
			}
		}
		return null;
	}

	public HashSet<Posicao> getPosicoes() {
		return posicoes;
	}
}
