
public class MaquinaRefrigerante {
    int quantidadeEstoque;
    double preco;
    double dinheiroArrecadado;

    public MaquinaRefrigerante(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = 4.50;
        this.dinheiroArrecadado = 0;
    }

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Quantidade invalida.");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Compra nao realizada: estoque insuficiente.");
        } else if (valorPago < quantidade * preco) {
            System.out.println("Compra nao realizada: dinheiro insuficiente.");
        } else {
            double total = quantidade * preco;
            double troco = valorPago - total;

            quantidadeEstoque -= quantidade;
            dinheiroArrecadado += total;

            System.out.println("Compra realizada com sucesso!");
            System.out.printf("Total: R$ %.2f%n", total);
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
        } else {
            System.out.println("Quantidade invalida para reposicao.");
        }
    }

    public void exibirEstado() {
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Preco: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n",
                dinheiroArrecadado);
    }
}
