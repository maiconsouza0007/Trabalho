package univas.edu.br;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MundoVirtual mundo = new MundoVirtual();

        Personagem jogador1 = new Personagem("Aragorn", 10);
        Personagem jogador2 = new Personagem("Gandalf", 15);

        Habilidade habilidade1 = new Habilidade("Espada Flamejante", "Ataque com espada mágica", 30);
        Habilidade habilidade2 = new Habilidade("Bola de Fogo", "Lança uma bola de fogo", 40);

        Item armadura = new Item("Armadura de Aço", "Protege contra ataques físicos", "Armadura");
        Item pocao = new Item("Poção de Cura", "Cura 50 pontos de vida", "Poção");

        jogador1.usarHabilidade(habilidade1);
        jogador1.usarItem(pocao);
        jogador1.caminhar(10.0, 20.0);

        jogador2.usarHabilidade(habilidade2);
        jogador2.usarItem(armadura);
        jogador2.caminhar(5.0, 15.0);

        mundo.adicionarPersonagem(jogador1);
        mundo.adicionarPersonagem(jogador2);

        Inimigo orc = new Inimigo("Orc", 5);
        Inimigo dragao = new Inimigo("Dragão", 20);

        orc.atacar(jogador1);
        dragao.atacar(jogador2);

        mundo.adicionarInimigo(orc);
        mundo.adicionarInimigo(dragao);

        List<Item> recompensaMissao = new ArrayList<>();
        recompensaMissao.add(armadura);
        recompensaMissao.add(pocao);

        Missao missao1 = new Missao("Derrotar Orcs", "Derrote 3 orcs", recompensaMissao, "Derrotar 3 orcs");

        missao1.iniciar(jogador1);
        missao1.completar(jogador1);

        mundo.adicionarMissao(missao1);
    }
}
