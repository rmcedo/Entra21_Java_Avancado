package br.com.entra21.javaavancado.principal.aula01.enums;

public enum PersonagemJogo {

	BARBARO(1000, "Muito HP"), // Barbaro // [0]
	ANAO(100, "Ferreiro"), // An�o // [1]
	DRUIDA(50, "Suporte"), // Druida // [2]
	SACERDOTE(10, "Curar e correr"), // Sacerdote // [3]
	MAGO(20, "Faz altas magias"); // [4]

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
