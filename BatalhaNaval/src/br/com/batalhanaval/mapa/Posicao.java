package br.com.batalhanaval.mapa;

public class Posicao {
	private Linha linha;
	private int coluna;
	private boolean posicaoAtingida;
	private boolean posicaoOcupada;
	
	public Posicao(Linha linha, int coluna,boolean posicaoOcupada) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.posicaoAtingida = false;
		this.posicaoOcupada = posicaoOcupada;
	}
	
	private Posicao(int linha , int coluna,boolean posicaoOcupada){
		this.posicaoOcupada = posicaoOcupada;
		this.posicaoAtingida = false;
		for(Linha l : Linha.values()){
			if(l.getNumero() == linha){
				this.linha = l;
				this.coluna = coluna;
				break;
			}
		}
	}

	public Linha getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	public Posicao posicaoNova(int incrementoLinha, int incrementoColuna){
		return new Posicao(this.getLinha().getNumero() + incrementoLinha, this.getColuna() + incrementoColuna,this.isPosicaoOcupada());
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
		Posicao other = (Posicao) obj;
		if (coluna != other.coluna)
			return false;
		if (linha != other.linha)
			return false;
		return true;
	}
	
	
}
