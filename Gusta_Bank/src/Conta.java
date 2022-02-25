import java.util.Scanner;

public class Conta {
	
	static Scanner tec = new Scanner(System.in);
	
	private double saldo;
	private String titular, senha;
	private int numero;
	private boolean status;
	
	
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void conta() {
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Informe o saldo: ");
		this.saldo = tec.nextDouble();
		
		System.out.print("Informe o nome do titular: ");
		this.titular = tec.next();
		
		System.out.println("Informe a sua senha: ");
		this.senha = tec.next();
		
		System.out.println("Informe o status da conta: ");
		this.status = tec.next() != null;
		
		System.out.println("Informe o número da conta: ");
		this.numero = tec.nextInt();
	}
	
	
	
	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conta(double saldo, String titular, String senha, int numero, boolean status) {
		super();
		this.saldo = saldo;
		this.titular = titular;
		this.senha = senha;
		this.numero = numero;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Titular: " + titular + "\nNumero: " + numero + "\nSenha: " + senha
				+ "\nStatus: " + status + "\nSaldo: " + saldo ;
	}

	public static void verSaldo(int indice, int opcao){
		switch(opcao) {
		case 1:
			System.out.println(Corrente.listaCorrentes.get(indice).getSaldo());
			break;
		case 2:
			Credito.listaCreditos.get(indice).getSaldo();
			break;
		case 3:
			Poupanca.listaPoupancas.get(indice).getSaldo();
			break;
		}
	}
	
	public static void saque(int indice, int opcao) {
		System.out.print("Informe o valor do saque: R$");
		double saque = tec.nextDouble();
		
		switch(opcao) {
		case 1:
			if(Corrente.listaCorrentes.get(indice).getSaldo() >= saque) {
				Corrente.listaCorrentes.get(indice).setSaldo(Corrente.listaCorrentes.get(indice).getSaldo() - saque);
				
			}else {
				System.out.println("Saldo indisponível!");
			}
			break;
		case 2:
			if(Credito.listaCreditos.get(indice).getSaldo() >= saque) {
				Credito.listaCreditos.get(indice).setSaldo(Credito.listaCreditos.get(indice).getSaldo() - saque);				
			}else {
				System.out.println("Saldo indisponível!");
			}
			break;
		case 3:
			if(Poupanca.listaPoupancas.get(indice).getSaldo() >= saque) {
				Poupanca.listaPoupancas.get(indice).setSaldo(Poupanca.listaPoupancas.get(indice).getSaldo() - saque);				
			}else {
				System.out.println("Saldo indisponível!");
				
			}
			break;
		}
		
	}
	
}
