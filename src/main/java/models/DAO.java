package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	private String url = "jdbc:mysql://localhost/sistemalogin";
	private String user = "root";
	private String senha = "CARlos799";

	
	private Connection conectar() {
		
		try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 return DriverManager.getConnection(url, user, senha);
			
		} catch (Exception e) {
			System.out.println("Conexão falhou " + e);
			return null;
		}
	}
	
	public void inserirCadastro(Usuario user) {
		String sql = "insert into users (nome, email, senha) values (?, ?, ?)";
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, user.getNome());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getSenha());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	public void buscarUsuario(Usuario user) {
		String sql = "select * from users";
		
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString(2);
				String senha = rs.getString(3);
				
				System.out.println(email);
				System.out.println(senha);
				System.out.println("////////////");
			}
			
		} catch (Exception e) {
			
		}
	}
	
	public boolean buscarSelecionado (Usuario user) {
		String sql = "select * from users where email = ? and senha = ?";
		Boolean retornor = null;
		
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getSenha());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String emailDoBanco = rs.getString("email");
				String senhaDoBanco = rs.getString("senha");
				
				if(user.getEmail().equals(emailDoBanco) && user.getSenha().equals(senhaDoBanco)) {
					retornor = true;
				}
			}
			
			pst.close();
			rs.close();
			conn.close();
			return retornor;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<Usuario> buscarNome (Usuario user) {
		String sql = "select * from users where email = ?";
		ArrayList<Usuario> login = new ArrayList<>();
		
		try {
			Connection conn = conectar();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getEmail());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				 
				login.add(new Usuario(nome, email));
			}
			conn.close();
			return login;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}
