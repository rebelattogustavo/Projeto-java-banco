import java.util.ArrayList;

public class Poupanca extends Conta {
	
	private double rendimento;

	static ArrayList<Poupanca> listaPoupanca = new ArrayList<Poupanca>();
	


	@Override
	public String toString() {
		return super.toString() + "\nRendimento: " + rendimento;
	}
	
	

	public Poupanca(double saldo, String titular, String senha, boolean status, int numero, double rendimento) {
		super(saldo, titular, senha, status, numero);
		this.rendimento = rendimento;
	}



	public Poupanca() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static void deposito(int indice) {
		System.out.print("Digite o valor do depósito: ");
		double valorDeposito = sc.nextDouble();
		double saldoAntigo = listaPoupanca.get(indice).getSaldo();
		listaPoupanca.get(indice).setSaldo(listaPoupanca.get(indice).getSaldo() + valorDeposito);

		System.out.println("Saldo antigo: " + saldoAntigo);
		System.out.println("Saldo atual: " + listaPoupanca.get(indice).getSaldo());
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
				if(Corrente.listaCorrente.get(iCorrente).getSaldo() > valorTrans){
					Corrente.listaCorrente.get(iCorrente).setSaldo(Corrente.listaCorrente.get(iCorrente).getSaldo() + valorTrans);
					foundAcc = 1;
				} else {
					System.out.print("Você não possui saldo suficiente para realiar esta transferência!");
				}

				if(foundAcc ==  0){
					System.out.println("\nConta corrente não encontrada.");
					transferencia(tipoConta, indice);
				} else {
					listaPoupanca.get(indice).setSaldo(listaPoupanca.get(indice).getSaldo() - valorTrans);
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
					listaPoupanca.get(indice).setSaldo(listaPoupanca.get(indice).getSaldo() - valorTrans);
				}
				break;
			default:
				break;
		};
	}
	}



//	Getters and Setters
	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}



}
