package br.com.batalhanaval;

public enum Linha {
	A("A",1),
	B("B",2),
	C("C",3),
	D("D",4),
	E("E",5),
	F("F",6),
	G("G",7),
	H("H",8),
	I("I",9),
	J("J",10);
	
	private String letra;
	private int numero;
	
	Linha(String letra, int numero){
		this.letra= letra;
		this.numero=numero;
	}

	public String getLetra() {
		return letra;
	}

	public int getNumero() {
		return numero;
	}
}
