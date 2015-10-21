package br.com.batalhanaval.mapa;

import br.com.batalhanaval.Mensagens;

public abstract class ItemMapa implements Comparable<ItemMapa> {
	
	private boolean posicaoAtingida;
	private boolean posicaoOcupada;
	private Posicao posicao;
	private String  simboloMapa;
	
	protected ItemMapa(Posicao p){
		this.posicao = p;
		this.posicaoAtingida = false;
	}
	
	protected ItemMapa(Posicao p,boolean posicaoOcupada,String simboloMapa){
		this(p);
		this.posicaoOcupada = posicaoOcupada;
	}

	public boolean isPosicaoAtingida() {
		return posicaoAtingida;
	}

	protected void setPosicaoAtingida(boolean posicaoAtingida) {
		this.posicaoAtingida = posicaoAtingida;
	}

	public boolean isPosicaoOcupada() {
		return posicaoOcupada;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public String getSimboloMapa() {
		return simboloMapa;
	}
	
	public abstract Mensagens recebeTiro();
	
	public boolean itemPertenceLinha(Linha linha){
		return this.posicao.getLinha().equals(linha);
	}
	
	@Override
	public String toString() {
		
		if(this.posicaoAtingida){
			return "*" + this.simboloMapa + "*";
		}
		
		return " " + this.simboloMapa + " ";
	}

	@Override
	public int compareTo(ItemMapa p) {
		if(p == null){
			return -1;
		}
				
		return this.posicao.compareTo(p.getPosicao());
	}

	
}
