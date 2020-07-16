package trabalho.classes;

import java.util.Random;

import trabalho.interfaces.Verificavel;

// =============================================================================================================
// Classe Pessoa, é uma classe abstrata que cria a representação comum dos dados que um funcionário tem
// E implementa a interface Verificavel
// =============================================================================================================

public abstract class Pessoa implements Verificavel {
	private String nome;
	private String CPF;
	private String sexo;
	private String celular;
	private String email;

	public Pessoa(String nome, String CPF, String sexo, String celular, String email) {
		this.nome = nome;
		this.CPF = CPF;
		this.sexo = sexo;
		this.celular = celular;
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String cPF) {
		this.CPF = cPF;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// =============================================================================================================
	// Implementa o método validarCPF
	// =============================================================================================================
	@Override
	public boolean validarCPF(String CPF) {
		if (CPF.length() != 11) {
			return false;
		}

		String[] cpfsInvalidos = { "00000000000", "11111111111", "22222222222", "33333333333", "44444444444",
				"55555555555", "66666666666", "77777777777", "88888888888", "99999999999" };

		for (String cpfInvalido : cpfsInvalidos) {
			if (CPF.equals(cpfInvalido)) {
				return false;
			}
		}

		return true;
	}

	// =============================================================================================================
	// Implementa o método solicitarNovoCPF
	// (este método é chamado quando é feita a tentativa de criar uma nova instância
	// da classe com um CPF inválido)
	// =============================================================================================================
	@Override
	public void solicitarNovoCPF() {
		String novoCPF = "";

		for (int i = 0; i < 11; i++) {
			int randomNum = new Random().nextInt(10);

			novoCPF += Integer.toString(randomNum);
		}

		this.setCPF(novoCPF);
	}
}
