package dao;

import java.sql.SQLException;
import java.util.List;

import model.studio;

public interface studioInDAO {
	void Inserir(studio _objeto) throws SQLException;
	List<studio> listarTodos () throws SQLException;
	Boolean Excluir (int _id) throws SQLException;
	Boolean Atualizar(studio _objeto) throws SQLException;
	studio buscarPorId(int _id) throws SQLException;
}
