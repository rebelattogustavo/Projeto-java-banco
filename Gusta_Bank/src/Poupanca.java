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

	public static void transferencia(int indice) {
		System.out.println("--- MENU TRANSFERÊNCIA ---"
				+ "\n1- Corrente"
				+ "\n2- Poupança");
		int opcao = tec.nextInt();

		System.out.print("Informe o valor da transferência: R$");
		double transferencia = tec.nextDouble();

		System.out.print("Informe o número da conta que será transferido o dinheiro: ");
		int numero = tec.nextInt();
		if(Poupanca.listaPoupancas.get(indice).getSaldo()  >= transferencia) {
			Poupanca.listaPoupancas.get(indice).setSaldo(Poupanca.listaPoupancas.get(indice).getSaldo() - transferencia);
			switch(opcao) {
				case 1:
					for(int i = 0; i < Corrente.listaCorrentes.size(); i++) {
						if(Corrente.listaCorrentes.get(i).getNumero() == numero){
							if(Corrente.listaCorrentes.get(i).isStatus() == true){
							Corrente.listaCorrentes.get(i).setSaldo(Corrente.listaCorrentes.get(i).getSaldo() + transferencia);
							}else{
								System.out.println("Conta desativada!");
							}
						}else {
							System.out.println("Conta inexistente!");
						}
					}
					break;
				case 2:
					for(int i = 0; i < Poupanca.listaPoupancas.size(); i++) {
						if(Poupanca.listaPoupancas.get(i).getNumero() == numero){
							if(Poupanca.listaPoupancas.get(i).isStatus() == true){
							Poupanca.listaPoupancas.get(i).setSaldo(Poupanca.listaPoupancas.get(i).getSaldo() + transferencia);
							}else{
								System.out.println("Conta desativada!");
							}
						}else {
							System.out.println("Conta inexistente!");
						}
					}
					break;
			}
		}else{
			System.out.println("SALDO INDÍSPONIVEL");
		}
	}

	public static void deposito(int indice) {
		System.out.print("Informe o valor do depósito: R$");
		double deposito = tec.nextDouble();
		Poupanca.listaPoupancas.get(indice).setSaldo(Poupanca.listaPoupancas.get(indice).getSaldo() + deposito);
	}

}
