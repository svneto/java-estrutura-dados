public class PilhaApp {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);

        pilha.mostrarPilha();

        pilha.pop();
        pilha.pop();

        pilha.mostrarPilha();

        pilha.push(50);
        pilha.push(60);

        pilha.mostrarPilha();
    }
}
