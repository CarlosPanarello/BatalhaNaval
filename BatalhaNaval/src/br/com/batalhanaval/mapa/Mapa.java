package br.com.batalhanaval.mapa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.itens.Agua;
import br.com.batalhanaval.itens.Navio;

public class Mapa {
		
	private int qtdLinha;
	private int qtdColuna;
	
	private HashSet<ItemMapa> itens;
	
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
		inicializarMapa();
	}
	
	private void inicializarMapa(){
		itens = new HashSet<ItemMapa>();
		
		//linha
		for(Linha linha: Linha.values()){
			if(linha.getNumero() <= qtdLinha ){
				//coluna
				for(int icoluna = 1; icoluna <= qtdColuna; icoluna++){
					itens.add( new Agua(new Ponto(linha, icoluna)));
				}				
			}
		}
	}
	
	public Mensagens addNavioNoMapa(Navio navio){
		
		
		for(ItemMapa iMapa : itens){

			for(Posicao posMapa : iMapa.getPosicoes()){

				for(Posicao pNavio : navio.getPosicoes()){
					if(!iMapa.getPosicoes().contains(pNavio)){
						return Mensagens.NAVIO_POSICAO_INVALIDA;
					}

					if(pNavio.equals(posMapa) && posMapa.isPosicaoOcupada()){
						return Mensagens.NAVIO_POSICAO_OCUPADA;
					}
				}
			}
		}
		
		
		itens.remove(navio);
		itens.add(navio);
		
		return Mensagens.NAVIO_ADICIONADO;
	}
	
	
	public Mensagens addTiro(Posicao p){
		for(ItemMapa iMapa : itens){

			for(Posicao posMapa : iMapa.getPosicoes()){
				if(posMapa.equals(p)){
					return iMapa.recebeTiro(p.getPonto());
				}
			}
		}
		return Mensagens.TIRO_POSICAO_INVALIDA;
	}
	
	public int getQtdLinha() {
		return qtdLinha;
	}
	public int getQtdColuna() {
		return qtdColuna;
	}

	public HashSet<ItemMapa> getItens() {
		return itens;
	}
	
	public String getLinha(Linha linha){
		
		HashSet<Posicao> itensPos = new HashSet<Posicao>();
		String retorno = "|";
		
		for(ItemMapa iMapa : getItens()){
			for(Posicao posMapa : iMapa.getPosicoes()){
				if(posMapa.getPonto().getLinha().equals(linha)){
					itensPos.add(posMapa);
				}
			}
		}
		
		Collections.sort(itensPos);
		
		for(ItemMapa p:itensPos){
			retorno = retorno +  " " + p.toString() + " |";
		}
		
		
		return retorno ;
	}
	
	public String getLinhaAcertos(Linha linha){
		
		ArrayList<ItemMapa> itensLinha = new ArrayList<ItemMapa>();
		String retorno = "|";
		
		for(ItemMapa i : getItens()){
			if (i.itemPertenceLinha(linha)){
				itensLinha.add(i);
			}
		}
		
		Collections.sort(itensLinha);
		
		for(ItemMapa i:itensLinha){
			retorno = retorno +  " " +   i.toString() + " |";
		}
		
		return retorno ;
	}
	
	public void imprimirMapa(){
		
				System.out.println("     1     2     3     4     5     6     7     8     9    10");
				System.out.println("  ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐");
		for(Linha l: Linha.values()){
			System.out.println(l.getLetra() + " "+ this.getLinha(l));
			if(l.getNumero() != 10){
				System.out.println("  ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤");
			}
		}
				System.out.println("  └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘");
	}
	
	public void imprimirMapaPontosAcertos(){
		
				System.out.println("     1     2     3     4     5     6     7     8     9    10");
				System.out.println("  ┌─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┬─────┐");
		for(Linha l: Linha.values()){
			System.out.println(l.getLetra() + " "+ this.getLinhaAcertos(l));
			if(l.getNumero() != 10){
				System.out.println("  ├─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┼─────┤");
			}
		}
				System.out.println("  └─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┴─────┘");
	}
	
}
