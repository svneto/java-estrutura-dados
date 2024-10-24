// Pilha.java
public class Pilha {
    private int[] pilhaArray;
    private int topo;
    private int capacidade;

    // Construtor
    public Pilha(int tamanho) {
        capacidade = tamanho;
        pilhaArray = new int[capacidade];
        topo = -1; // A pilha começa vazia
    }

    // Inserir item na pilha (push)
    public void push(int valor) {
        if (isFull()) {
            throw new RuntimeException("A pilha está cheia");
        }
        pilhaArray[++topo] = valor; // Incrementa o topo e adiciona o valor
    }

    // Remover item da pilha (pop)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }
        return pilhaArray[topo--]; // Retorna o valor do topo e decrementa o topo
    }

    // Ver o item no topo (sem remover)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }
        return pilhaArray[topo];
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return (topo == -1);
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return (topo == capacidade - 1);
    }

    // Tamanho atual da pilha
    public int size() {
        return topo + 1;
    }

    // Exibe os elementos da pilha
    public void mostrarPilha() {
        System.out.print("Elementos da pilha: ");
        for (int i = topo; i >= 0; i--) {
            System.out.print(pilhaArray[i] + " ");
        }
        System.out.println();
    }
}
