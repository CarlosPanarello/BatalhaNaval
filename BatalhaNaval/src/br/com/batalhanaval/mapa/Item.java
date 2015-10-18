package br.com.batalhanaval.mapa;

public class Item implements Comparable<Item> {
	private Linha linha;
	private int coluna;
	private boolean posicaoAtingida;
	private boolean posicaoOcupada;
	private TipoItem tipo;
	
	public Item (Linha linha, int coluna){
		this(linha, coluna, false, TipoItem.Agua);
	}
	
	Item(Linha linha, int coluna,boolean posicaoOcupada,TipoItem tipo) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.posicaoAtingida = false;
		this.posicaoOcupada = posicaoOcupada;
		this.tipo = tipo;
	}

	public Linha getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	private Linha obterLinha(int linha){
		
		for(Linha l : Linha.values()){
			if(l.getNumero() == linha){
				return l;
			}
		}
		return null;
	}
	
	public Item posicaoNova(int incrementoLinha, int incrementoColuna){
		
		Linha l = obterLinha(this.getLinha().getNumero() + incrementoLinha);
		
		return new Item(l, this.getColuna() + incrementoColuna,this.isPosicaoOcupada(),this.tipo);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coluna;
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}

	@Override
	public int compareTo(Item o) {
		if(this.getLinha().equals(o.getLinha())){
			if ( this.getColuna() == o.getColuna()){
				return 0;
			}
			
			if( this.getColuna() > o.getColuna()){
				return 1;
			} else {
				return -1;
			}
		}else{
			return this.getLinha().compareTo(o.getLinha());
		}
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
