public class Main {
    public static void main(String[] args) {
        Estacionamento carro = new Estacionamento("ABC1234", "Fiat Uno");

        carro.adicionarTempo(45);
        carro.exibirResumo();
    }
}
