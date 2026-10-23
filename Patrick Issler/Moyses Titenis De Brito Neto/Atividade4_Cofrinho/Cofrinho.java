
public class Cofrinho {
    String dono;
    double saldo;
    double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.saldo = 0;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado!");
        } else {
            System.out.println("Valor invalido!");
        }
    }

    public void retirar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else if (valor <= 0) {
            System.out.println("Valor invalido!");
        } else {
            saldo -= valor;
            System.out.println("Retirada realizada!");
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta atingida!");
        } else {
            System.out.printf("Faltam R$ %.2f para a meta.%n",
                    metaEconomia - saldo);
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        verificarMeta();
    }
}
