
public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Moyses");

        pedido.adicionarLanches(2);
        pedido.adicionarLanches(1);

        pedido.exibirPedido();

        pedido.finalizarPedido();

        pedido.adicionarLanches(1);

        pedido.exibirPedido();
    }
}
