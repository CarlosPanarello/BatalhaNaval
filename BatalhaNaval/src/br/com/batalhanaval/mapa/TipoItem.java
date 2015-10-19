package br.com.batalhanaval.mapa;

public enum TipoItem {
	PortaAviao("P","Porta Avião"),
	Navio("N","Navio"),
	Navio1("N","Navio de 1 Cano"), 
	Navio2("N","Navio de 2 Canos"), 
	Navio3("N","Navio de 3 Canos"), 
	Navio4("N","Navio de 4 Canos"), 
	Agua("~","Agua");
	
	private String desc;
	private String nome;
	
	TipoItem(String desc,String nome){
		this.desc = desc;
		this.nome = nome;
	}

	public String getDesc() {
		return desc;
	}

	public String getNomeNavio() {
		return nome;
	}
}
