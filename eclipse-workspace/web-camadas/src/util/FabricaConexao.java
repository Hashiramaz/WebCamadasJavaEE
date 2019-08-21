package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private Connection conexao;
	
	public Connection fazerconexao() {
		try {
				Class.forName("org.postgresql.Driver");
				
				this.conexao = DriverManager.getConnection(
						"jdbc:postgresql://localhost/web_cam_20182",
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
