package trabalho.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import trabalho.classes.Endereco;
import trabalho.classes.FuncionarioComissionado;
import trabalho.classes.FuncionarioHorista;
import trabalho.classes.FuncionarioMensalista;

// =========================================================================
// IMPLEMETA��O DAS CLASSES CRIADAS NO PACOTE trabalho.classes
// =========================================================================

public class Main {
	static Scanner entrada = new Scanner(System.in);

	static List<FuncionarioComissionado> funcionariosComissados = new ArrayList<FuncionarioComissionado>();
	static List<FuncionarioHorista> funcionariosHoristas = new ArrayList<FuncionarioHorista>();
	static List<FuncionarioMensalista> funcionariosMensalistas = new ArrayList<FuncionarioMensalista>();

	public static void main(String[] args) {
		boolean app = true;

		do {
			try {
				System.out.println("======================================================");
				System.out.println("MENU DE CADASTRO:");
				System.out.println("======================================================");
				System.out.println("Bem vindo ao menu de funcion�rios, escolha a opera��o:");

				System.out.println("1 - Cadastrar Funcion�rio Comissado");
				System.out.println("2 - Cadastrar Funcion�rio Horista");
				System.out.println("3 - Cadastrar Funcion�rio Mensalista");
				System.out.println("4 - Listar todos os funcion�rios cadastrados");
				System.out.println("5 - Atualizar os dados de um funcion�rio");
				System.out.println("0 - Sair");

				int tipo = entrada.nextInt();

				switch (tipo) {
				case 1:
					cadastrarComissado();
					break;
				case 2:
					cadastrarHorista();
					break;
				case 3:
					cadastrarMensalista();
					break;
				case 4:
					listarFuncionarios();
					break;
				case 5:
					atualizarFuncionario();
					break;
				default:
					app = false;
					break;
				}
			} catch (Exception e) {
				System.out.println("========================================================================");
				System.out.println("VALORES INV�LIDOS, REINICIANDO PROGRAMA...");
				System.out.println("========================================================================");

				// Reinicia a inst�ncia do Scanner que lan�ou a exce��o
				entrada = new Scanner(System.in);
			} finally {
				System.out.print("Digite algo e aperte Enter para continuar...");
				entrada.next();
			}
		} while (app);
	}

	public static void listarFuncionarios() {
		int codigo = 0;

		System.out.println("========================================================================");
		System.out.println("LISTAGEM DE FUNCION�RIOS");
		System.out.println("========================================================================");

		for (FuncionarioComissionado funcionario : funcionariosComissados) {
			System.out.println("C�digo do funcion�rio: C" + codigo);
			
			System.out.println(funcionario.toString());
			
			System.out.println("==========================================");
			codigo++;
		}

		codigo = 0;

		for (FuncionarioHorista funcionario : funcionariosHoristas) {
			System.out.println("C�digo do funcion�rio: H" + codigo);
			
			System.out.println(funcionario.toString());

			System.out.println("==========================================");
			codigo++;
		}

		codigo = 0;

		for (FuncionarioMensalista funcionario : funcionariosMensalistas) {
			System.out.println("C�digo do funcion�rio: M" + codigo);
			
			System.out.println(funcionario.toString());
			
			System.out.println("==========================================");
			codigo++;
		}
	}

	public static void atualizarFuncionario() throws Exception {
		System.out.println("========================================================================");
		System.out.println("ATUALIZAR OS DADOS DE UM FUNCION�RIO");
		System.out.println("========================================================================");

		System.out.println("Digite o c�digo do funcion�rio:");
		String codigo = entrada.next();

		String tipoDoFuncionario = String.valueOf(codigo.charAt(0));
		int indexDoFuncionario = Integer.parseInt(String.valueOf(codigo.charAt(1)));

		if (tipoDoFuncionario.equals("C")) {
			Endereco comissadoEndereco = solicitarEndereco();

			System.out.println("Digite os novos dados do atual funcion�rio "
					+ funcionariosComissados.get(indexDoFuncionario).getNome() + ": ");

			System.out.print("Nome: ");
			String nome = entrada.next();

			System.out.print("CPF: ");
			String cpf = entrada.next();

			System.out.print("Telefone: ");
			String telefone = entrada.next();

			System.out.print("Sexo: ");
			String sexo = entrada.next();

			System.out.print("Email: ");
			String email = entrada.next();

			System.out.print("Taxa de comiss�o (em porcentagem %): ");
			double comissao = entrada.nextDouble();

			System.out.print("Valor de vendas brutas: ");
			double vendasBrutas = entrada.nextDouble();

			FuncionarioComissionado comissado = funcionariosComissados.get(indexDoFuncionario);

			comissado.setNome(nome);
			comissado.setCPF(cpf);
			comissado.setCelular(telefone);
			comissado.setSexo(sexo);
			comissado.setEmail(email);
			comissado.setTaxaComissao(comissao);
			comissado.setVendasBrutas(vendasBrutas);
			comissado.setEndereco(comissadoEndereco);

			if(!comissado.validarCPF(comissado.getCPF())) {
				System.out.println("======================================================");
				System.out.println("ERRO, CPF INV�LIDO:");
				System.out.println("======================================================");
				
				throw new Exception("CPF Inv�lido");
			}
			
			funcionariosComissados.set(indexDoFuncionario, comissado);

			System.out.println("======================================================");
			System.out.println("RESUMO DA ATUALIZA��O DE DADOS:");
			System.out.println("======================================================");
			
			System.out.println(comissado.toString());

			System.out.println("======================================================");
			System.out.println("FIM DO RESUMO:");
			System.out.println("======================================================");

			return;

		} else if (tipoDoFuncionario.equals("H")) {
			Endereco horistaEndereco = solicitarEndereco();

			System.out.println("Digite os novos dados do atual funcion�rio "
					+ funcionariosHoristas.get(indexDoFuncionario).getNome() + ": ");

			System.out.print("Nome: ");
			String nome = entrada.next();

			System.out.print("CPF: ");
			String cpf = entrada.next();

			System.out.print("Telefone: ");
			String telefone = entrada.next();

			System.out.print("Sexo: ");
			String sexo = entrada.next();

			System.out.print("Email: ");
			String email = entrada.next();

			System.out.print("Pre�o por hora: ");
			double precoPorHora = entrada.nextDouble();

			System.out.print("Quantidade de horas trabalhadas: ");
			double horasTrabalhadas = entrada.nextDouble();

			FuncionarioHorista horista = funcionariosHoristas.get(indexDoFuncionario);

			horista.setCPF(cpf);			
			horista.setNome(nome);
			horista.setCelular(telefone);
			horista.setSexo(sexo);
			horista.setEmail(email);
			horista.setSalarioHora(precoPorHora);
			horista.setHoras(horasTrabalhadas);
			horista.setEndereco(horistaEndereco);
			
			if(!horista.validarCPF(horista.getCPF())) {
				System.out.println("======================================================");
				System.out.println("ERRO, CPF INV�LIDO:");
				System.out.println("======================================================");
				
				throw new Exception("CPF Inv�lido");
			}
			
			funcionariosHoristas.set(indexDoFuncionario, horista);

			System.out.println("======================================================");
			System.out.println("RESUMO DA ATUALIZA��O DE DADOS:");
			System.out.println("======================================================");
			
			System.out.println(horista.toString());

			System.out.println("======================================================");
			System.out.println("FIM DO RESUMO");
			System.out.println("======================================================");

			return;

		} else if (tipoDoFuncionario.equals("M")) {
			Endereco mensalistaEndereco = solicitarEndereco();

			System.out.println("Digite os novos dados do atual funcion�rio "
					+ funcionariosMensalistas.get(indexDoFuncionario).getNome() + ": ");

			System.out.print("Nome: ");
			String nome = entrada.next();

			System.out.print("CPF: ");
			String cpf = entrada.next();

			System.out.print("Telefone: ");
			String telefone = entrada.next();

			System.out.print("Sexo: ");
			String sexo = entrada.next();

			System.out.print("Email: ");
			String email = entrada.next();

			System.out.print("Sal�rio Bruto: ");
			double salarioBruto = entrada.nextDouble();

			FuncionarioMensalista mensalista = funcionariosMensalistas.get(indexDoFuncionario);

			mensalista.setNome(nome);
			mensalista.setCPF(cpf);
			mensalista.setCelular(telefone);
			mensalista.setSexo(sexo);
			mensalista.setEmail(email);
			mensalista.setSalarioMensal(salarioBruto);
			mensalista.setEndereco(mensalistaEndereco);
			
			if(!mensalista.validarCPF(mensalista.getCPF())) {
				System.out.println("======================================================");
				System.out.println("ERRO, CPF INV�LIDO, ATUALIZA��O DE DADOS CANCELADA");
				System.out.println("======================================================");
				
				throw new Exception("CPF Inv�lido");
			}
			
			funcionariosMensalistas.set(indexDoFuncionario, mensalista);

			System.out.println("======================================================");
			System.out.println("RESUMO DA ATUALIZA��O DE DADOS:");
			System.out.println("======================================================");
			
			System.out.println(mensalista.toString());

			System.out.println("======================================================");
			System.out.println("FIM DO RESUMO");
			System.out.println("======================================================");

			return;
		} else {
			System.out.println("N�o foi poss�vel encontrar o funcion�rio com o c�digo " + codigo);
			System.out.println("Use a op��o 4 para listar os funcion�rios e veja o c�digo do funcion�rio desejado");
		}

		System.out.println("========================================================================");
		System.out.println("FIM DA ATUALIZA��O DE DADOS");
		System.out.println("========================================================================");
	}

	public static void cadastrarComissado() throws Exception {
		System.out.println("======================================================");
		System.out.println("IN�CIO DO CADASTRO:");
		System.out.println("======================================================");

		Endereco comissadoEndereco = solicitarEndereco();

		System.out.println("Digite os dados do funcion�rio: ");

		System.out.print("Nome: ");
		String nome = entrada.next();

		System.out.print("CPF: ");
		String cpf = entrada.next();

		System.out.print("Telefone: ");
		String telefone = entrada.next();

		System.out.print("Sexo: ");
		String sexo = entrada.next();

		System.out.print("Email: ");
		String email = entrada.next();

		System.out.print("Taxa de comiss�o (em porcentagem %): ");
		double comissao = entrada.nextDouble();

		System.out.print("Valor de vendas brutas: ");
		double vendasBrutas = entrada.nextDouble();

		FuncionarioComissionado comissado = new FuncionarioComissionado(nome, cpf, telefone, sexo, email,
				comissadoEndereco, comissao);

		comissado.setVendasBrutas(vendasBrutas);
		
		if(!comissado.validarCPF(comissado.getCPF())) {
			System.out.println("======================================================");
			System.out.println("ERRO, CPF INV�LIDO, CADASTRO DE FUNCION�RIO CANCELADO");
			System.out.println("======================================================");
			
			throw new Exception("CPF Inv�lido");
		}
		
		funcionariosComissados.add(comissado);

		System.out.println("======================================================");
		System.out.println("RESUMO DO CADASTRO:");
		System.out.println("======================================================");
		
		System.out.println(comissado.toString());

		System.out.println("======================================================");
		System.out.println("FIM DO RESUMO:");
		System.out.println("======================================================");
	}

	public static void cadastrarHorista() throws Exception {
		System.out.println("======================================================");
		System.out.println("IN�CIO DO CADASTRO:");
		System.out.println("======================================================");

		Endereco horistaEndereco = solicitarEndereco();

		System.out.println("Digite os dados do funcion�rio: ");

		System.out.print("Nome: ");
		String nome = entrada.next();

		System.out.print("CPF: ");
		String cpf = entrada.next();

		System.out.print("Telefone: ");
		String telefone = entrada.next();

		System.out.print("Sexo: ");
		String sexo = entrada.next();

		System.out.print("Email: ");
		String email = entrada.next();

		System.out.print("Pre�o por hora: ");
		double precoPorHora = entrada.nextDouble();

		System.out.print("Quantidade de horas trabalhadas: ");
		double horasTrabalhadas = entrada.nextDouble();
		
		FuncionarioHorista horista = new FuncionarioHorista(nome, cpf, telefone, sexo, email, horistaEndereco,
				precoPorHora, horasTrabalhadas);

		if(!horista.validarCPF(horista.getCPF())) {
			System.out.println("======================================================");
			System.out.println("ERRO, CPF INV�LIDO, CADASTRO DE FUNCION�RIO CANCELADO");
			System.out.println("======================================================");
			
			throw new Exception("CPF Inv�lido");
		}
		
		funcionariosHoristas.add(horista);

		System.out.println("======================================================");
		System.out.println("RESUMO DO CADASTRO:");
		System.out.println("======================================================");
		
		System.out.println(horista.toString());

		System.out.println("======================================================");
		System.out.println("FIM DO RESUMO");
		System.out.println("======================================================");
	}

	public static void cadastrarMensalista() throws Exception {
		System.out.println("======================================================");
		System.out.println("IN�CIO DO CADASTRO:");
		System.out.println("======================================================");

		Endereco mensalistaEndereco = solicitarEndereco();

		System.out.println("Digite os dados do funcion�rio: ");

		System.out.print("Nome: ");
		String nome = entrada.next();

		System.out.print("CPF: ");
		String cpf = entrada.next();

		System.out.print("Telefone: ");
		String telefone = entrada.next();

		System.out.print("Sexo: ");
		String sexo = entrada.next();

		System.out.print("Email: ");
		String email = entrada.next();

		System.out.print("Sal�rio Bruto: ");
		double salarioBruto = entrada.nextDouble();

		FuncionarioMensalista mensalista = new FuncionarioMensalista(nome, cpf, telefone, sexo, email,
				mensalistaEndereco, salarioBruto);

		if(!mensalista.validarCPF(mensalista.getCPF())) {
			System.out.println("======================================================");
			System.out.println("ERRO, CPF INV�LIDO, CADASTRO DE FUNCION�RIO CANCELADO");
			System.out.println("======================================================");
			
			throw new Exception("CPF Inv�lido");
		}
		
		funcionariosMensalistas.add(mensalista);

		System.out.println("======================================================");
		System.out.println("IN�CIO DO RESUMO:");
		System.out.println("======================================================");
		
		System.out.println(mensalista.toString());

		System.out.println("======================================================");
		System.out.println("FIM DO RESUMO");
		System.out.println("======================================================");
	}

	public static Endereco solicitarEndereco() {
		System.out.println("Digite seu endere�o:");

		System.out.print("Rua: ");
		String rua = entrada.next();

		System.out.print("N�mero: ");
		String numero = entrada.next();

		System.out.print("Complemento (Opcional): ");
		String complemento = entrada.next();

		if (complemento.length() == 0) {
			complemento = null;
		}

		System.out.print("Bairro: ");
		String bairro = entrada.next();

		System.out.print("Cidade: ");
		String cidade = entrada.next();

		System.out.print("CEP: ");
		String cep = entrada.next();

		Endereco endereco;

		if (complemento != null) {
			endereco = new Endereco(rua, numero, complemento, bairro, cidade, cep);
		} else {
			endereco = new Endereco(rua, numero, bairro, cidade, cep);
		}

		return endereco;
	}
}
