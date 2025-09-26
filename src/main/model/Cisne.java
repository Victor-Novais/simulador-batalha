

public class Cisne extends Criatura {

	public Cisne() {
		super("Cisne", 100, 30, 20, 2, TipoElemental.LUZ);
	}

    @Override
    public void habilidadeEspecial() {
        System.out.println("Asas protetoras: Cura 20 HP de um aliado!");
    }

}
