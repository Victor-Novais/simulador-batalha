package main.model;
import java.util.List;
public abstract class Criatura {
	protected String nome;
	protected int vida;
	protected int ataque;
	protected int defesa;
	protected int velocidade;
	protected String elemento;
	protected int efeitoStatus;
    protected List<HabilidadeAtiva> habilidades;
    public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, String elemento, List<HabilidadeAtiva> habilidades) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.elemento = elemento;
        this.efeitoStatus = -1;
        this.habilidades = habilidades;
    }

	public String getNome() {
		return nome;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public String getElemento() {
		return elemento;
	}

	public String getEfeitoStatus(){
		switch (efeitoStatus) {
			case EfeitoStatus.QUEIMAR:
				return "Queimado";
			case EfeitoStatus.ENVENENAR:
				return "Envenenado";
			case EfeitoStatus.AMALDICOAR:
				return "Amaldiçoado";
			case EfeitoStatus.CONGELAR:
				return "Congelado";
			case EfeitoStatus.ATORDOAR:
				return "Atordoado";
			default:
				return "Nenhum efeito aplicado";
		}
	}

	public void aplicarEfeito(int efeito) {
        this.efeitoStatus = efeito;
        System.out.println(nome + " agora está: " + getEfeitoStatus());
    }

    public void limparEfeito() {
        this.efeitoStatus = -1;
        System.out.println(nome + " foi curado de todos os efeitos.");
    }

    public List<HabilidadeAtiva> getHabilidades() {
        return habilidades;
    }

    public void usarHabilidade(int index, Criatura alvo) {
        if(index >= 0 && index < habilidades.size()) {
            habilidades.get(index).executar(this, alvo);
        } else {
            System.out.println("Habilidade inválida!");
        }
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public boolean estaViva() {
        return this.vida > 0;
    }

    public abstract void habilidadeEspecial();
}



