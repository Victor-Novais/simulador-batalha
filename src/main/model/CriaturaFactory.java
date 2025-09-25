public interface CriaturaFactory {
	int TUBARAO = 0;
    int GOLFINHO = 1;
    int DRAGAO_DE_KOMODO = 2;
    int MACACO_UACARI = 3;
    int TATU = 4;
    int COBRA_MAMBA = 5;
    int AGUIA = 6;
    int PITOHUI = 7;
    int CORUJA = 8;
    int CISNE = 9;
    int PEIXE_DIABO_NEGRO = 10;
    int CORVO = 11;

	Criatura criaturaFactory(int tipoCriatura);

}