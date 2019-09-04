package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private Connection conexao;
	
	public Connection fazerconexao() {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				
				this.conexao = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/new_schema",
						"root",
						""
						);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.conexao;
	}
	
	public void fecharconexao() {
		try {
			this.conexao.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
