import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Jogos jogos = new Jogos();

        System.out.println("Você quer jogar o Caça-palavras (1) ou Jogo da Descoberta (2)");
        int escolha = sc.nextInt();

        while(escolha != 3){
            if(escolha == 1){
                jogos.jogar_caca_palavras();
            } else {
                jogos.jogar_jogo_descoberta();
            }

            System.out.println();
            System.out.println("Quer continuar? escolha (1) para Caça-palavras, (2) para Jogo da Descoberta ou (3) para sair.");
            escolha = sc.nextInt();
        }
    }
}