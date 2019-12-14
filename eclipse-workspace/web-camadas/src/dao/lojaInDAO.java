package dao;

import java.sql.SQLException;
import java.util.List;

import model.loja;

public interface lojaInDAO {
	void Inserir(loja _objeto) throws SQLException;
	List<loja> listarTodos () throws SQLException;
	Boolean Excluir (int _id) throws SQLException;
	Boolean Atualizar(loja _objeto) throws SQLException;
	loja buscarPorId(int _id) throws SQLException;

}
