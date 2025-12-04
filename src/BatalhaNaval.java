import java.util.Random;
import java.util.Scanner;

public class BatalhaNaval {
    public static Scanner teclado;
    // ============================================================
    // CONSTANTES DO JOGO
    // ============================================================
    final static int TAM_MAT = 10;
    final static int MAX_TIROS = 20;
    // IDs dos navios
    final static int LIVRE = 0;
    final static int PORTA_AVIOES = 1;
    final static int FRAGATA = 2;
    final static int SUBMARINO = 3;
    // Resultado do jogo
    final static int EM_ANDAMENTO = 0;
    final static int VITORIA = 1;
    final static int DERROTA = 2;
    // Quantidade de navios (conforme PDF)
    final static int NUM_PORTA_AVIOES = 1;
    final static int NUM_FRAGATAS = 5;
    final static int NUM_SUBMARINOS = 5;
    // Pontuação
    final static int PONTOS_PORTA_AVIOES = 100;
    final static int PONTOS_FRAGATA = 20;
    final static int PONTOS_SUBMARINO = 50;

    // ============================================================
    // VARIÁVEIS DO JOGO
    // ============================================================
    static int[][] zonaDeGuerra = new int[TAM_MAT][TAM_MAT];
    static int contadorTiros = 0;
    static int pontuacao = 0;

    // Ativa ou desativa visualização dos navios
    static boolean modoDebug = false;

    // ============================================================
    // FUNÇÕES AUXILIARES
    // ============================================================
    // Entrada segura
    static int lerInteiro(String msg) {
        while (true) {
            System.out.print(msg);
            String entrada = teclado.next();
            if (entrada.matches("\\d+"))
                return Integer.parseInt(entrada);
            System.out.println("Entrada inválida! Digite um número.");
        }
    }

    // Validação de posições
    static boolean posicaoValida(int x, int y) {
        return x >= 0 && x < TAM_MAT && y >= 0 && y < TAM_MAT;
    }

    static boolean posicaoJaAlvejada(int x, int y) {
        return zonaDeGuerra[x][y] >= 10;
    }

    static boolean todosNaviosAtingidos() {
        for (int i = 0; i < TAM_MAT; i++)
            for (int j = 0; j < TAM_MAT; j++)
                if (zonaDeGuerra[i][j] == PORTA_AVIOES ||
                        zonaDeGuerra[i][j] == FRAGATA ||
                        zonaDeGuerra[i][j] == SUBMARINO)
                    return false;
        return true;
    }

    static void atualizarPontuacao(int id) {
        switch (id) {
            case PORTA_AVIOES:
                pontuacao += PONTOS_PORTA_AVIOES;
                break;
            case FRAGATA:
                pontuacao += PONTOS_FRAGATA;
                break;
            case SUBMARINO:
                pontuacao += PONTOS_SUBMARINO;
                break;
        }
    }
}
