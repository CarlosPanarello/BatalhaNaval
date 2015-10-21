package br.com.batalhanaval.mapa;

public class Posicao implements Comparable<Posicao>{
	private boolean posicaoAtingida;
	private boolean posicaoOcupada;
	private String  simboloMapa;
	private Ponto ponto;
	
	public Posicao(Ponto p) {
		super();
		this.ponto = p;
		this.posicaoAtingida = false;
		this.posicaoOcupada = false;
	}
	
	public Posicao(Ponto p,boolean posicaoOcupada,String simboloMapa){
		this(p);
		this.posicaoOcupada = posicaoOcupada;
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

	public String getSimboloMapa() {
		return simboloMapa;
	}
	
	public boolean posicaoPertenceLinha(Linha linha){
		return this.ponto.getLinha().equals(linha);
	}

	public Ponto getPonto() {
		return ponto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ponto == null) ? 0 : ponto.hashCode());
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
		if (ponto == null) {
			if (other.ponto != null)
				return false;
		} else if (!ponto.equals(other.ponto))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Posicao arg0) {
		if(this.equals(arg0)){
			return 0;
		}
		
		if(arg0 == null || arg0.getPonto() == null){
			return -1;
		}
		
		return this.getPonto().compareTo(arg0.getPonto());
	}

	@Override
	public String toString() {
		
		if(this.posicaoAtingida){
			return "*" + this.simboloMapa + "*";
		}
		
		return " " + this.simboloMapa + " ";
	}
}
