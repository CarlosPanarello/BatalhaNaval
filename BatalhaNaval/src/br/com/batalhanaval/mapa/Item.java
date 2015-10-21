package br.com.batalhanaval.mapa;

public class Item implements Comparable<Item> {

	private boolean posicaoAtingida;
	private boolean posicaoOcupada;
	private TipoItem tipo;
	
	private Posicao posicao;
	
	public Item (Linha linha, int coluna){
		this(linha, coluna, false, TipoItem.Agua);
	}
	
	Item(Linha linha, int coluna,boolean posicaoOcupada,TipoItem tipo) {
		super();
		this.posicaoAtingida = false;
		this.posicaoOcupada = posicaoOcupada;
		this.tipo = tipo;
	}

	public boolean isPosicaoAtingida() {
		return posicaoAtingida;
	}

	public void setPosicaoAtingida(boolean posicaoAtingida) {
		this.posicaoAtingida = posicaoAtingida;
	}

	public boolean isPosicaoOcupada() {
		return posicaoOcupada;
	}
	
	public TipoItem getTipo() {
		return tipo;
	}

	public void setTipo(TipoItem tipo) {
		
		switch (tipo) {
		case Agua:
			posicaoOcupada = false;
			break;

		default:
			posicaoOcupada = true;
			break;
		}
		
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		
		if(this.posicaoAtingida){
			return "*" + tipo.getDesc() + "*";
		}
		
		return " " + tipo.getDesc() + " ";
	}
}
