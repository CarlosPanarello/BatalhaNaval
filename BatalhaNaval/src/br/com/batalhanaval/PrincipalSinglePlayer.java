package br.com.batalhanaval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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

public class PrincipalSinglePlayer {
	
	
	public static void main(String[] args) {
		
		System.out.println("########################################################################################################");
		System.out.println("Aguarde enquanto a maquina define os navios no mapa");
		System.out.println("########################################################################################################");
		Mapa mapaJogadorMaquina = preencherMapaMaquina();
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		mapaJogadorMaquina.imprimirMapa();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		int rodadas =1 ;
		while(!jogoTerminou(rodadas)){
			
			mapaJogadorMaquina = realizarTiro(mapaJogadorMaquina);
			mapaJogadorMaquina = realizarTiro(mapaJogadorMaquina);
			mapaJogadorMaquina = realizarTiro(mapaJogadorMaquina);
			rodadas++;
			
			mapaJogadorMaquina.imprimirMapaPontosAcertos();
		}
		
		System.out.println("########################################################################################################");
		System.out.println("O jogo terminou, o seu aproveitamento foi de " + aproveitamento(mapaJogadorMaquina,25) + "%");
		System.out.println("########################################################################################################");
		System.out.println("O mapa do jogo aberto: ");
		
		mapaJogadorMaquina.imprimirMapa();
		System.out.println("########################################################################################################");
		
	}
	
	public static Integer aproveitamento(Mapa m, int qtdItens){
		
		Integer qtdAcertos = 0;
		
		for(Item i: m.getItens()){
			if(i.isPosicaoOcupada() && i.isPosicaoAtingida()){
				qtdAcertos++;
			}
		}
		
		
		if(qtdAcertos == 0){
			return 0;
		}
		
		return  (qtdItens/qtdAcertos) * 100;
	}
	
	public static boolean jogoTerminou(int rodadas){
		return rodadas > 10;
	}

	public static Mapa realizarTiro(Mapa m){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Escolha a posição  do tiro no formato A C");
		System.out.println("	onde A - Letra da linha de A a J");
		System.out.println("	onde C - Numero da Coluna 1 a 10");
		
		String comandoEntrada = "";
		
        try {
        	comandoEntrada = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return realizarTiro(m);
		}
		
		String comando =  validarComando(comandoEntrada);
		
		if(comando.isEmpty()){
			return realizarTiro(m);
		}
		
		System.out.println(m.addTiro(new Item(obterLinha(comando),obterColuna(comando))).getMsg());
		
		return m;
	}

	public static Mapa preencherMapaMaquina(){
		Mapa mapa = new Mapa();
		
		boolean executar = true;
		int cont;
		
		while(executar){
			executar = !adicionarNavio(mapa,TipoItem.PortaAviao);
		}
		
		executar = true;
		while(executar){
			executar = !adicionarNavio(mapa,TipoItem.Navio4);
		}
		
		cont = 1;
		while(cont <= 2){
			if(adicionarNavio(mapa,TipoItem.Navio3)){
				cont++;
			}
		}
		
		cont = 1;
		while( cont <= 3){
			if(adicionarNavio(mapa,TipoItem.Navio2)){
				cont++;
			}
		}
		
		cont = 1;
		while(cont <= 4){
			if(adicionarNavio(mapa,TipoItem.Navio1)){
				cont++;
			}
		}
		
		return mapa;
	}
	
	public static boolean adicionarNavio(Mapa m,TipoItem tipo){
		
		Linha linhaEntrada;
		int conlunaEntrada;
		Rotacao rotacaoEntrada;

		linhaEntrada = obterLinha();
		conlunaEntrada = obterColuna();
		rotacaoEntrada = obterRotacao();
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
		
		if(msg.equals( Mensagens.NAVIO_ADICIONADO)){
			return true;
		} else {
			return false;
		}
	}
	
	public static String validarComando(String comando){
		String[] comandos = comando.trim().split("\\s+");
		String posicao = "";
		
		if( comandos.length >=2 ){
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
					posicao = posicao + " " +comandos[1];
				}
				
			} catch (Exception e) {
				System.out.println("Informe um numero para a coluna entre 1 e 10");
				return "";
			}
			
			
		} else {
			System.out.println("Informe os dois parametros.");
			return "";
		}
		
		return posicao;
	}
	
	public static Linha obterLinha(){
		Random r = new Random();
		
		switch (r.nextInt(10) +1) {
		case 1:
			return Linha.A;
		case 2:
			return Linha.B;
		case 3:
			return Linha.C;
		case 4:
			return Linha.D;
		case 5:
			return Linha.E;
		case 6:
			return Linha.F;
		case 7:
			return Linha.G;
		case 8:
			return Linha.H;
		case 9:
			return Linha.I;
		case 10:
			return Linha.J;
		default:
			return null;
		}
	}
	
	public static int obterColuna (){
		Random r = new Random();
		return r.nextInt(10) +1;
	}
	
	public static Rotacao obterRotacao(){
		Random r = new Random();
		
		switch (r.nextInt(4) +1) {
		case 1:
			return Rotacao.Baixo;
		case 2:
			return Rotacao.Cima;
		case 3:
			return Rotacao.Direita;
		case 4:
			return Rotacao.Esquerda;
		default:
			return null;
		}
	}
	
	public static Linha obterLinha(String comando){
		String comandos[] = comando.trim().split("\\s+");
		
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
		String comandos[] = comando.trim().split("\\s+");
		int retorno =0 ;
		
		try {
			retorno = new Integer(comandos[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}