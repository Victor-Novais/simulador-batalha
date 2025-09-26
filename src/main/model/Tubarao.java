public class Tubarao extends Criatura {

	public Tubarao() {
		super("Tubarão", 100, 85, 45, 3, TipoElemental.AGUA);
	}
	@Override
	public void habilidadeEspecial() {
		System.out.println("Mordida Brutal: Dano físico alto!");
	}

}
