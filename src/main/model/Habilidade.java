public interface Habilidade {
	
	String getNome();
	String getDescricao();

	void executar(Criatura atacante, Criatura alvo);
}
