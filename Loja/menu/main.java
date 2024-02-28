package menu;


import java.util.InputMismatchException;
import java.util.Scanner;

import menu.model.*;
import menu.controller.MenuController;
import menu.util.Cores;

public class main {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		
		MenuController produtos = new MenuController();
		
		int tipo, tecido, garantiaMeses, numero;
		float preco, peso;
		String opcao = "0";
		boolean loopMenu = true;	
		
		Roupas r1 = new Roupas(produtos.gerarNumero(), 18f, 2f, 1, 1);
		produtos.cadastrar(r1);
		
		Roupas r2 = new Roupas(produtos.gerarNumero(), 18f, 1f, 2, 2);
		produtos.cadastrar(r2);
		
		Eletronicos e1 = new Eletronicos(produtos.gerarNumero(), 18f, 50f, 1, 1);
		produtos.cadastrar(e1);
		
		Eletronicos e2 = new Eletronicos(produtos.gerarNumero(), 18f, 50f, 1, 2);
		produtos.cadastrar(e2);
			
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
				
				produtos.listarProdutos();
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "2":
				System.out.println(Cores.TEXT_WHITE + "Procurar por ID do produto\n\n");
				numero = leia.nextInt();
				leia.nextLine();
				
				produtos.procurarID(numero);
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "3":
				System.out.println(Cores.TEXT_WHITE + "Cadastrar produto\n\n");
				
				System.out.println("Digite o preço: ");
				preco = leia.nextFloat();
				
				leia.nextLine(); // Consumir a nova linha pendente
				
				System.out.println("Digite o peso do produto: ");
				leia.skip("\\R?"); //não permite pular a inserção de peso para o usuário
				peso = leia.nextFloat();
				
				do {
					System.out.println("Digite o Tipo de produto: \n");
					System.out.println("1-Roupa");
					System.out.println("2-Produtos Eletronicos\n");
					tipo = leia.nextInt();
					leia.nextLine(); // Consumir a nova linha pendente
					
					if (tipo != 1 && tipo != 2) {
						System.out.println(Cores.TEXT_RED_BOLD + "\nPor favor, digite uma opção válida!\n" + Cores.TEXT_RESET);
					} else {
						
					}
					
				}while(tipo != 1 && tipo != 2);
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o tipo de tecido da roupa: ");
					tecido = leia.nextInt();
					leia.nextLine(); // Consumir a nova linha pendente
					produtos.cadastrar(new Roupas(produtos.gerarNumero(), preco, peso, tipo, tecido));
					}
				case 2 -> {
					System.out.println("Digite o garantia em meses: ");
					garantiaMeses = leia.nextInt();
					leia.nextLine(); // Consumir a nova linha pendente
					produtos.cadastrar(new Eletronicos(produtos.gerarNumero(), preco, peso, tipo, garantiaMeses));
					}

				}
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "4":
				System.out.println(Cores.TEXT_WHITE + "Atualizar produto\n\n");
				
				System.out.println("Digite o ID do produto: ");
				numero = leia.nextInt();
				leia.nextLine();
				
				var buscaConta = produtos.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o preço: ");
					preco = leia.nextFloat();
					
					leia.nextLine(); // Consumir a nova linha pendente
					
					System.out.println("Digite o peso do produto: ");
					leia.skip("\\R?"); //não permite pular a inserção de peso para o usuário
					peso = leia.nextFloat();
					
					switch (tipo) {
					
						case 1 -> {
							System.out.println("Digite o tipo de tecido da roupa: ");
							tecido = leia.nextInt();
							leia.nextLine();
							
							produtos.atualizar(new Roupas(numero, preco, peso, tipo, tecido));
							
						}
						
						case 2 -> {
							System.out.println("Digite o garantia em meses: ");
							garantiaMeses = leia.nextInt();
							leia.nextLine();
							
							produtos.atualizar(new Eletronicos(numero, preco, peso, tipo, garantiaMeses));
							
						}
						default -> {
							System.out.println("Tipo de produto inválido!");
						}
					}
				} else {
					System.out.println("O produto não foi encontrada!");
				}
				
				System.out.println("Deseja continuar? (S/N) ");
				loopMenu = continueMenu(leia.nextLine());
				break;
				
			case "5":
				System.out.println(Cores.TEXT_WHITE + "Deletar produto\n\n");
				
				System.out.println("Digite o ID do produto: ");
				numero = leia.nextInt();
				leia.nextLine();
				
				produtos.deletar(numero);
				
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