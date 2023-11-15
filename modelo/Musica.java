package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Musica {

	private String titulo, letra;
	private LocalDate data_lancamento;
	private Categoria categoria;
	private int duracao;
	private ArrayList<Autor> autores;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public LocalDate getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
	public Musica(String titulo, String letra, LocalDate data_lancamento, Categoria categoria, int duracao,
			ArrayList<Autor> autores) {
		this.titulo = titulo;
		this.letra = letra;
		this.data_lancamento = data_lancamento;
		this.categoria = categoria;
		this.duracao = duracao;
		this.autores = autores;
	}
}