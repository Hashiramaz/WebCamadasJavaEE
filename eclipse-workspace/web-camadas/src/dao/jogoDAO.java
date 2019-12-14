package dao;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import model.Pessoa;
import model.jogo;


public class jogoDAO implements jogoInDAO {

	private Connection conexao = null;
	
	public jogoDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(jogo _objeto) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "insert into jogo (id,nome,  data, consola,studio,loja) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getData());		
		ps.setString(4, _objeto.getConsole());
		ps.setString(5, _objeto.getStudio());
		ps.setString(6, _objeto.getLoja());
		
		
		ps.execute();
		
	}

	@Override
	public List<jogo> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		
		List<jogo> jogos = new ArrayList<jogo>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, data, console,studio,loja from jogo";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String data= rs.getString(3);
	
			String console = rs.getString(4);
			String studio = rs.getString(5);
			String loja = rs.getString(6);
			
			
			jogo j = new jogo(id, nome, data, console, studio, loja);
			
			j.setId(rs.getInt(1));
			j.setNome(rs.getString(2));
			j.setData(rs.getString(3));
			j.setConsole(rs.getString(4));
			j.setStudio(rs.getString(5));
			j.setLoja(rs.getString(6));
			
			jogos.add(j);
			
		}
		
		return jogos;
		
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		
		String SQL = "DELETE FROM jogo WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_id);
		return ps.execute();
		// TODO Auto-generated method stub
	
	}

	@Override
	public Boolean Atualizar(jogo _objeto) throws SQLException {
		String SQL = "UPDATE jogo SET nome = ?, email = ?, telefone = ? WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _objeto.getId());
		ps.setString(2, _objeto.getNome());
		ps.setString(3, _objeto.getData());		
		ps.setString(4, _objeto.getConsole());
		ps.setString(5, _objeto.getStudio());
		ps.setString(6, _objeto.getLoja());
		// TODO Auto-generated method stub

		
		return ps.execute();
	}

	@Override
	public jogo buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;		
		jogo j = null;
		String SQL = "select id, nome, data, console,studio,loja from jogo WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String data= rs.getString(3);
	
			String console = rs.getString(4);
			String studio = rs.getString(5);
			String loja = rs.getString(6);

			
			 j = new jogo(id, nome, data, console, studio, loja);
			
			j.setId(rs.getInt(1));
			j.setNome(rs.getString(2));
			j.setData(rs.getString(3));
			j.setConsole(rs.getString(4));
			j.setStudio(rs.getString(5));
			j.setLoja(rs.getString(6));
			
		
			
		}
		
		return j;
	}



}
