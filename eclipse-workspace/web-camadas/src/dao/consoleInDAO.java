package dao;

import java.sql.SQLException;
import java.util.List;

import model.console;

public interface consoleInDAO {
	void Inserir(console _objeto) throws SQLException;
	List<console> listarTodos () throws SQLException;
	Boolean Excluir (int _id) throws SQLException;
	Boolean Atualizar(console _objeto) throws SQLException;
	console buscarPorId(int _id) throws SQLException;

}
