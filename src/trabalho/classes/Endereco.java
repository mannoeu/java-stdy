package trabalho.classes;

// =========================================================================
// Classe Endereço, possui todos os atributos do diagrama, getters e setters
// e neste contexto é equivalente à uma entidade fraca, 
// visto que ela não existe sem as outras classes referentes à funcionários
// =========================================================================

public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;

	public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public Endereco(String rua, String numero, String bairro, String cidade, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String toString() {
		if (complemento != null) {
			return rua + ',' + numero + '.' + bairro + ',' + complemento + '-' + cidade + ',' + cep;
		}
		return rua + ',' + numero + '.' + bairro + '-' + cidade + ',' + cep;
	}
}
