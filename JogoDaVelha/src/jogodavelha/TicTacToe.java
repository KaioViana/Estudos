/*
  Classe TicTacToe que permite escrever um programa para reproduzir o jogo da velha.
  A classe contém um array bidimensional privado 3 por 3. Usa um tipo enum para
  representar o valor em cada célula do array. As constantes enum são nomeadas 
  X, O e EMPTY (para uma posição que não contém X ou 0). O construtor inicializa
  os elementos do tabuleiro para EMPTY. Permite dois jogadores humanos. 
 */

package jogodavelha;

/**
 *
 * @author Computador
 */
public class TicTacToe {

    static java.util.Scanner in = new java.util.Scanner(System.in);
    // Constantes enum
    private enum Status {
        O, X, EMPTY
    }

    private final Status[][] jogo = new Status[3][3];// Array jogo 

    private final Status jogador1 = Status.X;

    private final Status jogador2 = Status.O;
    // Inicializa o objeto com as posições de jogo Status.EMPTY
    public TicTacToe() {

        for (Status[] jogo1 : jogo) {
            for (int i = 0; i < jogo1.length; i++) {

                jogo1[i] = Status.EMPTY;

            }
        }
    }
    // Dá play no jogo
    public void playGame() {
        // Chama a repesentação do jogo da velha ainda sem jogadas
        tabuleiro();
        // Começa o jogo
        while (true) {
            // Pede a jogada do jogador 1
            System.out.println("\nJOGADOR 1: ");
            System.out.println("LINHA: ");
            int linha = Integer.parseInt(in.nextLine());
            System.out.println("\nCOLUNA: \n");
            int coluna = Integer.parseInt(in.nextLine());
            // Enquanto o espaço informado já estiver preenchido
            while (jogo[linha - 1][coluna - 1] != Status.EMPTY) {

                System.out.println("ESPAÇO PREENCHIDO!");

                System.out.println("\nLINHA: ");
                linha = Integer.parseInt(in.nextLine());
                System.out.println("\nCOLUNA: \n");
                coluna = Integer.parseInt(in.nextLine());

            }
            // Armazena a jogada na posição informada
            jogo[linha - 1][coluna - 1] = jogador1;
            // Chama a representação do tabuleiro novamente
            tabuleiro();
            // Verifica se o jogador 1 ganhou
            if(verifJogo() == jogador1){
                System.out.println("\nJOGADOR 1 VENCEU!");
                break;
                
            }
            // Verifica um possível empate
            if(verifJogo() == Status.EMPTY){
                System.out.println("\nEMPATE!");
                break;
                
            }
            // Pede a jogada do jogador 2
            System.out.println("\nJOGADOR 2: ");
            System.out.println("LINHA: ");
            linha = Integer.parseInt(in.nextLine());
            System.out.println("\nCOLUNA: \n");
            coluna = Integer.parseInt(in.nextLine());
            // Enquanto o espaço informado já estiver preenchido
            while (jogo[linha - 1][coluna - 1] != Status.EMPTY) {

                System.out.println("\nESPAÇO PREENCHIDO!");

                System.out.println("\nLINHA: ");
                linha = Integer.parseInt(in.nextLine());
                System.out.println("\nCOLUNA: \n");
                coluna = Integer.parseInt(in.nextLine());

            }
            // Armazena a jogada na posição informada
            jogo[linha - 1][coluna - 1] = jogador2;
            // Chama arepresentação do tabuleiro novamente
            tabuleiro();
            // Verifica se o jogador 2 ganhou
            if(verifJogo() == jogador2){
                System.out.println("\nJOGADOR 2 VENCEU!");
                break;
                
            }
            // Verifica um possível empate
            if(verifJogo() == Status.EMPTY){
                System.out.println("\nEMPATE!");
                break;
                
            }

        }
    }
    // Método tabuleiro(), Representação String do jogo
    public void tabuleiro() {
        // Matriz que representa o jogo da velha
        String[][] array = new String[3][3];

        array[0][0] = "_";
        array[0][1] = "|_|";
        array[0][2] = "_";
        array[1][0] = "_";
        array[1][1] = "|_|";
        array[1][2] = "_";
        array[2][0] = "";
        array[2][1] = "| |";
        array[2][2] = "";
        // Preenche o tabuleiro com as jogadas dos jogadores
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (jogo[i][j] == jogador1) {
                    array[i][j] = "X";
                }

                if (jogo[i][j] == jogador2) {
                    array[i][j] = "O";
                }

                if (jogo[0][1] == jogador1) {
                    array[0][1] = "|X|";
                }

                if (jogo[0][1] == jogador2) {
                    array[0][1] = "|O|";
                }

                if (jogo[1][1] == jogador1) {
                    array[1][1] = "|X|";
                }

                if (jogo[1][1] == jogador2) {
                    array[1][1] = "|O|";
                }

                if (jogo[2][1] == jogador1) {
                    array[2][1] = "|X|";
                }

                if (jogo[2][1] == jogador2) {
                    array[2][1] = "|O|";
                }
                // Printa o tabuleiro
                System.out.printf("%1s", array[i][j]);
            }

            System.out.println();
        }

    }
    // Método verifJogo(), verifica quem ganhou ou se houve um empate
    private Status verifJogo() {
        
        boolean empate = true;
        Status resultado = null;// Variável de retorno
        // Posíveis jogadas de sucesso do jogador 1
        if (((jogo[0][0] == jogador1 && jogo[0][1] == jogador1 && jogo[0][2] == jogador1)
                || (jogo[1][0] == jogador1 && jogo[1][1] == jogador1 && jogo[1][2] == jogador1)
                || (jogo[2][0] == jogador1 && jogo[2][1] == jogador1 && jogo[2][2] == jogador1)
                || (jogo[0][0] == jogador1 && jogo[1][0] == jogador1 && jogo[2][0] == jogador1)
                || (jogo[0][1] == jogador1 && jogo[1][1] == jogador1 && jogo[1][1] == jogador1)
                || (jogo[0][2] == jogador1 && jogo[1][2] == jogador1 && jogo[2][2] == jogador1)
                || (jogo[0][0] == jogador1 && jogo[1][1] == jogador1 && jogo[2][2] == jogador1)
                || (jogo[0][2] == jogador1 && jogo[1][1] == jogador1 && jogo[2][0] == jogador1))) {

            resultado = jogador1;

        }
        // Possíveis jogadas de sucesso do jogador 2
        if (((jogo[0][0] == jogador2 && jogo[0][1] == jogador2 && jogo[0][2] == jogador2)
                || (jogo[1][0] == jogador2 && jogo[1][1] == jogador2 && jogo[1][2] == jogador2)
                || (jogo[2][0] == jogador2 && jogo[2][1] == jogador2 && jogo[2][2] == jogador2)
                || (jogo[0][0] == jogador2 && jogo[1][0] == jogador2 && jogo[2][0] == jogador2)
                || (jogo[0][1] == jogador2 && jogo[1][1] == jogador2 && jogo[1][1] == jogador2)
                || (jogo[0][2] == jogador2 && jogo[1][2] == jogador2 && jogo[2][2] == jogador2)
                || (jogo[0][0] == jogador2 && jogo[1][1] == jogador2 && jogo[2][2] == jogador2)
                || (jogo[0][2] == jogador2 && jogo[1][1] == jogador2 && jogo[2][0] == jogador2))) {

            resultado = jogador2;
            
        }
        // Verifica um empate
        for (Status[] jogo1 : jogo) {
            for (Status jogo11 : jogo1) {
                if (jogo11 == Status.EMPTY) {
                    empate = false;
                }
            }
        }
        // Caso houver, atribui Status.EMPTY à variável de retorno
        if(empate)
            resultado = Status.EMPTY;
          
        return resultado;
            
    }
    // Classe principal
    public static void main(String[] args) {
        // Inicializa TicTacToe
        TicTacToe a = new TicTacToe();
        // Dá play no jogo
        a.playGame();

    }
}
