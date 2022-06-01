package br.com.entra21.javaavancado.principal.aula01.enums;

public enum PersonagemJogo {

	BARBARO(1000, "Muito HP"), // Barbaro
	ANAO(100, "Ferreiro"), // An�o
	DRUIDA(50, "Suporte"), // Druida
	SACERDOTE(10, "Curar e correr"), // Sacerdote
	MAGO(20, "Faz altas magias");

	private final int HP;
	private final String DESCRICAO;

	private PersonagemJogo(int hp, String descricao) {
		this.HP = hp;
		this.DESCRICAO = descricao;

	}

	public int getHP() {
		return HP;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}
	public String getDetails() {
		
		return "Veja a descri��o completa do "+this.name()+ " sua vida � "+HP + " e a sua habilidade principal � "+DESCRICAO;
	}
	
	

}
