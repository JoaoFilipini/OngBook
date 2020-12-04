package br.com.ong.dao;

import java.sql.*;

import br.com.ong.domain.TipoOng;
import br.com.ong.factory.ConexaoFactory;

public class TipoOngDAO {
	
	public void salvar(TipoOng to) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO TIPO_ONG ");
		sql.append("(ID_TIPO_ONG, TIPO, DESCRICAO) ");
		sql.append("VALUES (?, ?, ?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, to.getId_Tipo_Ong());
		comando.setString(2, to.getTipo());
		comando.setString(3, to.getDescricao());
		
		comando.executeUpdate();
	}
	
	public static void main(String[] args) {
		TipoOng to1 = new TipoOng();
		to1.setId_Tipo_Ong(1);
		to1.setTipo("Caes");
		to1.setDescricao("Ong para adocao de caes");
		
		TipoOngDAO todao = new TipoOngDAO();
		
		try {
			todao.salvar(to1);
			System.out.println("O tipo foi salvo com sucesso!");
		} catch(SQLException e) {
			System.out.println("Ocorreu um erro ao salvar");
			e.printStackTrace();
		}
	}

}
