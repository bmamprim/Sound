package modelo;

public class Autor {

	private String cpf, nome_original, nome_artistico;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_original() {
		return nome_original;
	}

	public void setNome_original(String nome_original) {
		this.nome_original = nome_original;
	}

	public String getNome_artistico() {
		return nome_artistico;
	}

	public void setNome_artistico(String nome_artistico) {
		this.nome_artistico = nome_artistico;
	}

	public Autor(String cpf, String nome_original, String nome_artistico) {
		this.cpf = cpf;
		this.nome_original = nome_original;
		this.nome_artistico = nome_artistico;
	}
	
	
	
}