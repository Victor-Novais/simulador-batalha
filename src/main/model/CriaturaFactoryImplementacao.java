package main.model;
public class CriaturaFactoryImplementacao implements CriaturaFactory {

	@Override
	public Criatura criaturaFactory(int tipoCriatura) {
		switch(tipoCriatura) {
			case CriaturaFactory.TUBARAO:
				return new Tubarao();
			case CriaturaFactory.GOLFINHO:
				return new Golfinho();
			case CriaturaFactory.DRAGAO_DE_KOMODO:
				return new DragaoKomodo();
			case CriaturaFactory.MACACO_UACARI:
				return new MacacoUacari();
			case CriaturaFactory.TATU:
				return new Tatu();
			case CriaturaFactory.COBRA_MAMBA:
				return new CobraMamba();
			case CriaturaFactory.AGUIA:
				return new Aguia();
			case CriaturaFactory.PITOHUI:
				return new Pitohui();
			case CriaturaFactory.CORUJA:
				return new Coruja();
			case CriaturaFactory.CISNE:
				return new Cisne();
			case CriaturaFactory.PEIXE_DIABO_NEGRO:
				return new Peixe();
			case CriaturaFactory.CORVO:
				return new Corvo();
		}
		return null;
	}

}
