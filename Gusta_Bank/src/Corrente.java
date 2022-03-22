
import java.util.ArrayList;
import java.util.Scanner;

public class Corrente extends Conta {
	
	static ArrayList<Corrente> listaCorrente = new ArrayList<Corrente>();
	
	private double limite;
	
	public double getLimite() {
		return limite;
	}



	public void setLimite(double limite) {
		this.limite = limite;
	}
	



	@Override
	public String toString() {
		return super.toString() + "\nLimite: " + limite;
	}



	public Corrente(double saldo, String titular, String senha, boolean status,
			int numero, double limite) {
		super(saldo, titular, senha, status, numero);
		this.limite = limite;
	}



	public Corrente() {
		super();
		// TODO Auto-generated constructor stub
	}




	public static void pagamento() {
		
	}

	public static void deposito(int indice) {
		System.out.print("Digite o valor do depósito: ");
		double valorDeposito = sc.nextDouble();
		double saldoAntigo = listaCorrente.get(indice).getSaldo();
		listaCorrente.get(indice).setSaldo(listaCorrente.get(indice).getSaldo() + valorDeposito);

		System.out.println("Saldo antigo: " + saldoAntigo);
		System.out.println("Saldo atual: " + listaCorrente.get(indice).getSaldo());
	}
	
	public static void transferencia(int tipoConta, int indice) {
		System.out.print("""
								
		Informe o tipo da conta que deseja fazer a transferência
		1 - Corrente;
		2 - Poupança;
		3 - Voltar.
		Digite aqui:\s""");
		int contaTrans = sc.nextInt();
		if(contaTrans != 3){

		System.out.print("\nDigite a conta do favorecido: ");
		int numContaFav = sc.nextInt();

		System.out.print("\nDigite o valor da transferência: R$ ");
		double valorTrans = sc.nextDouble();

		int foundAcc = 0;

		switch(contaTrans){
			case 1:
				int iCorrente = Conta.acharConta(contaTrans, numContaFav);
					if(listaCorrente.get(iCorrente).getSaldo() > valorTrans){
						listaCorrente.get(iCorrente).setSaldo(listaCorrente.get(iCorrente).getSaldo() + valorTrans);
					foundAcc = 1;
					} else {
						System.out.print("Você não possui saldo suficiente para realiar esta transferência!");
					}

				if(foundAcc ==  0){
					System.out.println("\nConta corrente não encontrada.");
					transferencia(tipoConta, indice);
				} else {
					listaCorrente.get(indice).setSaldo(listaCorrente.get(indice).getSaldo() - valorTrans);
				}
				break;
			case 2:
				int iPoupanca = Conta.acharConta(contaTrans, numContaFav);
				if(Poupanca.listaPoupanca.get(iPoupanca).getSaldo() > valorTrans){
					Poupanca.listaPoupanca.get(iPoupanca).setSaldo(Poupanca.listaPoupanca.get(iPoupanca).getSaldo() + valorTrans);
					foundAcc = 1;
				} else {
					System.out.print("Você não possui saldo suficiente para realiar esta transferência!");
				}

				if(foundAcc ==  0){
					System.out.println("\nConta corrente não encontrada.");
					transferencia(tipoConta, indice);
				} else {
					listaCorrente.get(indice).setSaldo(listaCorrente.get(indice).getSaldo() - valorTrans);
				}
				break;
			default:
			break;
			};
		}
		}

	
	
}
