
package biblioteca;

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

        System.out.print("Digite o ID do livro: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Livro livro : livros) {
            if (livro.getId() == id) {
                System.out.println("Esse ID ja existe!");
                return;
            }
        }

        System.out.print("Digite o titulo do livro: ");
        String titulo = entrada.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = entrada.nextLine();

        Livro novoLivro = new Livro(id, titulo, autor);

        livros.add(novoLivro);

        System.out.println("Livro cadastrado com sucesso!");
    }



    public static void listar() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.println("\n===== LIVROS CADASTRADOS =====");

        for (Livro livro : livros) {

            System.out.println("ID: " + livro.getId());
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("-----------------------------");

        }
    }

    public static void buscar() {

        System.out.print("Digite o ID do livro: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Livro livro : livros) {

            if (livro.getId() == id) {

                System.out.println("\n===== LIVRO ENCONTRADO =====");
                System.out.println("ID: " + livro.getId());
                System.out.println("Titulo: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());

                return;
            }
        }

        System.out.println("Livro nao encontrado!");

    }

    public static void atualizar() {

        System.out.print("Digite o ID do livro que deseja atualizar: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Livro livro : livros) {

            if (livro.getId() == id) {

                System.out.print("Novo titulo: ");
                String titulo = entrada.nextLine();

                System.out.print("Novo autor: ");
                String autor = entrada.nextLine();

                livro.setTitulo(titulo);
                livro.setAutor(autor);

                System.out.println("Livro atualizado com sucesso!");

                return;
            }
        }

        System.out.println("Livro nao encontrado!");

    }

    public static void excluir() {

        System.out.print("Digite o ID do livro que deseja excluir: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Livro livro : livros) {

            if (livro.getId() == id) {

                livros.remove(livro);

                System.out.println("Livro excluido com sucesso!");

                return;
            }
        }

        System.out.println("Livro nao encontrado!");

    }
}

