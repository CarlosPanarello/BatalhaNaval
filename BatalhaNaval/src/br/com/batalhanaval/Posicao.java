package br.com.batalhanaval;

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

	public void setPosicaoOcupada(boolean posicaoOcupada) {
		this.posicaoOcupada = posicaoOcupada;
	}
}
