public class HabilidadePassiva implements Habilidade {

    private String nome;
    private String descricao;

    public HabilidadePassiva(String nome, String descricao) {
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
        System.out.println(atacante.getNome() + " possui a habilidade passiva: " + nome);
    }
}