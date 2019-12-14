package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.console;
import model.jogo;

public class consoleDAO implements consoleInDAO{
	
	private Connection conexao = null;
	
	public consoleDAO(Connection _conn) {
		this.conexao = _conn;
	}
	

	@Override
	public void Inserir(console _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "insert into console (id,nome, empresa) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getEmpresa());		
		
		
		
		ps.execute();
		
	}

	@Override
	public List<console> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		List<console> consoles= new ArrayList<console>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, empresa from console";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String empresa= rs.getString(3);
	
			
			
			
			console c = new console(id, nome, empresa);
			
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			
			
			consoles.add(c);
			
		}
		
		return consoles;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "DELETE FROM console  WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_id);
		return ps.execute();
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean Atualizar(console _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "UPDATE console SET nome = ?, empresa  = ? WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getEmpresa());		
		
		// TODO Auto-generated method stub

		
		return ps.execute();
	}

	@Override
	public console buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;		
		console j = null;
		String SQL = "select id, nome, empresa from console WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String empresa= rs.getString(3);
	
			

			
			 j = new console(id, nome, empresa );
			
			j.setId(rs.getInt(1));
			j.setNome(rs.getString(2));
			j.setEmpresa(rs.getString(3));
			
			
		
			
		}
		
		return j;
	}


}
