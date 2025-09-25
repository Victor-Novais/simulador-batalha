
public class Corvo extends Criatura {

    public Corvo( ) {
		super("Corvo", 100, 65, 30, 4, "Trevas");
	}

	@Override
    public void habilidadeEspecial() {
        System.out.println("Bicada Sombria → Dano físico + chance de amaldiçoar!");
    }


}
