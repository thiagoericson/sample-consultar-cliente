package br.com.treinamento.consultarcliente.model;

public class ClienteMock {

	private long cpf;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private Double salario;
	private String profissao;
	
	public ClienteMock(long cpf, String nome, String dataNascimento, String sexo, Double salario, String profissao) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setSexo(sexo);
		this.setSalario(salario);
		this.setProfissao(profissao);
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

}
