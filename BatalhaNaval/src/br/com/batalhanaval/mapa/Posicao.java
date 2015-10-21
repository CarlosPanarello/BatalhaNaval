package br.com.batalhanaval.mapa;

public class Posicao implements Comparable<Posicao>{
	private Linha linha;
	private int coluna;
	
	
	public Posicao(Linha linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
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
	
	public Posicao posicaoNova(int incrementoLinha, int incrementoColuna){
		
		Linha l = obterLinha(this.getLinha().getNumero() + incrementoLinha);
		
		return new Posicao(l , this.coluna + incrementoColuna);
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
	
	@Override
	public int compareTo(Posicao o) {
		if(o == null){
			return -1;
		}
		
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
	
	
}
