import java.util.Scanner;

public class Main {

	static Scanner tec = new Scanner(System.in);

	public static void main(String[] args) {
		Corrente cc = new Corrente();
		cc.setLimite(300);
		cc.setNumero(123);
		cc.setSenha("321");
		cc.setSaldo(1000);
		Corrente.listaCorrentes.add(cc);
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
			for(int i =0; i < Corrente.listaCorrentes.size(); i++) {
				if(Corrente.listaCorrentes.get(i).getNumero() == conta) {
					Corrente.listaCorrentes.get(i).setStatus(false);
				}
			}
			break;
		case 2:
			for(int i =0; i < Credito.listaCreditos.size(); i++) {
				if(Credito.listaCreditos.get(i).getNumero() == conta) {
					Credito.listaCreditos.get(i).setStatus(false);
				}
			}			break;
		case 3:
			for(int i =0; i < Poupanca.listaPoupancas.size(); i++) {
				if(Poupanca.listaPoupancas.get(i).getNumero() == conta) {
					Poupanca.listaPoupancas.get(i).setStatus(false);
				}
			}			break;
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
				+ "\nInforme o tipo da sua conta: "
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
			menuUsuarioCredito(opcao);
			break;
		case 3:
			menuUsuarioPoupanca(opcao);
			break;
		case 4:
			menuPrincipal();
			break;
		}
	}
			

	private static void menuUsuarioCorrente(int opcao) {
		System.out.print("Informe o número da conta: ");
		int conta = tec.nextInt();

		int valida =0;

		System.out.print("Informe a senha da conta: ");
		String senha = tec.next();
		for(int i =0; i < Corrente.listaCorrentes.size();i++) {
			if(Corrente.listaCorrentes.get(i).getNumero() == conta && Corrente.listaCorrentes.get(i).getSenha().equals(senha)) {
				int indice = i;
				menuCorrente(indice, opcao);
				valida++;
			}
		}
		if(valida == 0){
				System.out.println("Conta inexistente tente novamente!");
				menuUsuarioCorrente(opcao);
		}
	}
	
	private static void menuCorrente(int indice, int opcao) {
		System.out.println("--- MENU CORRENTE ---"
				+ "\nO que você deseja fazer?"
				+ "\n1-Ver saldo"
				+ "\n2- Saque"
				+ "\n3- Pagamento"
				+ "\n4- Depósito"
				+ "\n5- Transferência"
				+ "\n6- Voltar");
		int opcao2 = tec.nextInt();
		switch(opcao2) {
		case 1:
			Conta.verSaldo(indice, opcao);
			menuCorrente(indice, opcao);
			break;
		case 2:
			Conta.saque(indice, opcao);
			menuCorrente(indice, opcao);
			break;
		case 3: 
			Corrente.pagamento(indice, opcao);
			menuCorrente(indice, opcao);
			break;
		case 4:
			Corrente.deposito(indice);
			menuCorrente(indice, opcao);
			break;
		case 5:
			Corrente.transferencia(indice, opcao);
			menuCorrente(indice, opcao);
			break;
		case 6:
			menuUsuario();
			break;
		}
		
	}

	private static void menuUsuarioPoupanca(int opcao) {
		System.out.print("Informe o número da conta: ");
		int conta = tec.nextInt();
		
		System.out.print("Informe a senha da conta: ");
		String senha = tec.next();

		int valida=0;
		for(int i =0; i < Poupanca.listaPoupancas.size();i++) {
			if(Poupanca.listaPoupancas.get(i).getNumero() == conta && Poupanca.listaPoupancas.get(i).getSenha().equals(senha)) {
				int indice = i;
				menuPoupanca(indice, opcao);
				valida++;
			}
		}
		if(valida == 0){
			System.out.println("Conta inexistente tente novamente!");
			menuUsuarioPoupanca(opcao);
		}
	}
	
	private static void menuPoupanca(int indice, int opcao) {
		System.out.println("--- MENU POUPANÇA ---"
				+ "\n1- Ver saldo"
				+ "\n2- Saque"
				+ "\n3- Depósito"
				+ "\n4- Transferência"
				+ "\n5- Voltar");
		int opcao2 = tec.nextInt();
		
		switch(opcao2) {
		case 1:
			Conta.verSaldo(indice, opcao);
			menuPoupanca(indice, opcao);
			break;
		case 2:
			Conta.verSaldo(indice, opcao);
			menuPoupanca(indice, opcao);
			break;
		case 3:
			Conta.saque(indice, opcao);
			menuPoupanca(indice, opcao);
			break;
		case 4:
			Corrente.transferencia(indice, opcao);
			menuPoupanca(indice, opcao);
			break;
		}
	}

	private static void menuUsuarioCredito(int opcao) {
		System.out.print("Informe o número da conta: ");
		int conta = tec.nextInt();

		System.out.print("Informe a senha da conta: ");
		String senha = tec.next();

		int valida=0;
		for(int i =0; i < Credito.listaCreditos.size();i++) {
			if(Credito.listaCreditos.get(i).getNumero() == conta && Credito.listaCreditos.get(i).getSenha().equals(senha)) {
				int indice = i;
				menuCredito(indice, opcao);
				valida++;
			}
		}
		if(valida == 0){
			System.out.println("Conta inexistente tente novamente!");
			menuUsuarioCredito(opcao);
		}
	}

	private static void menuCredito(int indice, int opcao) {
		System.out.println("--- MENU CRÉDITO ---"
				+ "\n1- Ver limite" +
				"\n2- Pagamento"
				+ "\n5- Voltar");
		int opcao2 = tec.nextInt();

		switch(opcao2) {
			case 1:
				System.out.println(Credito.listaCreditos.get(indice).getLimite());
				menuCredito(indice, opcao);
				break;
			case 2:
				Corrente.pagamento(indice, opcao);
				menuCredito(indice, opcao);
				break;
			case 3:
				menuUsuarioCredito(opcao);
				break;
		}
	}

}