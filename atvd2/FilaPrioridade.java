public class FilaPrioridade {
    private Pedido[] fila;
    private int tamanho;
    private int capacidade;

    public FilaPrioridade(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new Pedido[capacidade];
        this.tamanho = 0;
    }

    public void adicionarPedido(Pedido pedido) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia. Não é possível adicionar mais pedidos.");
            return;
        }

        int posicaoInsercao = 0;
        if (pedido.isVIP()) {
            while (posicaoInsercao < tamanho && fila[posicaoInsercao].isVIP()) {
                posicaoInsercao++;
            }
            for (int i = tamanho; i > posicaoInsercao; i--) {
                fila[i] = fila[i - 1];
            }
        } else {
            posicaoInsercao = tamanho;
        }
        
        fila[posicaoInsercao] = pedido;
        tamanho++;
    }

    public Pedido processarProximoPedido() {
        if (tamanho == 0) {
            System.out.println("Não há pedidos na fila.");
            return null;
        }

        Pedido pedidoProcessado = fila[0];
        for (int i = 0; i < tamanho - 1; i++) {
            fila[i] = fila[i + 1];
        }

        fila[tamanho - 1] = null;
        tamanho--;
        return pedidoProcessado;
    }

    public void removerPedido(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    fila[j] = fila[j + 1];
                }
                fila[tamanho - 1] = null;
                tamanho--;
                System.out.println("Pedido removido com sucesso.");
                return;
            }
        }
        System.out.println("Pedido não encontrado.");
    }

    public void visualizarPedidos() {
        if (tamanho == 0) {
            System.out.println("Não há pedidos na fila.");
            return;
        }
        System.out.println("Pedidos na fila:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println(fila[i]);
        }
    }
}
