package trabalho.classes;

public class FuncionarioMensalista extends Funcionario {
	private double salarioMensal;

	public FuncionarioMensalista(String nome, String CPF, String sexo, String celular, String email, Endereco endereco,
			double salarioMensal) {
		super(nome, CPF, sexo, celular, email, endereco);

		this.salarioMensal = salarioMensal;
	}

	public double getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(double salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	// =============================================================================================================
	// Implementa o método calcularSalario() de acordo com a forma de pagamanto do
	// funcionário mensalista
	// =============================================================================================================

	@Override
	public double calcularSalario() {
		double salarioBruto = this.getSalarioMensal();

		double salarioLiquido = salarioBruto - this.calcularImpostos(salarioBruto);

		return salarioLiquido;
	}
}
