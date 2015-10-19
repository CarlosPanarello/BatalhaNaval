package br.com.batalhanaval.mapa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.navios.Navio;

public class Mapa {
		
	private int qtdLinha;
	private int qtdColuna;
	
	private HashSet<Item> itens;
	
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
		itens = new HashSet<Item>();
		
		//linha
		for(Linha linha: Linha.values()){
			
			if(linha.getNumero() <= qtdLinha ){
				//coluna
				for(int icoluna = 1; icoluna <= qtdColuna; icoluna++){
					itens.add(new Item(linha, icoluna, false,TipoItem.Agua));
				}				
			}
		}
	}
	
	public Mensagens addNavioNoMapa(Navio navio){
		
		for(Item pMapa : itens){
			
			for(Item pNavio : navio.getPosicoesOcupadas()){
				if(!itens.contains(pNavio)){
					return Mensagens.NAVIO_POSICAO_INVALIDA;
				}
				
				if(pNavio.equals(pMapa) && pMapa.isPosicaoOcupada()){
					return Mensagens.NAVIO_POSICAO_OCUPADA;
				}
			}
		}
		
		itens.removeAll(navio.getPosicoesOcupadas());
		itens.addAll(navio.getPosicoesOcupadas());
		
		return Mensagens.NAVIO_ADICIONADO;
	}
	
	
	public Mensagens addTiro(Item posicao){
		for(Item p : itens){
			if(p.equals(posicao)){
				p.setPosicaoAtingida(true);
				if( p.isPosicaoOcupada()){
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

	public HashSet<Item> getItens() {
		return itens;
	}
	
	public String getLinha(Linha linha){
		
		ArrayList<Item> itensLinha = new ArrayList<Item>();
		String retorno = "|";
		
		for(Item p : getItens()){
			if (p.getLinha().equals(linha)){
				itensLinha.add(p);
			}
		}
		
		Collections.sort(itensLinha);
		
		for(Item p:itensLinha){
			retorno = retorno +  " " + p.toString() + " |";
		}
		
		
		return retorno ;
	}
	
	public String getLinhaAcertos(Linha linha){
		
		ArrayList<Item> itensLinha = new ArrayList<Item>();
		String retorno = "|";
		
		for(Item p : getItens()){
			if (p.getLinha().equals(linha)){
				itensLinha.add(p);
			}
		}
		
		Collections.sort(itensLinha);
		
		for(Item p:itensLinha){
			retorno = retorno +  " " +  (p.isPosicaoAtingida() ?  p.toString()   : " " +TipoItem.Agua.getDesc()+" "  ) + " |";
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
