import java.util.Scanner;

public class FilaCircularExemplo {
    private int[] fila;
    private int posicaoInsercao;
    private int posicaoLeitura;
    private int tamanho;
    private int valorAtual;
    private int count;

    public FilaCircularExemplo(int tamanho) {
        this.fila = new int[tamanho];
        this.posicaoInsercao = 0;
        this.posicaoLeitura = 0;
        this.tamanho = tamanho;
        this.valorAtual = 1;
        this.count = 0;
    }

    public void enfileirar() {
        if (count == tamanho) {
            System.out.println("Fila cheia!");
        } else {
            fila[posicaoInsercao] = valorAtual++;
            posicaoInsercao = (posicaoInsercao + 1) % tamanho;
            count++;
            imprimirFila();
        }
    }

    public void desenfileirar() {
        if (count == 0) {
            System.out.println("Fila vazia!");
        } else {
            fila[posicaoLeitura] = 0;
            posicaoLeitura = (posicaoLeitura + 1) % tamanho;
            count--;
            imprimirFila();
        }
    }

    public void imprimirFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            if (fila[i] == 0) {
                System.out.print("[ ] ");
            } else {
                System.out.print("[" + fila[i] + "] ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaCircularExemplo fila = new FilaCircularExemplo(5);

        while (true) {
            System.out.print("Digite '+' para enfileirar ou '-' para desenfileirar: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("+")) {
                fila.enfileirar();
            } else if (opcao.equals("-")) {
                fila.desenfileirar();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
