import java.util.ArrayList;
import java.util.Scanner;

public class Credito extends Conta {
	
	private double limite;
	private int dataFatura;
	private double limiteTotal;

	static ArrayList<Credito> listaCredito = new ArrayList<Credito>();
	

	@Override
	public String toString() {
		return super.toString() + "\nLimite: " + limite + "\nData da fatura: " + dataFatura;
	}


	public Credito(double saldo, String titular, String senha, boolean status, int numero, double limite, double limiteTotal,
			int dataFatura) {
		super(saldo, titular, senha, status, numero);
		this.limite = limite;
		this.limiteTotal = limite;
		this.dataFatura = dataFatura;
	}


	public Credito() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static void pagamento(int tipoConta, int i) {
		System.out.print("""
			------- PAGAMENTO --------
			Insira o valor do pagamento (0 - voltar): R$\s""");
		double valPagamento = sc.nextDouble();
		if(listaCredito.get(i).getSaldo() < valPagamento || listaCredito.get(i).getLimite() < valPagamento){
			System.out.println("Saldo insuficiente, ou limite atingido!");
			pagamento(tipoConta, i);
		} else {
			listaCredito.get(i).setSaldo(listaCredito.get(i).getSaldo() - valPagamento);
			listaCredito.get(i).setLimite(listaCredito.get(i).getLimite() - valPagamento);
		}
	}

	public static void verLimiteTotal(int i){
		System.out.println("\nLimite Total: " + listaCredito.get(i).getLimiteTotal());
	}

	public static void verLimiteRestante(int i){
		System.out.println("\nLimite Restante: " + listaCredito.get(i).getLimite());
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getLimiteTotal() { return limiteTotal; };

	public void setLimiteTotal(double limiteTotal) { this.limiteTotal = limiteTotal; };

	public int getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(int dataFatura) {
		this.dataFatura = dataFatura;
	}
	
	
	
}
