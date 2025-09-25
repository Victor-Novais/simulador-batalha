public class Tatu extends Criatura {

	public Tatu() {
		super("Tatu", 100, 60, 70, 1, "Terra");
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Rolamento defensivo: Dano baixo + aumenta própria defesa!");
	}

}
