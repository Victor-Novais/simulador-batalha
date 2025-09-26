

public class CobraMamba extends Criatura {

	public CobraMamba() {
		super("Cobra Mamba Negra", 100, 84, 70, 4, TipoElemental.TERRA);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Picada Mortal: Dano físico + envenena!");
	}

}
