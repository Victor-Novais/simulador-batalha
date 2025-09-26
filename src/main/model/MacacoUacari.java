
public class MacacoUacari extends Criatura {

	public MacacoUacari() {
		super("Macaco-Uacari", 100, 60, 70, 3, TipoElemental.FOGO);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Soco Flamejante: Dano médio + chance de envenenar!");
	}

}
