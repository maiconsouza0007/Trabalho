package univas.edu.br;
import java.util.ArrayList;
import java.util.List;

class Personagem {
    private final String nome;
    private int saude;
    public int energia;
    private List<Item> itens;

    public Personagem(String nome, int nivel) {
        this.nome = nome;
        this.saude = 100;
        this.energia = 100;
        List<Habilidade> habilidades = new ArrayList<>();
        this.itens = new ArrayList<>();
    }

    public void atacar(Inimigo inimigo) {
        System.out.println("Você atacou o inimigo " + inimigo.getNome());
        inimigo.pegarDano(15);
    }

    public void pegarItem(Item item) {
        System.out.println("Você pegou o item " + item.getNome());
        this.itens.add(item);
    }

    public void caminhar(double x, double y) {
        System.out.println("Você foi para o ponto (" + x + ", " + y + ")");
    }

    public void usarHabilidade(Habilidade habilidade) {
        System.out.println("A habilidade " + habilidade.getNome() + " foi ativada");
        this.energia -= habilidade.getCustoEnergia();
    }

    public void usarItem(Item item) {
        System.out.println("Você usou o item " + item.getNome());
    }

    public void pegarDano(int dano) {
        this.saude -= dano;
        System.out.println("Você recebeu " + dano + " pontos de dano. Saúde restante: " + this.saude);
    }

    public String getNome() {
        return nome;
    }

    public void pegarItem(List<Item> recompensa) {
    }
}

class Habilidade {
    private String nome;
    private String descricao;
    private int custoEnergia;

    public Habilidade(String nome, String descricao, int custoEnergia) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoEnergia = custoEnergia;
    }

    public void ativar(Personagem personagem) {
        System.out.println("A habilidade " + nome + " foi ativada");
        personagem.energia -= custoEnergia;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoEnergia() {
        return custoEnergia;
    }
}

class Missao {
    private String titulo;
    private String descricao;
    private List<Item> recompensa;
    private String objetivos;
    private boolean completada;

    public Missao(String titulo, String descricao, List<Item> recompensa, String objetivos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.recompensa = recompensa;
        this.objetivos = objetivos;
        this.completada = false;
    }

    public void iniciar(Personagem personagem) {
        System.out.println("A missão " + titulo + " foi iniciada por " + personagem.getNome());
    }

    public void completar(Personagem personagem) {
        System.out.println("A missão " + titulo + " foi completada");
        personagem.pegarItem(recompensa);
        this.completada = true;
    }
}

class Inimigo {
    private String nome;
    private int nivel;
    private int saude;
    private int energia;

    public Inimigo(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
        this.saude = 100;
        this.energia = 100;
    }

    public void atacar(Personagem personagem) {
        System.out.println("Você atacou o personagem " + personagem.getNome());
        personagem.pegarDano(20);
    }

    public void pegarDano(int dano) {
        this.saude -= dano;
    }

    public String getNome() {
        return nome;
    }
}

class Item {
    private String nome;
    private String descricao;
    private String tipo;

    public Item(String nome, String descricao, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public void usar(Personagem personagem) {
        System.out.println("Você usou o item " + nome);
    }

    public String getNome() {
        return nome;
    }
}

class MundoVirtual {
    private List<Personagem> personagens;
    private List<Missao> missoes;
    private List<Inimigo> inimigos;

    public MundoVirtual() {
        this.personagens = new ArrayList<>();
        this.missoes = new ArrayList<>();
        this.inimigos = new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem) {
        this.personagens.add(personagem);
    }

    public void adicionarMissao(Missao missao) {
        this.missoes.add(missao);
    }

    public void adicionarInimigo(Inimigo inimigo) {
        this.inimigos.add(inimigo);
    }
}

