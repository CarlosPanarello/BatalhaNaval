package br.com.batalhanaval.mapa;

import java.util.HashSet;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.navios.Navio;

public class Mapa {
		
	private int qtdLinha;
	private int qtdColuna;
	
	private HashSet<Posicao> itens;
	
	public Mapa(){
		this(10);
	}
	
	private Mapa(int tamanho) {
		this(tamanho,tamanho);
	}
	
	private Mapa(int qtdLinha, int qtdColuna) {
		super();
		this.qtdLinha = qtdLinha;
		this.qtdColuna = qtdColuna;
		popularMapa();
	}
	
	private void popularMapa(){
		itens = new HashSet<Posicao>();
		
		//linha
		for(Linha linha: Linha.values()){
			
			if(linha.getNumero() <= qtdLinha ){
				//coluna
				for(int icoluna = 1; icoluna <= qtdColuna; icoluna++){
					itens.add(new Posicao(linha, icoluna, false));
				}				
			}
		}
	}
	
	public Mensagens addNavioNoMapa(Navio navio){
		
		for(Posicao pNavio : navio.getPosicoesOcupadas()){
			for(Posicao pMapa : itens){
				if(pNavio.equals(pMapa) && pMapa.isPosicaoOcupada()){
					return Mensagens.NAVIO_POSICAO_INVALIDA;
				}
			}
		}
		
		itens.removeAll(navio.getPosicoesOcupadas());
		itens.addAll(navio.getPosicoesOcupadas());
		
		return Mensagens.NAVIO_ADICIONADO;
	}
	
	
	public Mensagens addTiro(Posicao posicao){
		for(Posicao p : itens){
			if(p.equals(posicao)){
				if( p.isPosicaoOcupada()){
					p.setPosicaoAtingida(true);
					return Mensagens.TIRO_ACERTOU;
				} else {
					return Mensagens.TIRO_NA_AGUA;
				}
			}
		}
		return Mensagens.TIRO_NA_AGUA;
	}
	
	public int getQtdLinha() {
		return qtdLinha;
	}
	public int getQtdColuna() {
		return qtdColuna;
	}

	public HashSet<Posicao> getItens() {
		return itens;
	}
	
}
