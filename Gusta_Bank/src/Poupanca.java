import java.util.ArrayList;

public class Poupanca extends Conta{
	
	double rendimento;
	
	static ArrayList<Poupanca> listaPoupancas = new ArrayList<Poupanca>();
	
	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	
	public Poupanca() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Poupanca(double saldo, String titular, String senha, int numero, boolean status, double rendimento) {
		super(saldo, titular, senha, numero, status);
		this.rendimento = rendimento;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + "\nRendimento: " + rendimento;
	}
	
	
	
	
}
