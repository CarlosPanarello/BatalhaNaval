package br.com.batalhanaval;

public enum Mensagens {
	
	NAVIO_ADICIONADO("Navio incluido com sucesso!",1),
	NAVIO_POSICAO_INVALIDA("Navio não pode ser adicionado nessa posição",2),
	TIRO_NA_AGUA("Você errou.",3),
	TIRO_ACERTOU("Você acertou.",4),
	NAVIO_POSICAO_OCUPADA("Já existe um navio nessa posição!",5),
	PONTO_JA_ATINGIDA("Você já atingiu essa posição",6),
	PORTA_AVIAO_ATINGIDO("Você acertou um porta avião.",7),
	NAVIO_1_CANO_ACERTOU("Você acertou um navio de 1 cano.",8),
	NAVIO_2_CANO_ACERTOU("Você acertou um navio de 2 canos.",9),
	NAVIO_3_CANO_ACERTOU("Você acertou um navio de 3 canos.",10),
	NAVIO_4_CANO_ACERTOU("Você acertou um navio de 4 canos.",11),
	PORTA_AVIAO_AFUNDOU("Você afundou um porta avião.",12),
	NAVIO_1_CANO_AFUNDOU("Você afundou um navio de 1 cano.",13),
	NAVIO_2_CANO_AFUNDOU("Você afundou um navio de 2 canos.",14),
	NAVIO_3_CANO_AFUNDOU("Você afundou um navio de 3 canos.",15),
	NAVIO_4_CANO_AFUNDOU("Você afundou um navio de 4 canos.",16);
	
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
