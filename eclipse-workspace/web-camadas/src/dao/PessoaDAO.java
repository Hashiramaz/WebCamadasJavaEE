package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import model.Pessoa;


public class PessoaDAO implements PessoaInDAO {

	private Connection conexao = null;
	
	public PessoaDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		String SQL = "insert into pessoa (nome, email, tel) values (?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		
		ps.execute();
		
	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, email, tel from pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			
			Pessoa p = new Pessoa(id, nome, email, telefone);
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
			
			pessoas.add(p);
			
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM pessoa WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1,_id);
		return ps.execute();
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		String SQL = "UPDATE pessoa SET nome = ?, email = ?, telefone = ? WHERE id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		// TODO Auto-generated method stub
		ps.setInt(4, _objeto.getId());
		
		return ps.execute();
		
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;		
		Pessoa p = null;
		String SQL = "select id, nome, email, tel from pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String telefone = rs.getString(4);
			
			
			p = new Pessoa(id, nome, email, telefone);
			
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setEmail(rs.getString(3));
			
		
			
		}
		
		return p;
		// TODO Auto-generated method stub
		  
	}

}
