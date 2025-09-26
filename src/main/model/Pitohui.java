public class Pitohui extends Criatura {

	public Pitohui() {
		super("Passaro-Pitohui-Encapuzado", 100, 73, 32, 5, TipoElemental.AR);
	}

	@Override
	public void habilidadeEspecial() {
		System.out.println("BIcada venenosa: Dano físico + envenena!");
	}

}
