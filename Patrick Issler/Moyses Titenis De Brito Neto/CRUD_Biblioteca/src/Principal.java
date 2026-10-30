import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE BIBLIOTECA ==========");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Excluir livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    atualizar();
                    break;

                case 5:
                    excluir();
                    break;

                case 0:
                    System.out.println("Sistema encerrado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }

    public static void cadastrar() {

        System.out.print("Digite o ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        if (buscarLivro(id) != null) {
            System.out.println("Esse ID ja esta cadastrado!");
            return;
        }

        System.out.print("Digite o titulo: ");
        String titulo = entrada.nextLine();

        System.out.print("Digite o autor: ");
        String autor = entrada.nextLine();

        Livro livro = new Livro(id, titulo, autor);

        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listar() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        for (Livro livro : livros) {
            System.out.println("\nID: " + livro.getId());
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
        }
    }

    public static void buscar() {

        System.out.print("Digite o ID do livro: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Livro livro = buscarLivro(id);

        if (livro != null) {
            System.out.println("ID: " + livro.getId());
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
        } else {
            System.out.println("Livro nao encontrado!");
        }
    }

    public static void atualizar() {

        System.out.print("Digite o ID do livro: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Livro livro = buscarLivro(id);

        if (livro == null) {
            System.out.println("Livro nao encontrado!");
            return;
        }

        System.out.print("Novo titulo: ");
        String titulo = entrada.nextLine();

        System.out.print("Novo autor: ");
        String autor = entrada.nextLine();

        livro.setTitulo(titulo);
        livro.setAutor(autor);

        System.out.println("Livro atualizado com sucesso!");
    }

    public static void excluir() {

        System.out.print("Digite o ID do livro: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Livro livro = buscarLivro(id);

        if (livro == null) {
            System.out.println("Livro nao encontrado!");
            return;
        }

        livros.remove(livro);

        System.out.println("Livro excluido com sucesso!");
    }

    public static Livro buscarLivro(int id) {

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }

        return null;
    }
}