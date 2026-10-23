
public class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    boolean status;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = false;
    }

    public void adicionarLanches(int quantidade) {
        if (status) {
            System.out.println("Pedido ja finalizado!");
        } else if (quantidade <= 0) {
            System.out.println("Quantidade invalida!");
        } else {
            quantidadeLanches += quantidade;
            System.out.println("Lanches adicionados!");
        }
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total * 0.90;
        }

        if (quantidadeLanches > 0) {
            total += taxaEntrega;
        }

        return total;
    }

    public void finalizarPedido() {
        status = true;
        System.out.println("Pedido finalizado!");
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());

        if (status) {
            System.out.println("Status: Finalizado");
        } else {
            System.out.println("Status: Em andamento");
        }
    }
}
