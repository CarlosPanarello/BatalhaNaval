package br.com.batalhanaval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.batalhanaval.mapa.Item;
import br.com.batalhanaval.mapa.Linha;
import br.com.batalhanaval.mapa.Mapa;
import br.com.batalhanaval.mapa.Rotacao;
import br.com.batalhanaval.mapa.TipoItem;
import br.com.batalhanaval.navios.Navio1Cano;
import br.com.batalhanaval.navios.Navio2Canos;
import br.com.batalhanaval.navios.Navio3Canos;
import br.com.batalhanaval.navios.Navio4Canos;
import br.com.batalhanaval.navios.PortaAviao;

public class Principal {

	public static void main(String[] args) {
		System.out.println("########################################################################################################");
		System.out.println("Jogador 1 informe os navios no seu mapa");
		System.out.println("########################################################################################################");
		Mapa mapaJogador1 = preencherMapaJogador();
		
		
		System.out.println("########################################################################################################");
		System.out.println("Jogador 2 informe os navios no seu mapa");
		System.out.println("########################################################################################################");
		Mapa mapaJogador2 = preencherMapaJogador();
		
		//imprimirMapa(jogador1);
		//System.out.println(mapaJogador1.addTiro(new Item(Linha.E, 7)).getMsg());
		//System.out.println(mapaJogador1.addTiro(new Item(Linha.E, 9)).getMsg());

		mapaJogador1.imprimirMapa();
		mapaJogador2.imprimirMapa();
		
	}
	
	public static Mapa preencherMapaJogador(){
		Mapa mapa = new Mapa();
		
		boolean executar = true;
		int cont;
		
		System.out.println("Você devará escolher a posição de 1 porta aviao, 1 navio de 4 canos, 2 navios de 3 canos, 3 navios de 2 canos e 4 navios de 1 cano.");
		
		while(executar){
			System.out.println("Adicione um porta avião:");
			executar = !adicionarNavio(mapa,TipoItem.PortaAviao);
		}
		
		executar = true;
		while(executar){
			System.out.println("Adicione um navio de 4 canos:");
			executar = !adicionarNavio(mapa,TipoItem.Navio4);
		}
		
		cont = 1;
		while(cont <= 2){
			System.out.println("Adicione o "+cont +"º navio de 3 canos:");
			if(adicionarNavio(mapa,TipoItem.Navio3)){
				cont++;
			}
		}
		
		cont = 1;
		while( cont <= 3){
			System.out.println("Adicione o "+cont +"º navio de 2 canos:");
			if(adicionarNavio(mapa,TipoItem.Navio2)){
				cont++;
			}
		}
		
		cont = 1;
		while(cont <= 4){
			System.out.println("Adicione o "+cont +"º navio de 1 cano:");
			if(adicionarNavio(mapa,TipoItem.Navio1)){
				cont++;
			}
		}
		
		return mapa;
	}
	
	public static boolean adicionarNavio(Mapa m,TipoItem tipo){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Escolha a posição  do "+ tipo.getNomeNavio() +" no formato A C R ");
		System.out.println("	onde A - Letra da linha de A a J");
		System.out.println("	onde C - Numero da Coluna 1 a 10");
		
		if(TipoItem.PortaAviao.equals(tipo)){
			System.out.println("	onde R - Rotação do porta avião ├ D ou H, ┤ E, ┴ C, ┬ B ou V, onde o ponto informado e a interseção das retas.");
		} else	if(!TipoItem.Agua.equals(tipo) ){
			System.out.println("	onde R - Rotação do Navio ---- H, ou | V, onde o ponto informado e o ponto mais a esquerda ou o mais baixo");
		}

		String comandoEntrada = "";
		
        try {
        	comandoEntrada = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		String comando =  validarComando(comandoEntrada);
		
		Linha linhaEntrada;
		int conlunaEntrada;
		Rotacao rotacaoEntrada;
		
		if(comando.length() > 0){
			linhaEntrada = obterLinha(comando);
			conlunaEntrada = obterColuna(comando);
			rotacaoEntrada = obterRotacao(comando);
			Mensagens msg;
			
			switch (tipo) {
			case PortaAviao:
				msg = m.addNavioNoMapa(new PortaAviao(new Item(linhaEntrada, conlunaEntrada), rotacaoEntrada));
				break;
			case Navio1:
				msg = m.addNavioNoMapa(new Navio1Cano(new Item(linhaEntrada, conlunaEntrada), rotacaoEntrada));
				break;
			case Navio2:
				msg = m.addNavioNoMapa(new Navio2Canos(new Item(linhaEntrada, conlunaEntrada), rotacaoEntrada));
				break;
			case Navio3:
				msg = m.addNavioNoMapa(new Navio3Canos(new Item(linhaEntrada, conlunaEntrada), rotacaoEntrada));
				break;
			case Navio4:
				msg = m.addNavioNoMapa(new Navio4Canos(new Item(linhaEntrada, conlunaEntrada), rotacaoEntrada));
				break;
			default:
				msg = Mensagens.NAVIO_POSICAO_INVALIDA;
				break;
			}
			
			System.out.println(msg.getMsg());
		
			if(msg.equals( Mensagens.NAVIO_ADICIONADO)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	

	public static String validarComando(String comando){
		String[] comandos = comando.split("\\s+");
		String posicao = "";
		
		if( comandos.length >=3 ){
			if(obterLinha(comando) != null ){
				posicao =  comandos[0].substring(0, 1);
			} else {
				System.out.println("Informe uma letra da linha entre A e J.");
				return "";
			}
			
			try {
				int col = new Integer(comandos[1]);
				if(col < 1 || col > 10){
					System.out.println("Informe uma coluna entre 1 e 10");
					return "";
				} else {
					posicao = posicao + " " +comandos[1].substring(0, 1);
				}
				
			} catch (Exception e) {
				System.out.println("Informe um numero para a coluna entre 1 e 10");
				return "";
			}
			
			if(obterRotacao(comando) != null){
				posicao = posicao + " " + comandos[2].substring(0, 1);
			} else {
				System.out.println("Informe uma rotação nos valores D, E, C ou B.");
				return "";
			}
			
		} else {
			System.out.println("Informe os três parametros.");
			return "";
		}
		
		return posicao;
	}
	
	
	public static Linha obterLinha(String comando){
		String comandos[] = comando.split("\\s+");
		
		switch (comandos[0].substring(0, 1)) {
		case "A":
		case "a":
			return Linha.A;
		case "B":
		case "b":
			return Linha.B;
		case "C":
		case "c":
			return Linha.C;
		case "D":
		case "d":
			return Linha.D;
		case "E":
		case "e":
			return Linha.E;
		case "F":
		case "f":
			return Linha.F;
		case "G":
		case "g":
			return Linha.G;
		case "H":
		case "h":
			return Linha.H;
		case "I":
		case "i":
			return Linha.I;
		case "J":
		case "j":
			return Linha.J;
		default:
			return null;
		}
	}
	
	public static int obterColuna (String comando){
		String comandos[] = comando.split("\\s+");
		int retorno =0 ;
		
		try {
			retorno = new Integer(comandos[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static Rotacao obterRotacao(String comando){
		String comandos[] = comando.split("\\s+");
		
		switch (comandos[2].substring(0, 1)) {
		case "B":
		case "b":
		case "V":
		case "v":
			return Rotacao.Baixo;
		case "C":
		case "c":
			return Rotacao.Cima;
		case "D":
		case "d":
			return Rotacao.Direita;
		case "E":
		case "e":
		case "H":
		case "h":
			return Rotacao.Esquerda;
		default:
			return null;
		}
	}

}
