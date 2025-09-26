public class Peixe extends Criatura {

	public Peixe() {
		super("Peixe-diabo negro", 100, 90, 10, 1, TipoElemental.TREVAS);
	}

    @Override
    public void habilidadeEspecial() {
        System.out.println("Mordida Sombria → Dano alto + chance de amaldiçoar!");
    }

}
