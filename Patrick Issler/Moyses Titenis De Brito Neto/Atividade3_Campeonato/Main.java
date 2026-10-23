
public class Main {
    public static void main(String[] args) {
        Time time1 = new Time("Flamengo");
        Time time2 = new Time("Corinthians");

        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarEmpate();

        time2.registrarVitoria();
        time2.registrarDerrota();
        time2.registrarEmpate();

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.pontos > time2.pontos) {
            System.out.println("Flamengo tem mais pontos!");
        } else if (time2.pontos > time1.pontos) {
            System.out.println("Corinthians tem mais pontos!");
        } else {
            System.out.println("Os times estao empatados!");
        }
    }
}
