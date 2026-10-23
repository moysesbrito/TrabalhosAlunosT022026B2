
public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Moyses", 200.00);

        cofrinho.depositar(100.00);
        cofrinho.depositar(50.00);

        cofrinho.retirar(200.00);

        cofrinho.exibirSaldo();
    }
}
