package DesafioAssertiva;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Cliente {
	private int id;
	private String nome;
	private String login;
	private int senha;
	private String data;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	Conexao conecta = new Conexao();
	
	public void inserir() {
		
		try {
			conecta.conectar();
			String sql = "insert into ficha (nome, login, senha, data) values (?, ?, ?, ?) ";
			PreparedStatement stm = conecta.con.prepareStatement(sql);
			
			
			stm.setString(1, nome);
			stm.setString(2, login);
			stm.setInt(3, senha);
			stm.setString(4, data);
			
			stm.execute();
			
			System.out.println("Dados cadastrados com sucesso");
			stm.close();
			
		} catch (SQLException erro) {
			System.out.println("Erro não foi possível cadastrar."+erro);
		}
	}
	
	public void consultar () {
		
		try {
			conecta.conectar();
			String sql = "select nome, login, senha, data, id from ficha where id = ?";
			
			PreparedStatement stm = conecta.con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet r = stm.executeQuery();
			
			if (r.next()) {
				this.setNome(r.getString("nome"));
				this.setLogin(r.getString("login"));
				this.setSenha(r.getInt("senha"));
				this.setData(r.getString("data"));
			}
			
			stm.close();
			
		} catch (SQLException erro) {
			System.out.println("Não foi possível encontrar os dados."+erro);
		}
	}
	
	public void atualizar (String nome, String login, int senha, int id) {
		
		System.out.println(nome);
		
		try {
			
			conecta.conectar();
			String sql = ("UPDATE ficha SET nome= '" +nome+"', login= '"+login+"', senha= '"+senha+"' WHERE id=" +id+ ";");
			
			PreparedStatement stm = conecta.con.prepareStatement(sql);
			
			stm.executeUpdate();
			
			System.out.println("Dados atualizados com sucesso.");
			
		} catch (SQLException erro) {
			System.out.println("Erro não foi possivel atualizar os dados."+erro);
		}
	}
	
	public void excluir () {
		
		try {
			
			conecta.conectar();
			String sql = "delete from ficha where id =?";
			
			PreparedStatement stm = conecta.con.prepareStatement(sql);
			
			stm.setInt(1, id);
			stm.execute();
			
			System.out.println("Dados excluidos com sucesso");
			
		} catch (SQLException erro) {
			
			System.out.println("Erro não foi possível excluir os dados."+erro);
		}
	}
}
