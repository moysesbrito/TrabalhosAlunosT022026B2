
public class Main {
    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(5);

        System.out.println("Primeira compra:");
        maquina.comprar(2, 10.00);

        System.out.println();

        System.out.println("Segunda compra:");
        maquina.comprar(4, 18.00);

        System.out.println();

        maquina.exibirEstado();
    }
}
