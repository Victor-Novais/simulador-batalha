public class HabilidadeAtiva implements Habilidade {
	private String nome;
	private String descricao;

	public HabilidadeAtiva(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public void executar(Criatura atacante, Criatura alvo) {
		System.out.println(atacante.getNome() + " usou " + nome + " em " + alvo.getNome());
	}
}