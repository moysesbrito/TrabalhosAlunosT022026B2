
package fag.objetos;

import java.util.Date;

public class Livro {

	private String nome;
	private String autor;
	private Date dataEmprestimo;
	
	public Livro() {
	}
	
	public Livro(String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public String validarDisponibilidade() {
		String VERDE = "\u001B[32m";
		String VERMELHO = "\u001B[31m";
		String RESET = "\u001B[0m";
		
		if(dataEmprestimo == null) {
			return VERDE + "Disponível" + RESET;
		}else {
			return VERMELHO + "Indisponível" + RESET;
		}
	}
}

