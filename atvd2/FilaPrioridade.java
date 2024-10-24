import java.util.PriorityQueue;
import java.util.Comparator;

public class FilaPrioridade {
    private PriorityQueue<Pedido> fila;

    public FilaPrioridade() {
        fila = new PriorityQueue<>(Comparator.comparing(Pedido::isVIP).reversed()
                                              .thenComparing(Pedido::getId));
    }

    public void adicionarPedido(Pedido pedido) {
        fila.add(pedido);
    }

    public Pedido processarProximoPedido() {
        return fila.poll(); // Remove e retorna o pedido com maior prioridade
    }

    public void removerPedido(int id) {
        fila.removeIf(p -> p.getId() == id);
    }

    public void visualizarPedidos() {
        System.out.println("Pedidos na fila:");
        for (Pedido pedido : fila) {
            System.out.println(pedido);
        }
    }
}
