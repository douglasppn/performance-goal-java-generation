package menu;


import java.util.InputMismatchException;
import java.util.Scanner;

import menu.util.Cores;

public class main {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		String opcao = "0";
		boolean loopMenu = true;	
			
		while (loopMenu) {
			
			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "*".repeat(53));
			System.out.println(" ".repeat(21) + "Store" + " ".repeat(27));
			System.out.println("*".repeat(53));
			System.out.println(" ".repeat(12) + "1 - Listar todos os produtos" + " ".repeat(13));
			System.out.println(" ".repeat(12) + "2 - Procurar por ID do produto" + " ".repeat(11));
			System.out.println(" ".repeat(12) + "3 - Cadastrar produto" + " ".repeat(20));
			System.out.println(" ".repeat(12) + "4 - Atualizar produto" + " ".repeat(20));
			System.out.println(" ".repeat(12) + "5 - Deletar produto" + " ".repeat(22));
			System.out.println(" ".repeat(12) + "6 - Sair" + " ".repeat(33));
			System.out.println(" ".repeat(53));
			System.out.println("*".repeat(53));
			System.out.println("Entre com a opção desejada:" + " ".repeat(26));
			System.out.println(" ".repeat(53) + Cores.TEXT_RESET);
			
			try {
				
				opcao = leia.nextLine();
				
			} catch(InputMismatchException e){
				
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = "0";
			}
			
			switch (opcao) {
			case "1":
				System.out.println(Cores.TEXT_WHITE + "Listar todos os produtos\n\n");
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "2":
				System.out.println(Cores.TEXT_WHITE + "Procurar por ID do produto\n\n");
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "3":
				System.out.println(Cores.TEXT_WHITE + "Cadastrar produto\n\n");
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "4":
				System.out.println(Cores.TEXT_WHITE + "Atualizar produto\n\n");
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "5":
				System.out.println(Cores.TEXT_WHITE + "Deletar produto\n\n");
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "6":
				System.out.println("\nVIEIRA STORE - O melhor de seus produtos está aqui!\n");
				System.out.println("Programa finalizado!");
				sobre();
	            leia.close();
				System.exit(0);
				break;
				
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nPor favor, digite uma opção válida!\n" + Cores.TEXT_RESET);
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
			}
			
		}
			
	}
	
	public static void sobre() {
		
		System.out.println("*".repeat(53));
		System.out.println("Projeto Desenvolvido por: Douglas Papani Cardoso");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/douglasppn/performance-goal-java-generation");
		System.out.println("*".repeat(53));
			
	}
		
	public static boolean continueMenu (String continuar) {

		if (continuar.equalsIgnoreCase("S")) {
			return continuar.equalsIgnoreCase("S");
		} else {
			System.out.println("Programa finalizado!");
			return false;
		}		
				
	}

}