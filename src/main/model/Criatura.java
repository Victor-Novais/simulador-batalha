public abstract class Criatura {
	protected String nome;
	protected int vida;
	protected int ataque;
	protected int defesa;
	protected int velocidade;
	protected String elemento;

	public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, String elemento) {
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.elemento = elemento;
	}

	public String getNome() {
		return nome;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public String getElemento() {
		return elemento;
	}

	public abstract void habilidadeEspecial();
}
