package DesafioAssertiva;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cria_Cliente {
	
	public static void main (String [] args) {
		
		int i = 1;
		
		int senha, op ,id;
		
		String nome, login;
		
		Cliente cli = new Cliente ();
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println("Cadastro do cliente");
			
		  while (i == 1) {
			  
			System.out.println("\nDigite: \n1-Cadastrar\n2-Consultar\n3-Atualizar\n4-Excluir\n");
	        op = ler.nextInt();
	        
	        switch (op) {
	        
	        case 1: 
	        	
	        	System.out.println("Nome: ");
				nome = ler.nextLine();
				cli.setNome(nome);
				
				System.out.println("Login: ");
				login = ler.nextLine();
				cli.setLogin(login);
				
				System.out.println("Senha: ");
				senha = ler.nextInt();
				cli.setSenha(senha);
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				System.out.println(dateFormat.format(date));
				cli.setData(dateFormat.format(date));
				
				cli.inserir();
	        	
				break;
				
	        case 2:
	        	
	        	System.out.println("Informe o id: ");
	        	id = ler.nextInt();
				cli.setId(id);
				
				cli.consultar();
				
				System.out.println("Nome: "+cli.getNome());
	            System.out.println("Login: "+cli.getLogin());
	            System.out.println("Senha: "+cli.getSenha());
	            System.out.println("Data : "+cli.getData());
	            
	            break;
	            
	        case 3: 
	        	
	        	System.out.println("Digite o ID que deseja atualizar os dados");
				id = ler.nextInt();
				cli.setId(id);
	        	
	        	System.out.println("Informe o nome: ");
	        	nome = ler.next();
				cli.setNome(nome);
				ler.nextLine();
				
				System.out.println("Login: ");
				login = ler.next();
				cli.setLogin(login);
				ler.nextLine();
					
				System.out.println("Senha: ");
				senha = ler.nextInt();
				cli.setSenha(senha);
				
				System.out.println(nome);
					
				cli.atualizar(nome, login, senha, id);
				
			
				break;
				
				
	        case 4: 
	        	
	        	System.out.println("\nEntre com o Id : ");
		 	       id = ler.nextInt();
		 	       cli.setId(id);
		 	       cli.excluir();
		 	       
		   default:
			   
			   System.out.println("Opção inválida");     
	        	
	        }
	        
	        System.out.println("\nDigite:\n1-Continuar\n2-Sair\n");
	        i = ler.nextInt();
		}
		  System.out.println("Obrigado pelo cadastro, saindo do sistema.");
		  ler.close();
		
	}
	
}


