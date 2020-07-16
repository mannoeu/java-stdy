package trabalho.interfaces;

// =============================================================================================================
// Interface Verificavel, obriga a implementaçao do método validarCPF() e solicitarNovoCPF()
// =============================================================================================================

public interface Verificavel {
	public boolean validarCPF(String CPF);

	public void solicitarNovoCPF();
}
