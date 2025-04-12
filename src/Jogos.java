import java.util.Random;
import java.util.Scanner;

public class Jogos {

    Scanner sc = new Scanner(System.in);

    // Variáveis do Caça Palavras
    public static final int tamanho_tabuleiro = 10;
    public static final char[][] tabuleiro_caca = new char[tamanho_tabuleiro][tamanho_tabuleiro];
    public static final String[] palavras_caca = {"SUPINO", "REMADA", "SCOTT", "ROSCA", "EXTENSORA", "FLEXORA"};
    public static String palavra_selecionada_caca;
    public static final Random random = new Random();

    // Variáveis do Jogo da Descoberta
    public static final String[] palavras_descoberta = {"ENGENHARIA", "SOFTWARE", "DADOS", "ANALISTA"};
    public static final int tamanho_vetor = palavras_descoberta.length;
    public static String palavra_selecionada_descoberta;

    // Jogo Caça-palavras

    public void selecionar_palavra_caca() {
        palavra_selecionada_caca = palavras_caca[random.nextInt(palavras_caca.length)];
    }

    public void embaralhar_letras_caca() {
        for (int i = 0; i < tamanho_tabuleiro; i++) {
            for (int j = 0; j < tamanho_tabuleiro; j++) {
                tabuleiro_caca[i][j] = (char) ('A' + random.nextInt(26));
            }
        }
    }

    public void inserir_palavra_caca() {
        int linha_aleatoria = random.nextInt(tamanho_tabuleiro);
        int coluna_inicio = random.nextInt(tamanho_tabuleiro - palavra_selecionada_caca.length());

        for (int i = 0; i < tamanho_tabuleiro; i++) {
            for (int j = 0; j < tamanho_tabuleiro; j++) {
                if(i < palavra_selecionada_caca.length()){
                    tabuleiro_caca[linha_aleatoria][coluna_inicio + i] = palavra_selecionada_caca.charAt(i);
                }
            }
        }
    }

    public void apresentar_tabuleiro_caca() {
        System.out.println("= Caça-Palavras =");
        for (int i = 0; i < tamanho_tabuleiro; i++) {
            for (int j = 0; j < tamanho_tabuleiro; j++) {
                System.out.print(tabuleiro_caca[i][j]);
            }
            System.out.println();
        }
        System.out.println("=================");
        System.out.println();
    }

    public void jogar_caca_palavras(){
        selecionar_palavra_caca();
        embaralhar_letras_caca();
        inserir_palavra_caca();
        apresentar_tabuleiro_caca();

        System.out.println("Chute a palavra, mas em letra maiuscula!");

        String chute = sc.nextLine().toUpperCase();

        while(!chute.equals(palavra_selecionada_caca)) {
            System.out.println();
            System.out.println("Voce errou, tente novamente!");
            System.out.println();

            apresentar_tabuleiro_caca();

            chute = sc.nextLine().toUpperCase();
        }

        System.out.println();
        System.out.println("Parabens, voce acertou a palavra correta!");

    }

    // Jogo da Descoberta

    public void selecionar_palavra_descoberta(){
        palavra_selecionada_descoberta = palavras_descoberta[random.nextInt(palavras_descoberta.length)];
    }

    public static String embaralhar_letras_descoberta(){
        char[] palavra_selecionada_array = palavra_selecionada_descoberta.toCharArray();

        for (int i = 0; i < palavra_selecionada_array.length; i++) {
            int indice_palavra_aleatoria = random.nextInt(palavra_selecionada_array.length);
            char temp = palavra_selecionada_array[i];
            palavra_selecionada_array[i] = palavra_selecionada_array[indice_palavra_aleatoria];
            palavra_selecionada_array[indice_palavra_aleatoria] = temp;
        }
        return new String(palavra_selecionada_array);
    }

    public void jogar_jogo_descoberta() {
        System.out.println("Bem-vindo ao Jogo da Descoberta");
        selecionar_palavra_descoberta();
        String palavra_para_descobrir = embaralhar_letras_descoberta();

        System.out.println("Qual a palavra " + palavra_para_descobrir + "?");

        int tentativa = 0;
        Boolean chute = false;

        while(true) {
            System.out.println("Informe a palavra, 'dica' para ganhar uma dica ou '0' para desistir!");
            String resposta = sc.next().toUpperCase();

            if(resposta.equals("0")){
                System.out.println("Parabéns, você sabe o seu limite, com " + tentativa + " tentativas.");
                break;
            } if(resposta.equals("dica")){
                System.out.println("A primeira letra é: " + palavra_selecionada_descoberta.charAt(0) + " e a última é: " + palavra_selecionada_descoberta.charAt(palavra_para_descobrir.length()-1));
                continue;
            } if(resposta.equals(palavra_selecionada_descoberta)){
                tentativa++;
                System.out.println("Você acertou com " + tentativa + " tentativas!");
                break;
            } else {
                tentativa++;
            }
        }
    }

}