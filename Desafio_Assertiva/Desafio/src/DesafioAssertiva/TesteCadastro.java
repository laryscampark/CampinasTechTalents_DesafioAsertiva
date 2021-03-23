package DesafioAssertiva;


import org.junit.Assert;
import org.junit.Test;

public class TesteCadastro {
	
	Cliente cli = new Cliente();
			
		@Test 
		public void atualizar () {
			Assert.assertEquals("Laryssa Peçanha de Oliveira Barreto da Silva",cli.getNome());
			Assert.assertEquals("laryssascampark@gmail.com",cli.getLogin());
			Assert.assertEquals("1997",cli.getSenha());
			
		}
		
		
		
	
	}
	
	
/*
 * 
 */
