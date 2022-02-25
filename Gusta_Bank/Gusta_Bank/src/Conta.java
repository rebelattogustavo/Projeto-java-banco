import java.util.Scanner;

public class Conta {
	
	
	
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

	public void saque() {
		
	}
	
	public void saldo() {
		
	}
}
