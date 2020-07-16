package trabalho.classes;

// =========================================================================
// Classe FuncionarioComissado, que extende todos os atributos, 
// herda a classe Funcionario 
// =========================================================================

public class FuncionarioComissionado extends Funcionario {
	private double vendasBrutas;
	private double taxaComissao;

	public FuncionarioComissionado(String nome, String CPF, String sexo, String celular, String email,
			Endereco endereco, double taxaComissao) {
		super(nome, CPF, sexo, celular, email, endereco);
		this.taxaComissao = taxaComissao;
	}

	public double getVendasBrutas() {
		return vendasBrutas;
	}

	public void setVendasBrutas(double vendasBrutas) {
		this.vendasBrutas = vendasBrutas;
	}

	public double getTaxaComissao() {
		return this.taxaComissao;
	}

	public void setTaxaComissao(double taxaComissao) {
		this.taxaComissao = taxaComissao;
	}

	// =============================================================================================================
	// Implementa o método calcularSalario() de acordo com a forma de pagamanto do
	// funcionário comissado
	// =============================================================================================================

	@Override
	public double calcularSalario() {
		double salarioBruto = (this.getTaxaComissao() / 100) * this.getVendasBrutas();

		double salarioLiquido = salarioBruto - this.calcularImpostos(salarioBruto);

		return salarioLiquido;
	}
}
