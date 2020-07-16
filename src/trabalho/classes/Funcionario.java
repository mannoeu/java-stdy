package trabalho.classes;

import trabalho.interfaces.Tributavel;
import java.text.DecimalFormat;

// =========================================================================
// Classe Funcionário, que extende todos os atributos, 
// ou seja, herda a classe Pessoa e implementa a interface Tributavel
// =========================================================================

public abstract class Funcionario extends Pessoa implements Tributavel {
	private Endereco endereco;

	public Funcionario(String nome, String CPF, String sexo, String celular, String email, Endereco endereco) {
		super(nome, CPF, sexo, celular, email);

		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// =========================================================================
	// O método toString() está sendo implementado na classe funcionário pois:
	// - é necessário imprimir somente o nome, o endereço e o salário
	// e estes dados são genéricos, ou seja, são comuns entre os 3 tipos de funcionário
	// portanto, é desnecessário implementar o mesmo método nas 3 classes
	// =========================================================================
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("##,###,###,###,##0.00");
		String salarioFormatado = decimalFormat.format(this.calcularSalario());
		String resumo = "Nome: " + this.getNome() + "\nSalário: R$" + salarioFormatado + "\nRua: "
				+ this.getEndereco().getRua() + "\nNúmero: " + this.getEndereco().getNumero() + "\nBairro: "
				+ this.getEndereco().getBairro() + "\nCidade: " + this.getEndereco().getCidade() + "\nCEP: "
				+ this.getEndereco().getCep();

		if (endereco.getComplemento() != null) {
			resumo += "\nComplemento: " + this.getEndereco().getComplemento();
		}

		return resumo;
	}

	// =========================================================================
	// Implementa o método calcularImposto() da interface Tributavel
	// =========================================================================
	public double calcularImpostos(double salario) {
		double impostoDeRenda = 0;
		double inss = 0;

		// DE ACORDO COM A TABELA DE IMPOSTO DE RENDA DE 2019
		if (salario >= 4664.69) {
			impostoDeRenda = salario * 0.275;
		} else if (salario >= 3751.06) {
			impostoDeRenda = salario * 0.225;
		} else if (salario >= 2826.66) {
			impostoDeRenda = salario * 0.15;
		} else if (salario >= 1903.99) {
			impostoDeRenda = salario * 0.075;
		}

		// DE ACORDO COM A TABELA INSS 2019
		if (salario >= 2919.73) {
			inss = salario * 0.11;
		} else if (salario >= 1751.82) {
			inss = salario * 0.09;
		} else {
			inss = salario * 0.08;
		}

		double impostoTotal = impostoDeRenda + inss;

		return impostoTotal;
	}

	// =================================================================================================
	// Define o método abstrato calcularSalario() que será implementado pelas classes filhas:
	// - FuncionarioComissado
	// - FuncionarioHorista
	// - FuncionarioMensalista
	// Por que todas essas classes filhas possuem uma forma diferente de calcular o
	// salário
	// Daí podemos comparar ao nome "polimorfismo": aquele que assume várias formas
	// =================================================================================================
	public abstract double calcularSalario();
}
