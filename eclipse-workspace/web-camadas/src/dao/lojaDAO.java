package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.console;
import model.loja;

public class lojaDAO implements lojaInDAO{
	

	private Connection conexao = null;
	
	public lojaDAO(Connection _conn) {
		this.conexao = _conn;
	}
	

	@Override
	public void Inserir(loja _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "insert into loja (id,nome,site) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getSite());		
		
		
		
		ps.execute();
		
	}

	@Override
	public List<loja> listarTodos() throws SQLException {
		// 		// TODO Auto-generated method stub
		List<loja> lojas= new ArrayList<loja>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, site from console";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String site= rs.getString(3);
	
			
			
			
			loja c = new loja(id, nome, site);
			
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			
			
			lojas.add(c);
			
		}
		
		return lojas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM lojas  WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_id);
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(loja _objeto) throws SQLException {
		String SQL = "UPDATE jogo SET nome = ?, site = ? WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getSite());		
		
		// TODO Auto-generated method stub

		
		return ps.execute();
	}

	@Override
	public loja buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;		
		loja j = null;
		String SQL = "select id, nome, site from console WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String site= rs.getString(3);
	
			

			
			 j = new loja(id, nome, site );
			
			j.setId(rs.getInt(1));
			j.setNome(rs.getString(2));
			j.setSite(rs.getString(3));
			
			
		
			
		}
		
		return j;
	}

}
