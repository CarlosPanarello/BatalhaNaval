package br.com.batalhanaval;

public enum Mensagens {
	
	NAVIO_ADICIONADO("Navio incluido com sucesso!",1),
	NAVIO_POSICAO_INVALIDA("Navio não pode ser adicionado nessa posição",2),
	TIRO_NA_AGUA("Você errou.",3),
	TIRO_ACERTOU("Você acertou.",4);
	
	private int codigoMensagem;
	private String msg;
	
	Mensagens(String msg, int codigo){
		this.msg = msg;
		this.codigoMensagem = codigo;
	}

	public int getCodigoMensagem() {
		return codigoMensagem;
	}

	public String getMsg() {
		return msg;
	}
}
