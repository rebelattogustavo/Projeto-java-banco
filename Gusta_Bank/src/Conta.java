import java.util.Scanner;

public class Conta {
	static Scanner sc = new Scanner(System.in);
//	Scanner sc = new Scanner(System.in);
	
//	ArrayList<Conta> contas = new ArrayList<Conta>();
	
	private double saldo;
	private String titular, senha;
	private boolean status;
	private int numero;


	public Conta(double saldo, String titular, String senha, boolean status, int numero) {
		super();
		this.saldo = saldo;
		this.titular = titular;
		this.senha = senha;
		this.status = status;
		this.numero = numero;
	}


	
	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "\nTitular: " + titular + "\nNúmero: " + numero + "\nSenha: " + senha + "\nStatus: " + status + "\nSaldo: R$ " + saldo;
	}

	public static int acharConta(int tipoConta, int numeroConta){
		switch (tipoConta){
			case 1:
				for(int i = 0; i < Corrente.listaCorrente.size(); i++){
					if(Corrente.listaCorrente.get(i).getNumero() == numeroConta){
						return i;
					}
				}
				break;
			case 2:
				for(int i = 0; i < Credito.listaCredito.size(); i++){
					if(Credito.listaCredito.get(i).getNumero() == numeroConta){
						return i;
					}
				}
				break;
			case 3:
				for(int i = 0; i < Poupanca.listaPoupanca.size(); i++){
					if(Poupanca.listaPoupanca.get(i).getNumero() == numeroConta){
						return i;
					}
				}
				break;
			default:
				System.out.println("\nDigite um número entre 1 e 3.");
				acharConta(tipoConta, numeroConta);
				break;
		}
		return -1;
	};
	
	
	public static void saque(int tipoConta, int i) {
		System.out.print("Qual o valor que desejas sacar?" +
				"\nDigite aqui: ");
		double valorSaque = sc.nextDouble();
		switch(tipoConta){
			case 1:
				if(valorSaque > Corrente.listaCorrente.get(i).getLimite()){
					System.out.println("Seu limite de saque é de: " + Corrente.listaCorrente.get(i).getLimite());
				} else if(valorSaque > Corrente.listaCorrente.get(i).getSaldo()) {
					System.out.println("Você não possui saldo suficiente!" +
							"\nSaldo atual: " + Corrente.listaCorrente.get(i).getSaldo());
				} else {
					Corrente.listaCorrente.get(i).setSaldo(Corrente.listaCorrente.get(i).getSaldo() - valorSaque);
				}
				break;
			case 2:
				if(valorSaque > Credito.listaCredito.get(i).getLimite()){
					System.out.println("Seu limite de saque é de: " + Credito.listaCredito.get(i).getLimite());
				} else if(valorSaque > Credito.listaCredito.get(i).getSaldo()) {
					System.out.println("Você não possui saldo suficiente!" +
							"\nSaldo atual: " + Credito.listaCredito.get(i).getSaldo());
				} else {
					Credito.listaCredito.get(i).setSaldo(Credito.listaCredito.get(i).getSaldo() - valorSaque);
				}
				break;
			case 3:
				if(valorSaque > Poupanca.listaPoupanca.get(i).getSaldo()){
					System.out.print("Você não possui saldo suficiente para o saque!" +
							"\nSaldo atual: " + Poupanca.listaPoupanca.get(i).getSaldo());
				} else {
					Poupanca.listaPoupanca.get(i).setSaldo(Poupanca.listaPoupanca.get(i).getSaldo() - valorSaque);
					System.out.println("Saldo Atual: " + Poupanca.listaPoupanca.get(i).getSaldo());
				}
				break;
		}
	}

//	Buscar o saldo;
	public static void saldo(int tipoConta, int i) {
		System.out.print("Saldo Disponível: ");
		switch(tipoConta){
			case 1:
				System.out.println(Corrente.listaCorrente.get(i).getSaldo());
				break;
			case 2:
				System.out.println(Credito.listaCredito.get(i).getSaldo());
				break;
			case 3:
				System.out.println(Poupanca.listaPoupanca.get(i).getSaldo());
				break;
		}
	}
	
	
//	Getters and Setters
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
