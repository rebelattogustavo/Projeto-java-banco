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
	
	public static void pagamento(int indice, int opcao) {
		System.out.print("Informe o valor do pagamento: R$");
		double pagamento = tec.nextDouble();
		
		switch(opcao) {
		case 1:
			if(Corrente.listaCorrentes.get(indice).getSaldo() + Corrente.listaCorrentes.get(indice).getLimite() >= pagamento) {
				Corrente.listaCorrentes.get(indice).setSaldo(Corrente.listaCorrentes.get(indice).getSaldo() - pagamento);
				System.out.println("Pagamento efetuado!");
			}else {
				System.out.println("Saldo indisponível!");
			}
			break;
		case 2:
			if(Credito.listaCreditos.get(indice).getSaldo() + Credito.listaCreditos.get(indice).getLimite() >= pagamento) {
				Credito.listaCreditos.get(indice).setLimiteVariavel(Credito.listaCreditos.get(indice).getLimiteVariavel() - pagamento);
				System.out.println("Pagamento efetuado!");
			}else {
				System.out.println("Saldo indisponível!");
			}
			break;
		}
		
	}
	public static void deposito(int indice) {
		System.out.print("Informe o valor do depósito: R$");
		double deposito = tec.nextDouble();
		
		Corrente.listaCorrentes.get(indice).setSaldo(Corrente.listaCorrentes.get(indice).getSaldo() + deposito);
	}
	public static void transferencia(int indice) {
		System.out.println("--- MENU TRANSFERÊNCIA ---"
				+ "\n1- Corrente"
				+ "\n2- Poupança");
		int opcao = tec.nextInt();

		System.out.println("Informe o valor da transferência: R$");
		double transferencia = tec.nextDouble();

		System.out.print("Informe o número da conta que será transferido o dinheiro: ");
		int numero = tec.nextInt();
		if(Corrente.listaCorrentes.get(indice).getSaldo() + Corrente.listaCorrentes.get(indice).getLimite() >= transferencia) {
			Corrente.listaCorrentes.get(indice).setSaldo(Corrente.listaCorrentes.get(indice).getSaldo() - transferencia);
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
			System.out.println("SALDO INDISPONÍVEL");
		}
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
