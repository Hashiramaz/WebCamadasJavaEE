package dao;

import java.sql.SQLException;
import java.util.List;

import model.jogo;

public interface jogoInDAO {
	void Inserir(jogo _objeto) throws SQLException;
	List<jogo> listarTodos () throws SQLException;
	Boolean Excluir (int _id) throws SQLException;
	Boolean Atualizar(jogo _objeto) throws SQLException;
	jogo buscarPorId(int _id) throws SQLException;

}
