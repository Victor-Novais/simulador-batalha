
public class Aguia extends Criatura {

	public Aguia() {
		super("Aguia", 100, 70, 40, 5, TipoElemental.AR);
	}

    @Override
    public void habilidadeEspecial() {
        System.out.println("Garras velozes: Dano normal + chance de envenenar!");
    }


}
