public class Equipamento extends Item {
    private int bonusVida;
    private int bonusAtaque;
    private int bonusDefesa;
    private int bonusVelocidade;

    public Equipamento(String nome, String descricao, int bonusAtaque, int bonusDefesa, int bonusVelocidade, int bonusVida) {
        super(nome, descricao);
        this.bonusAtaque = bonusAtaque;
        this.bonusDefesa = bonusDefesa;
        this.bonusVelocidade = bonusVelocidade;
        this.bonusVida = bonusVida;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    public int getBonusDefesa() {
        return bonusDefesa;
    }

    public int getBonusVelocidade() {
        return bonusVelocidade;
    }

    public int getBonusVida() {
        return bonusVida;
    }


    @Override
    public void usar(Criatura alvo) {
        System.out.println(alvo.getNome() + " equipou " + nome + "!");
        // Aqui você pode adicionar lógica para aumentar os atributos da criatura
    }
}