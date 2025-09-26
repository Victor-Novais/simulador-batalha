public class Coruja extends Criatura {

	public Coruja() {
		super("Coruja das Neves", 100, 85, 20, 4, TipoElemental.LUZ);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Rajada de Gelo: Dano + chance de congelar!");
	}

}
