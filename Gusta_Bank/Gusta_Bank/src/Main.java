import java.util.Scanner;

public class Main {

	static Scanner tec = new Scanner(System.in);

	public static void main(String[] args) {
		menuPrincipal();

	}

	public static void menuPrincipal() {

		System.out.println("---- MENU PRINCIPAL ----" 
				+ "\n1- Gerência" 
				+ "\n2- Usuário"
				+ "\n3- Fechar");
		int opcao = tec.nextInt();

		switch (opcao) {
		case 1:
			menuGerencia();

			break;
		case 2:
			menuUsuario();
			break;
		case 3: 
			System.exit(0);
			break;
		default:
			System.out.println("Anta! É de 1 a 3 pô.");
			menuPrincipal();
		}
	}


	public static void menuGerencia() {
		int opcao;

		System.out.println("---- MENU GERENCIA ----" 
				+ "\n1- Cadastrar Conta" 
				+ "\n2- Bloquar Conta" 
				+ "\n3 - Listar Contas"
				+ "\n4- Voltar");
		opcao = tec.nextInt();
		switch (opcao) {
		case 1:
			menuCadastro();
			break;
		case 2:
			menuBloqueio();
			break;

		case 3:
			menuListar();
			break;
		case 4:
			menuPrincipal();
			break;
		default:
			System.out.println("Anta! É de 1 à 4 pô.");
			menuGerencia();
		}
	}
	
	public static void menuCadastro() {
		System.out.println("---- MENU CADASTRO ----" + 
				"\n1- Corrente" 
				+ "\n2- Crédito" 
				+ "\n3- Poupança"
				+ "\n4- Voltar");
		int opcao = tec.nextInt();
		if(opcao > 0 && opcao < 4) {
			cadastrar(opcao);
		}else if(opcao == 4){
			menuGerencia();
		}else {
			System.out.println("Anta! É de 1 a 4 pô.");
			menuCadastro();
		}
	}
	
	public static void cadastrar(int opcao) {		
		
		System.out.println("Número da conta: ");
		int numero = tec.nextInt();
		System.out.println("Titular: ");
		String titular = tec.next();
		System.out.println("Senha: ");
		String senha = tec.next();
		
		boolean status = true;
		double saldo = 0.0;
		switch(opcao) {
		case 1:
			System.out.println("Limite: ");
			double limite = tec.nextDouble();
			Corrente correnteTemp = new Corrente(saldo, titular, senha, numero, status, limite);
			Corrente.listaCorrentes.add(correnteTemp);
			break;
		case 2:
			System.out.println("Limite: ");
			limite = tec.nextDouble();	
			System.out.print("Data de fatura: ");
			int dataFatura = tec.nextInt();
			Credito credito = new Credito(saldo, titular, senha, numero, status, limite, dataFatura);
			Credito.listaCreditos.add(credito);
			break;
		case 3:
			System.out.println("Rendimento: ");
			double rendimento = tec.nextDouble();
			Poupanca poupancaTemp = new Poupanca(saldo, titular, senha, numero, status, rendimento);
			Poupanca.listaPoupancas.add(poupancaTemp);
			break;
		}
		System.out.println("Cadastro realizado com sucesso!");
		menuCadastro();
	}

	
	public static void menuBloqueio(){
		System.out.println("---- MENU BLOQUEIO ----" 
				+ "\n1- Corrente" 
				+ "\n2- Crédito" 
				+ "\n3- Poupança"
				+ "\n4- Voltar");
		int opcao = tec.nextInt();
		if(opcao > 0 && opcao < 4) {
			System.out.print("Informe o número da conta a ser bloquada: ");
			int conta = tec.nextInt();
			cancelar(opcao, conta);
		}else if(opcao == 4){
			menuGerencia();
		}else {
			System.out.println("Anta! É de 1 a 4 pô.");
			menuBloqueio();
		}
		System.out.println("Conta cancelada com sucesso!");
		menuBloqueio();
	}
	
	private static void cancelar(int opcao, int conta) {
		switch(opcao) {
		case 1:
			Corrente.listaCorrentes.get(conta).setStatus(false);
			break;
		case 2:
			Credito.listaCreditos.get(conta).setStatus(false);
			break;
		case 3:
			Poupanca.listaPoupancas.get(conta).setStatus(false);
			break;
		}
		
	}

	private static void menuListar() {
		System.out.println("---- MENU LISTAR ----" 
				+ "\n1- Corrente" 
				+ "\n2- Crédito" 
				+ "\n3- Poupança"
				+ "\n4- Voltar");
		int opcao = tec.nextInt();
		if(opcao > 0 && opcao < 4) {
			listar(opcao);
		}else if(opcao == 4){
			menuGerencia();
		}else {
			System.out.println("Anta! É de 1 a 4 pô.");
			menuListar();
		}
	}
	

	private static void listar(int opcao) {
		switch(opcao) {
		case 1:
			for(int i =0; i < Corrente.listaCorrentes.size(); i++) {
				System.out.println(Corrente.listaCorrentes.get(i).toString()); 
				if(i+1 != Corrente.listaCorrentes.size()) {
					System.out.println("--------------------------");
				}
			}
		break;
		case 2:
			for(int i =0; i < Credito.listaCreditos.size(); i++) {
				System.out.println(Credito.listaCreditos.get(i).toString());
				if(i+1 != Credito.listaCreditos.size()) {
					System.out.println("--------------------------");
				}
			}
			break;
		case 3:
			for(int i =0; i < Poupanca.listaPoupancas.size(); i++) {
				System.out.println(Poupanca.listaPoupancas.get(i).toString());
				if(i+1 != Poupanca.listaPoupancas.size()) {
					System.out.println("--------------------------");
				}
			}
			break;
		}
		menuListar();
	}


	private static void menuUsuario() {
		System.out.println("--- MENU USUÁRIO ---"
				+ "\n1- Corrente"
				+ "\n2- Crédito"
				+ "\n3- Poupança"
				+ "\n4- Voltar");
		int opcao = tec.nextInt();
		switch(opcao) {
		case 1:
			menuUsuarioCorrente(opcao);
			break;
		case 2:
			menuUsuarioCredito();
			break;
		case 3:
			menuUsuarioPoupanca();
			break;
		}
	}
			
		
		
	


	private static void menuUsuarioCorrente(int opcao) {
		System.out.print("Informe o número da conta: ");
		int conta = tec.nextInt();
		
		for(int i =0; i < Corrente.listaCorrentes.size();i++) {
			if(Corrente.listaCorrentes.get(i).getNumero() == conta) {
				menuCorrente();
			}
		}
		
		
	}
	
	private static void menuCorrente() {
		System.out.println("--- MENU CORRENTE ---"
				+ "\n1- Saque"
				+ "\n2- Saldo"
				+ "\n3- Pagamento"
				+ "\n4- Depósito"
				+ "\n5- Transferência"
				+ "\n6- Voltar");
		
	}

	private static void menuUsuarioPoupanca() {
		// TODO Auto-generated method stub
		
	}
	
	private static void menuUsuarioCredito() {
		// TODO Auto-generated method stub
		
	}
}