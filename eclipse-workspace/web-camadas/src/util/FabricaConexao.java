package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private Connection conexao;
	
	public Connection fazerconexao() {
		try {
				Class.forName("com.mysql.jdbc.Driver");
				
				this.conexao = DriverManager.getConnection(
						"jdbc:postgresql://localhost:3306/web_cam_20182",
						"postgres",
						"root"
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
