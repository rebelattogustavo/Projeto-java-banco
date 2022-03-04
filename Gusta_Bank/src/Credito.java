import java.util.ArrayList;

public class Credito extends Conta{
	
	double limite, limiteVariavel;


	int dataFatura;

	public Credito() {

	}

	public double getLimiteVariavel() {
		return limiteVariavel;
	}

	public void setLimiteVariavel(double limiteVariavel) {
		this.limiteVariavel = limiteVariavel;
	}
	public int getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(int dataFatura) {
		this.dataFatura = dataFatura;
	}

	static ArrayList<Credito> listaCreditos = new ArrayList<Credito>();

	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}


	public Credito(double saldo, String titular, String senha, int numero, boolean status, double limite, int dataFatura, double limiteVariavel) {
		super(saldo, titular, senha, numero, status);
		this.limite = limite;
		this.dataFatura = dataFatura;
		this.limiteVariavel = limiteVariavel;
		// TODO Auto-generated constructor stub
	}

	public Credito(double limite, ArrayList<Credito> creditos) {
		super();
		this.limite = limite;
		Credito.listaCreditos = creditos;
	}

	@Override
	public String toString() {
		return super.toString() + "\nLimite: " + limite;
	}

	
	
}
