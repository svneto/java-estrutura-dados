public class GerenciadorDePedidos {
    private FilaPrioridade filaPrioridade;
    private int proximoId;

    public GerenciadorDePedidos() {
        filaPrioridade = new FilaPrioridade();
        proximoId = 1; // ID dos pedidos começa em 1
    }

    public void adicionarNovoPedido(String clienteNome, boolean isVIP) {
        Pedido novoPedido = new Pedido(proximoId++, clienteNome, isVIP);
        filaPrioridade.adicionarPedido(novoPedido);
        System.out.println("Pedido adicionado: " + novoPedido);
    }

    public void processarProximoPedido() {
        Pedido pedidoProcessado = filaPrioridade.processarProximoPedido();
        if (pedidoProcessado != null) {
            System.out.println("Pedido processado: " + pedidoProcessado);
        } else {
            System.out.println("Não há pedidos para processar.");
        }
    }

    public void visualizarPedidos() {
        filaPrioridade.visualizarPedidos();
    }

    public void removerPedido(int id) {
        filaPrioridade.removerPedido(id);
        System.out.println("Pedido ID " + id + " removido.");
    }
}
