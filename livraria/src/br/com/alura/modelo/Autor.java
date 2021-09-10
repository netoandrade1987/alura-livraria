/**
 * 
 */
package br.com.alura.modelo;

import java.time.LocalDate;

/**
 * @author neto_
 *
 */
public class Autor {
	
	private int id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String miniCurriculo;
	
	
	/**
	 * 
	 */
	public Autor() {}
	
	
	/**
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @param miniCurriculo
	 */
	public Autor(String nome, String email, LocalDate dataNascimento, String miniCurriculo) {
		
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.miniCurriculo = miniCurriculo;
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getMiniCurriculo() {
		return miniCurriculo;
	}


	public void setMiniCurriculo(String miniCurriculo) {
		this.miniCurriculo = miniCurriculo;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", miniCurriculo=" + miniCurriculo + "]";
	}


	
	
	

}
