package br.com.batalhanaval.mapa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import br.com.batalhanaval.Mensagens;
import br.com.batalhanaval.navios.Navio;
import br.com.batalhanaval.navios.Navio1Cano;
import br.com.batalhanaval.navios.Navio2Canos;
import br.com.batalhanaval.navios.Navio3Canos;
import br.com.batalhanaval.navios.Navio4Canos;
import br.com.batalhanaval.navios.PortaAviao;

public class Mapa {
		
	private int qtdLinha;
	private int qtdColuna;
	
	private HashSet<Item> itens;
	private ArrayList<Navio> naviosMapa;
	
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
		naviosMapa = new ArrayList<Navio>();
	}
	
	private void popularMapa(){
		itens = new HashSet<Item>();
		
		//linha
		for(Linha linha: Linha.values()){
			
			if(linha.getNumero() <= qtdLinha ){
				//coluna
				for(int icoluna = 1; icoluna <= qtdColuna; icoluna++){
					itens.add(new Item(linha, icoluna, false,TipoItem.Agua,0));
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
		naviosMapa.add(navio);
		return Mensagens.NAVIO_ADICIONADO;
	}
	
	
	public Mensagens addTiro(Item posicao){
		for(Item p : itens){
			if(p.equals(posicao)){
				
				if(p.isPosicaoAtingida()){
					return Mensagens.PONTO_JA_ATINGIDA;
				}
				
				p.setPosicaoAtingida(true);
				if( p.isPosicaoOcupada()){
					
					Mensagens msgAfundou = verificaSeNavioAfundou(posicao) ;
					
					if(msgAfundou != null){
						return msgAfundou;
					}
					
					switch (p.getTipo()) {
					case PortaAviao:
						return Mensagens.PORTA_AVIAO_ATINGIDO;
					case Navio4:
						return Mensagens.NAVIO_4_CANO_ACERTOU;
					case Navio3:
						return Mensagens.NAVIO_3_CANO_ACERTOU;
					case Navio2:
						return Mensagens.NAVIO_2_CANO_ACERTOU;
					case Navio1:
						return Mensagens.NAVIO_1_CANO_ACERTOU;
					default:
						break;
					}
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
	
	public ArrayList<Navio> getNaviosMapa() {
		return naviosMapa;
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
	
	private Mensagens verificaSeNavioAfundou(Item posicao){
		for(Navio n : naviosMapa){
			
			if(n.getPosicoesOcupadas().contains(posicao)){
				if (n.navioAfundou()){
					if (n instanceof PortaAviao) {
						return Mensagens.PORTA_AVIAO_AFUNDOU;
					}
					
					if (n instanceof Navio4Canos) {
						return Mensagens.NAVIO_4_CANO_AFUNDOU;
					}   
					
					if (n instanceof Navio3Canos) {
						return Mensagens.NAVIO_3_CANO_AFUNDOU;
					}  
					
					if (n instanceof Navio2Canos) {
						return Mensagens.NAVIO_2_CANO_AFUNDOU;
					}  
					
					if (n instanceof Navio1Cano) {
						return Mensagens.NAVIO_1_CANO_AFUNDOU;
					}  
				}
			}
		}
		return null;
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
