
public class Golfinho extends Criatura {

	public Golfinho() {
		super("Golfinho", 100, 60, 30, 4, TipoElemental.AGUA);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Onda sonora: Dano + chance de atordoar por 1 turno!");
	}

}
