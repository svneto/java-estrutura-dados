public class Pedido {
    private int id;
    private String clienteNome;
    private boolean isVIP;

    public Pedido(int id, String clienteNome, boolean isVIP) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.isVIP = isVIP;
    }

    public int getId() {
        return id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Cliente: " + clienteNome + (isVIP ? " (VIP)" : "");
    }
}
