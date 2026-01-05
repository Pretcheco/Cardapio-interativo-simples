package listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuInterativo {

	static Scanner scr = new Scanner(System.in);

	public static void main(String[] args) {
		
		String senhaAdm = "peixe123";
		
		ArrayList<String> cardapio = new ArrayList<>(Arrays.asList(
				"Frango à milanesa", "Peixe frito", "Bife à cavalo", "Sopa",
				"Camarao ao molho", "Salada"
				));
		
		boolean encerrar = false;
		
		escrever("CARDAPIO DIGITAL", 200);
		
		while(encerrar != true) {
			escrever("----------------------------------", 10);
			
			escrever("1. Mostrar Menu\n2. Adcionar Item\n3. Remover Item\n4. Alterar Item\n5. "
					+ "Excluir Cardapio\n6. Fechar", 30);
			
			escrever("Qual opcão deseja usar?", 50);
			int op = scr.nextInt();
			
			scr.nextLine();
			
			switch(op) {
			case 1: mostrarMenu(cardapio); break;
			case 2: addItem(cardapio); break;
			case 3: removerItem(cardapio); break;
			case 4: alterarItem(cardapio); break;
			case 5: excluirCardapio(cardapio, senhaAdm); break;
			case 6: escrever("Fechando menu digital...", 50); encerrar = true; break;
			default: escrever("Digito invalido, tente de novo", 50); break;
			}
			escrever("----------------------------------", 10);
		}
		
		scr.close();
		
	}
	
	//opcoes menu
	
	static void mostrarMenu(ArrayList<String> c) {
		
		int contagem = 1;
		
		System.out.println("-------------------------------");
		escrever("Menu: ", 60);
		for(String l : c) {
			escrever("Item "+contagem+"° : "+l, 20);
			contagem++;
		}
		
		System.out.println("--------------------------------");
	}
	
	static void addItem(ArrayList<String> c) {
		while(true) {
		escrever("Digite o item que deseja adcionar", 50);
		String acrescimo = scr.nextLine();
		
		escrever(acrescimo+" vai ser adcionado ao cardapio", 50);
		
		boolean v = verifica();
		
		if(v == true) {
			c.add(acrescimo);
			break;
		}else {
			continue;
		}
		}
	}
	
	static void removerItem(ArrayList<String> c) {
		
		mostrarMenu(c);
		
		while(true) {
		
			escrever("Qual dos itens deseja remover? Digite o numero", 50);
			int remover = scr.nextInt();
			
			scr.nextLine();
			
			escrever(c.get(remover-1)+" vai ser removido do cardapio", 50 );
			
			boolean v = verifica();
			
			if(v == true) {	
				c.remove(remover - 1);
				break;
			}else {
				continue;
			}
			
		}
	}
	
	static void alterarItem(ArrayList<String> c) {
		mostrarMenu(c);
		
		while(true) {
			escrever("Deseja alterar qual numero? Digite o numero", 50);
			int alterar = scr.nextInt();
			
			scr.nextLine();
			
			escrever("Voce vai alterar o "+c.get(alterar - 1), 50);
			
			escrever("Deseja alterar para o que? : ", 50);
			String novo = scr.nextLine();
			
			if(novo != null) {
			
				boolean v = verifica();
				
				if(v == true) {
					c.remove(alterar - 1);
					
					c.add(alterar - 1, novo);
					
					break;
				}else {
					continue;
				}
			}
		}
	}
	
	static void excluirCardapio(ArrayList<String> c, String senha) {
		
		while(true) {
			
			boolean excluir = verificaExclusao(senha);
			
			
			if(excluir == true) {
				escrever("Excluindo cardapio...", 60);
				
				c.removeAll(c);
				
				break;
			}else {
				continue;
			}
		}
		
	}
	
	// metodos auxiliares
	
	static boolean verifica() {
		escrever("Confirma?", 50);
		String verifica2 = scr.nextLine();

		boolean retorno;
		
		while(true) {
		
		if(verifica2.equalsIgnoreCase("sim")) {
			retorno = true;
			break;
		}
		if(verifica2.equalsIgnoreCase("Nao")){
			retorno = false;
			break;
		}
			escrever("ERRO: DIGITO INVALIDO", 50);
		}
		return retorno;
	}
	
	static boolean verificaExclusao(String senha) {
		boolean confirmar = false, encerrar = false;		
		int tentativa = 0;
		
		escrever("Você vai excluir permanentemente o cardapio", 60);
		
		while(encerrar != true || tentativa <= 3) {
			escrever("Insira sua senha para prosseguir, 0 para desistir da operacao", 60);
			String senhaUser = scr.nextLine();
			
			if(senhaUser.equals("0")) {
				break;
			}
			
			if(senhaUser.equals(senha)) {
				escrever("Senha correta, voce deseja mesmo excluir o cardapio?", 60);
				String confirma = scr.nextLine();
					if(confirma.equals("sim")) {
						confirmar = true;
						break;
					}else {
						continue;
					}
			}else {
				escrever("senha incorreta", 60);
				tentativa++;
				escrever("Tentativa : "+tentativa, 60);
			}
		}
		return confirmar;
	}
	
	static void escrever(String p, int velocidade) {
		for(int i = 0; i < p.length(); i++) {
			
			System.out.print(p.charAt(i));
				try {
					Thread.sleep(velocidade);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println();
	}
	
	
}

