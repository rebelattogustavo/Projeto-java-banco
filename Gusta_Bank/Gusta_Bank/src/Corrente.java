import java.util.ArrayList;

public class Corrente extends Conta{
	double limite;

	static ArrayList<Corrente> listaCorrentes = new ArrayList<Corrente>();
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void cadastro() {
		
	}
	public void pagamento() {
		
	}
	public void deposito() {
		
	}
	public void transferencia() {
		
	}
	
	public Corrente() {
		super();
	}

	public Corrente(double saldo, String titular, String senha, int numero, boolean status, double limite) {
		super(saldo, titular, senha, numero, status);
		this.limite = limite;
	}

	@Override
	public String toString() {
		return super.toString() + "\nLimite: " + limite;
	}
	
	
	
	
	
}
