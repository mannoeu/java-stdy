package trabalho.classes;

// =========================================================================
// Classe FuncionarioHorista, que extende todos os atributos, 
// herda a classe Funcionario 
// =========================================================================

public class FuncionarioHorista extends Funcionario {
	private double salarioHora;
	private double horas;

	public FuncionarioHorista(String nome, String CPF, String sexo, String celular, String email, Endereco endereco,
			Double salarioHora, Double horas) {
		super(nome, CPF, sexo, celular, email, endereco);
		this.salarioHora = salarioHora;
		this.horas = horas;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	// =============================================================================================================
	// Implementa o método calcularSalario() de acordo com a forma de pagamanto do
	// funcionário horista
	// =============================================================================================================
	@Override
	public double calcularSalario() {		
		double salarioBruto = this.getSalarioHora() * this.getHoras();

		double salarioLiquido = salarioBruto - this.calcularImpostos(salarioBruto);
		
		return salarioLiquido;
	}
}
