
public class DragaoKomodo extends Criatura {

	public DragaoKomodo() {
		super("Dragão-De-Komodo", 100, 86, 35, 2, TipoElemental.FOGO);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("Mordida Venenosa: Dano médico + chance de envenenar!");
	}

}
