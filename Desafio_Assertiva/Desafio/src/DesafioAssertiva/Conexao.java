package DesafioAssertiva;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String user;
	private String url;
	private String psw;
	private String driver;
	
	Connection con = null;
	
	public Connection conectar() {
		url = "jdbc:mysql://localhost:3308/cadastro?characterEncoding=utf8&useSSL=false&useUnicode=true";
		user = "root";
		psw = "";
		driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, psw);
			System.out.println("Conectado com sucesso! ");
			
		} catch (ClassNotFoundException Driver) {
			System.out.println("Erro n�o foi poss�vel achar o driver de conex�o."+Driver);
			
		} catch (SQLException erro) {
			System.out.println("Erro n�o foi poss�vel se conectar com o DB."+erro);
		}
		
		return con;
	}
	
	public static void main (String [] args) {
		
		Conexao co = new Conexao();
		co.conectar();
	}
}
