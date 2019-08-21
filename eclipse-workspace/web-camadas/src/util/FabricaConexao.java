package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private Connection conexao;
	
	public Connection fazerconexao() {
		try {
				Class.forName("org.postgresql.Driver");
				
				this.conexao = DriverManager.getConnection(
						"jdbc:postgresql://localhost",
						"postgres",
						"root"
						);
		}
		
	}
	
	public void fecharconexao() {
		try {
			this.conexao.close();
		}
	}

}
