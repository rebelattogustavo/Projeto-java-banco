import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Corrente contaCorr1 = new Corrente();
		contaCorr1.setNumero(123);
		contaCorr1.setLimite(2000);
		contaCorr1.setSenha("123");
		contaCorr1.setTitular("Leozin");
		contaCorr1.setSaldo(1000);
		contaCorr1.setStatus(true);
		Corrente.listaCorrente.add(contaCorr1);

		Poupanca contaPoup1 = new Poupanca();
		contaPoup1.setNumero(321);
		contaPoup1.setSenha("321");
		contaPoup1.setStatus(true);
		contaPoup1.setTitular("Rafaelli");
		contaPoup1.setSaldo(2000);
		contaPoup1.setRendimento(9.3);
		Poupanca.listaPoupanca.add(contaPoup1);

		Credito contaCred1 = new Credito();
		contaCred1.setNumero(456);
		contaCred1.setSenha("456");
		contaCred1.setStatus(true);
		contaCred1.setTitular("Leo Rafaelli");
		contaCred1.setSaldo(5000);
		contaCred1.setDataFatura(892004);
		contaCred1.setLimiteTotal(2000);
		contaCred1.setLimite(contaCred1.getLimiteTotal());
		Credito.listaCredito.add(contaCred1);

		menuPrincipal();
	}

	private static void menuPrincipal() {
		Scanner sc = new Scanner(System.in);

		System.out.print(
					"\n------ MENU PRINCIPAL ------" 
					+ "\n1 - Gerência;" 
					+ "\n2 - Usuário;"
					+ "\n3 - Fechar."
					+ "\nDigite aqui: ");
		int opcao = sc.nextInt();

		switch (opcao) {
			case 1 -> menuGerencia();
			case 2 -> menuUsuário();
			case 3 -> System.exit(0);
			default -> {
				System.out.println("Anta! É de 1 à 3 pô.");
				menuPrincipal();
			}
		}

	}

	
	// CÓDIGOS DE USUÁRIO
	private static void menuUsuário() {
		System.out.print("\n------ MENU USUÁRIO ------"
				+ "\nSelecione o tipo da conta:"
				+ "\n1 - Corrente;" 
				+ "\n2 - Crédito;"
				+ "\n3 - Poupança;"
				+ "\n4 - Voltar;"
				+ "\nDigite aqui: ");
		int opcao = sc.nextInt();
		switch (opcao) {
			case 1:
				entradaContaCorrente(opcao);
				break;
			case 2:
				entradaContaCredito(opcao);
				break;
			case 3:
				entradaContaPoupanca(opcao);
				break;
			case 4:
				menuPrincipal();
				break;
			default:
				System.out.println("Anta! É de 1 à 4 pô.");
				menuGerencia();
				break;
		};
	}

	private static void entradaContaPoupanca(int tipoConta){

		System.out.print("\n------ CONTA POUPANÇA ------" +
				"\nDigite o número da conta (0 - Voltar): ");
		int conta = sc.nextInt();
		if(conta == 0){
			menuUsuário();
		}
		System.out.print("Digite a senha: ");
		String senha = sc.next();

		int iPoup = Conta.acharConta(tipoConta, conta);
		if(iPoup != -1){
			if (Poupanca.listaPoupanca.get(iPoup).getSenha().equals(senha)) {
				menuContaPoupanca(tipoConta, iPoup);
			}
		} else {
		System.out.println("Número ou senha incorretos!");
		}
		entradaContaCredito(tipoConta);
	}

	private static void menuContaPoupanca(int tipoConta, int i){
		System.out.println("""
				------ MENU CONTA POUPANÇA ------
				1 - Depósito;
				2 - Transferência;
				3 - Ver saldo;
				4 - Voltar.
				Digite aqui:\s""");
		int opcao = sc.nextInt();
		switch (opcao){
			case 1:
				Poupanca.deposito(i);
				break;
			case 2:
				Poupanca.transferencia(tipoConta, i);
				break;
			case 3:
				Conta.saldo(tipoConta, i);
				break;
			case 4:
				entradaContaPoupanca(tipoConta);
				break;
			default:
				System.out.println("Digite um número entre 1 e 4.");
				menuContaPoupanca(tipoConta, i);
				break;
		}
	}


	private static void entradaContaCredito(int tipoConta) {
		System.out.print("\n------ CONTA CREDITO ------" +
				"\nDigite o número da conta (0 - Voltar): ");
		int conta = sc.nextInt();
		if(conta == 0){
			menuUsuário();
		}
		System.out.print("Digite a senha: ");
		String senha = sc.next();

		int iCredito = Conta.acharConta(tipoConta, conta);
		if(iCredito != -1){
			if (Credito.listaCredito.get(iCredito).getSenha().equals(senha)) {
				menuContaCredito(tipoConta, iCredito);
			}
		}
		System.out.println("Número ou senha incorretos!");
		entradaContaCredito(tipoConta);
	}

	private static void menuContaCredito(int tipoConta, int i){
		System.out.print("\n----- MINHA CONTA CREDITO ------\n1 - Pagamento;\n2 - Ver saldo;\n3 - Ver limite total;\n4 - Ver limite disponível;" +
				"\n5 - Voltar.\nDigite aqui: ");
		int opcao = sc.nextInt();

		switch (opcao){
			case 1:
				Credito.pagamento(tipoConta, i);
				break;
			case 2:
				Conta.saldo(tipoConta, i);
				break;
			case 3:
				Credito.verLimiteTotal(i);
				break;
			case 4:
				Credito.verLimiteRestante(i);
			case 5:
				entradaContaCredito(tipoConta);
				break;
			default:
				System.out.println("Digite um número entre 1 e 3");
				break;
		}
		menuContaCredito(tipoConta, i);
	}
	
	private static void entradaContaCorrente(int tipoConta) {
		int i, verificar = 0, indice;

		System.out.print("\n------ CONTA CORRENTE ------" +
				"\nDigite o número da conta (0 - Voltar): ");
		int conta = sc.nextInt();
		if(conta == 0){
			menuUsuário();
		}
		System.out.print("Digite a senha: ");
		String senha = sc.next();
			for(i = 0; i < Corrente.listaCorrente.size(); i++) {
				if (Corrente.listaCorrente.get(i).getNumero() == conta) {
					if (Corrente.listaCorrente.get(i).getSenha().equals(senha)) {
						verificar = 1;
						indice = i;
						menuOpcoesCorrente(tipoConta, indice);
					}
				}
			}
		if(verificar != 1){
		System.out.println("Número ou senha incorretos!");
		entradaContaCorrente(tipoConta);
		}
	}
	
	private static void menuOpcoesCorrente(int tipoConta, int indice) {
		System.out.print("""
		
		------ MENU MINHA CONTA CORRENTE ------
		1 - Ver Saldo;
		2 - Saque;
		3 - Depósito;
		4 - Transferência;
		5 - Pagamento;
		6 - Voltar.
		Digite aqui:\s""");
		int opcao = sc.nextInt();
		switch(opcao){
			case 1:
				Conta.saldo(tipoConta, indice);
				menuOpcoesCorrente(tipoConta, indice);
				break;
			case 2:
				Conta.saque(tipoConta, indice);
				menuOpcoesCorrente(tipoConta, indice);
				break;
			case 3:
				Corrente.deposito(indice);
				menuOpcoesCorrente(tipoConta, indice);
				break;
			case 4:
				Corrente.transferencia(tipoConta, indice);
				menuOpcoesCorrente(tipoConta, indice);
				break;
			case 5:
				break;
			case 6:
				entradaContaCorrente(tipoConta);
				break;
			default:
				System.out.println("Por favor, digite um número de 1 à 4");
				menuOpcoesCorrente(tipoConta, indice);
				break;
		}
	};
	
	
	
	
	
	
	
	
	// CÓDIGOS DE GERENCIAMENTO
	private static void menuGerencia() {
		System.out.print("\n------ MENU GERÊNCIA ------" 
							+ "\n1 - Cadastrar Conta;" 
							+ "\n2 - Bloquear Conta;"
							+ "\n3 - Listar Contas;"
							+ "\n4 - Voltar."
							+ "\nDigite aqui: ");
		int opcao = sc.nextInt();
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
			break;
		};
	}
	
	
	
	
	private static void menuCadastro() {
		System.out.print(
				"\n------ MENU CADASTRO ------" 
				+ "\n1 - Corrente;" 
				+ "\n2 - Crédito;"
				+ "\n3 - Poupança;"
				+ "\n4 - Voltar."
				+ "\nDigite aqui: ");
		int opcao = sc.nextInt();
		if (opcao > 0 && opcao < 4) {
			cadastrar(opcao);
		} else if(opcao == 4){
			menuGerencia();
		} else {
			System.out.println("Anta! é de 1 à 4 pô.");
			menuCadastro();
		}
	}
	
	private static void menuBloqueio() {
		System.out.print(
				"\n------ MENU BLOQUEIO ------" 
				+ "\n1 - Corrente;" 
				+ "\n2 - Crédito;"
				+ "\n3 - Poupança"
				+ "\n4 - Voltar"
				+ "\nDigite aqui: ");
		int opcao = sc.nextInt();
		
		System.out.print("Informe o número da conta a ser bloqueada: ");
		int conta = sc.nextInt();
		
		if (opcao > 0 && opcao < 4) {
			cancelar(opcao, conta);
		} else if(opcao == 4){
			menuGerencia();
		} else {
			System.out.println("Anta! é de 1 à 4 pô.");
			menuBloqueio();
		}
	}
	
	public static void cancelar(int opcao, int conta) {
		int i;
		switch(opcao) {
		case 1:
			for(i = 0; i < Corrente.listaCorrente.size(); i++){
				if(Corrente.listaCorrente.get(i).getNumero() == conta) {
					Corrente.listaCorrente.get(i).setStatus(false);
				}
			}
			break;
		case 2:
			for(i = 0; i < Credito.listaCredito.size(); i++){
				if(Credito.listaCredito.get(i).getNumero() == conta) {
					Credito.listaCredito.get(i).setStatus(false);
				}
			}
			break;
		case 3:
			for(i = 0; i < Poupanca.listaPoupanca.size(); i++){
				if(Poupanca.listaPoupanca.get(i).getNumero() == conta) {
					Poupanca.listaPoupanca.get(i).setStatus(false);
				}
			}
			
			break;
		}
		System.out.println("Conta cancelada com sucesso paeee!");
		menuBloqueio();
	}
	
	
	private static void menuListar() {
		System.out.print(
				"\n------ MENU LISTAR ------" 
				+ "\n1 - Corrente;" 
				+ "\n2 - Crédito;"
				+ "\n3 - Poupança;"
				+ "\n4 - Voltar."
				+ "\nDigite aqui: ");
		int opcao = sc.nextInt();
		
		if (opcao > 0 && opcao < 4) {
			listar(opcao);
		} else if(opcao == 4){
			menuGerencia();
		} else {
			System.out.println("Anta! é de 1 à 4 pô.");
			menuListar();
		}
	}
	
	
	
	private static void listar(int opcao) {
		switch(opcao) {
		case 1:
			for(int i = 0; i < Corrente.listaCorrente.size(); i++) {
				System.out.println(Corrente.listaCorrente.get(i).toString());
				if(i+1 != Corrente.listaCorrente.size()) {
					System.out.println("------------------");
				}
			}
			break;
		case 2:
			for(int i = 0; i < Credito.listaCredito.size(); i++) {
				System.out.println(Credito.listaCredito.get(i).toString());
				if(i+1 != Credito.listaCredito.size()) {
					System.out.println("------------------");
				}
			}
			break;
		case 3:
			for(int i = 0; i < Poupanca.listaPoupanca.size(); i++) {
				System.out.println(Poupanca.listaPoupanca.get(i).toString());
				if(i+1 != Poupanca.listaPoupanca.size()) {
					System.out.println("------------------");
				}
			}
		}
		menuListar();
	}
	
	private static void cadastrar(int opcao) {
		
		System.out.print("\nNúmero da conta: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		String titular = sc.next();
		System.out.print("Senha: ");
		String senha = sc.next();
		boolean status = true;
		double saldo = 0.0;
		
		switch(opcao) {
		case 1:
			System.out.print("Limite: ");
			double limite = sc.nextDouble();
			Corrente corrente = new Corrente(saldo, titular, senha, status, numero, limite);
			Corrente.listaCorrente.add(corrente);
			break;
			
		case 2:
			System.out.print("Limite: ");
			limite = sc.nextDouble();
			System.out.print("Limite total: ");
			double limiteTotal = sc.nextDouble();
			System.out.print("Data da fatura: ");
			int dataFatura = sc.nextInt();
			Credito credito = new Credito(saldo, titular, senha, status, numero, limite, limiteTotal, dataFatura);
			Credito.listaCredito.add(credito);
			break;
			
		case 3:
			System.out.println("Rendimento: ");
			double rendimento = sc.nextDouble();
			Poupanca poupança = new Poupanca(saldo, titular, senha, status, numero, rendimento);
			Poupanca.listaPoupanca.add(poupança);
			break;
		}
		System.out.println("Cadastro realizado com sucesso!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		menuCadastro();
	}
	
	
	
	
}
