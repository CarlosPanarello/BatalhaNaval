package br.com.batalhanaval;

public class Posicao {
	private Linha linha;
	private int coluna;
	
	public Posicao(Linha linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	
	private Posicao(int linha , int coluna){

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
		return new Posicao(this.getLinha().getNumero() + incrementoLinha, this.getColuna() + incrementoColuna);
	}
}
