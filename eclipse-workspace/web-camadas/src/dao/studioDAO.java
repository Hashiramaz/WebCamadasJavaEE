package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.console;
import model.studio;

public class studioDAO implements studioInDAO{
	
	private Connection conexao = null;
	
	public studioDAO(Connection _conn) {
		this.conexao = _conn;
	}
	

	@Override
	public void Inserir(studio _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "insert into studio (id,nome, pais) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getPais());		
		
		
		
		ps.execute();
		
		
	}

	@Override
	public List<studio> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		List<studio> studios= new ArrayList<studio>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, pais from console";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String pais= rs.getString(3);
	
			
			
			
			studio c = new studio(id, nome, pais);
			
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setPais(rs.getString(3));
			
			
			studios.add(c);
			
		}
		
		return studios;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "DELETE FROM studio  WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_id);
		return ps.execute();
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean Atualizar(studio _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "UPDATE studio SET nome = ?, pais  = ? WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getPais());		
		
		// TODO Auto-generated method stub

		
		return ps.execute();
	}

	@Override
	public studio buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;		
		studio j = null;
		String SQL = "select id, nome, pais from studioWHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String pais= rs.getString(3);
	
			

			
			 j = new studio(id, nome, pais );
			
			j.setId(rs.getInt(1));
			j.setNome(rs.getString(2));
			j.setPais(rs.getString(3));
			
			
		
			
		}
		
		return j;
	}

}
