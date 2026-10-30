
package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;
import fag.objetos.Pessoa;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		popularTabela();

		System.out.println("Sistema de Biblioteca iniciado!");
		mostrarMenu();
	}

	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Patrick"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Theo"));
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Pedro"));

		listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis"));
		listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"));
		listaLivros.add(new Livro("Harry Potter", "J.K. Rowling"));
		listaLivros.add(new Livro("O Hobbit", "J.R.R. Tolkien"));
		listaLivros.add(new Livro("A Culpa é das Estrelas", "John Green"));
		listaLivros.add(new Livro("Diário de um Banana", "Jeff Kinney"));
		listaLivros.add(new Livro("Percy Jackson", "Rick Riordan"));
		listaLivros.add(new Livro("It: A Coisa", "Stephen King"));
		listaLivros.add(new Livro("O Alquimista", "Paulo Coelho"));
		listaLivros.add(new Livro("1984", "George Orwell"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;

		do {
			System.out.println("-------------------- Sistema de Biblioteca --------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6 - Registrar usuario");
			System.out.println("7 - Listar usuarios");
			System.out.println("0 - Sair");

			escolhaUsuario = scan.nextInt();
			scan.nextLine();

			validarEscolha(escolhaUsuario);

		} while(escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1: {
			listarLivros();
			break;
		}
		case 2: {
			cadastrarLivro();
			break;
		}
		case 3: {
			excluirLivro();
			break;
		}
		case 4: {
			emprestarLivro();
			break;
		}
		case 5: {
			devolverLivro();
			break;
		}
		case 6: {
			cadastrarUsuario();
			break;
		}
		case 7: {
			listarUsuarios();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuario que vai devolver o livro:");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();

		if(usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Informe um usuario valido!");
			return;
		}

		if(listaUsuarios.get(usuario).getLivrosEmprestados().size() == 0) {
			System.out.println("Usuario nao possui livros emprestados!");
			return;
		}

		System.out.println("Informe o numero do livro que sera devolvido:");

		for(int i = 0; i < listaUsuarios.get(usuario).getLivrosEmprestados().size(); i++) {
			System.out.printf("%d) %s - %s\n", i+1,
					listaUsuarios.get(usuario).getLivrosEmprestados().get(i).getNome(),
					listaUsuarios.get(usuario).getLivrosEmprestados().get(i).getAutor());
		}

		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if(livro < 0 || livro >= listaUsuarios.get(usuario).getLivrosEmprestados().size()) {
			System.out.println("Informe um livro existente!");
			return;
		}

		Livro livroDevolvido = listaUsuarios.get(usuario).getLivrosEmprestados().get(livro);
		livroDevolvido.setDataEmprestimo(null);
		listaUsuarios.get(usuario).getLivrosEmprestados().remove(livro);

		System.out.println("Livro devolvido com sucesso!");
	}

	private static void emprestarLivro() {
		if(listaUsuarios.size() == 0) {
			System.out.println("Nao existem usuarios cadastrados!");
			return;
		}

		if(listaLivros.size() == 0) {
			System.out.println("Nao existem livros cadastrados!");
			return;
		}

		listarUsuarios();
		System.out.println("Informe o usuario que vai pegar o livro:");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();

		if(usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Informe um usuario valido!");
			return;
		}

		if(listaUsuarios.get(usuario).getLivrosEmprestados().size() >= 2) {
			System.out.println("Usuario esta com o maximo de livros emprestados!");
			return;
		}

		listarLivros();
		System.out.println("Informe o numero do livro que deseja emprestar:");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if(livro < 0 || livro >= listaLivros.size()) {
			System.out.println("Informe um livro valido!");
			return;
		}

		if(listaLivros.get(livro).getDataEmprestimo() != null) {
			System.out.println("Livro ja esta emprestado!");
			return;
		}

		listaUsuarios.get(usuario).getLivrosEmprestados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataEmprestimo(new Date());

		System.out.println("Livro emprestado com sucesso!");
	}

	private static void listarUsuarios() {
		System.out.println("\n-------- Lista de Usuarios --------");

		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s\n", i+1, listaUsuarios.get(i).getNome());

			if(listaUsuarios.get(i).getLivrosEmprestados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosEmprestados().size(); j++) {
					System.out.printf("   %d) %s - %s\n", j+1,
							listaUsuarios.get(i).getLivrosEmprestados().get(j).getNome(),
							listaUsuarios.get(i).getLivrosEmprestados().get(j).getAutor());
				}
			}
		}

		System.out.println("");
	}

	private static void cadastrarUsuario() {
		Pessoa usuario = new Pessoa();

		System.out.println("Informe o nome do usuario:");
		usuario.setNome(scan.nextLine());

		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}

	private static void excluirLivro() {
		if(listaLivros.size() == 0) {
			System.out.println("Nao existem livros para excluir!");
			return;
		}

		listarLivros();
		System.out.println("Informe o numero do livro a ser excluido:");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();

		if(escolhaUsuario < 0 || escolhaUsuario >= listaLivros.size()) {
			System.out.println("Valor invalido!");
			return;
		}

		if(listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro esta emprestado e nao pode ser excluido!");
			return;
		}

		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
	}

	private static void listarLivros() {
		System.out.println("\n-------- Lista de Livros --------");

		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n", i+1,
					listaLivros.get(i).getNome(),
					listaLivros.get(i).getAutor(),
					listaLivros.get(i).validarDisponibilidade());
		}

		System.out.println("");
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Informe o nome do livro:");
		livro.setNome(scan.nextLine());

		System.out.println("Informe o autor do livro:");
		livro.setAutor(scan.nextLine());

		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}
}

