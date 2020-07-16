package trabalho.interfaces;

// =============================================================================================================
// Interface Verificavel, obriga a implementa�ao do m�todo validarCPF() e solicitarNovoCPF()
// =============================================================================================================

public interface Verificavel {
	public boolean validarCPF(String CPF);

	public void solicitarNovoCPF();
}
