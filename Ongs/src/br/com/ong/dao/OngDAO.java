package br.com.ong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import br.com.ong.domain.Ong;
import br.com.ong.factory.ConexaoFactory;

public class OngDAO {
	
	public void salvar(Ong ong) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ONG ");
		sql.append("(ID_ONG, ID_LOGIN, NOME_ONG, DESCRICAO_ONG, ID_TIPO_ONG, ID_ENDERECO, DATA_FUNDACAO, ID_STATUS_ONG, TELEFONE_ONG, EMAIL_ONG) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, ong.getIdOng());
		comando.setInt(2, 2);
		comando.setString(3, ong.getNomeOng());
		comando.setString(4, ong.getDescricaoOng());
		comando.setInt(5, 2);
		comando.setInt(6, 3);
		comando.setString(7, "20/02/2011");
		comando.setInt(8, 1);
		comando.setString(9, ong.getTelefoneOng());
		comando.setString(10, ong.getEmailOng());
		
		comando.executeUpdate();
	}
	
	public void excluir(Ong ong) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ONG ");
		sql.append("WHERE ID_ONG = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, ong.getIdOng());
		
		comando.executeUpdate();


	}
	
	public void editar(Ong ong) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ONG ");
		sql.append("SET DESCRICAO_ONG = ? ");
		sql.append("WHERE ID_ONG = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, ong.getDescricaoOng());
		comando.setInt(2, ong.getIdOng());
		
		comando.executeUpdate();


	}
	
	public Ong buscarPorCodigo(Ong ong) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ONG ");
		sql.append("WHERE ID_ONG = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, ong.getIdOng());
		
		ResultSet resultado = comando.executeQuery();
		
		Ong retorno = null;
		
		if(resultado.next()) {
			retorno = new Ong();
			retorno.setIdOng(resultado.getInt("ID_ONG"));
			retorno.setIdLogin(resultado.getInt("ID_LOGIN"));
			retorno.setNomeOng(resultado.getString("NOME_ONG"));
			retorno.setDescricaoOng(resultado.getString("DESCRICAO_ONG"));
			retorno.setIdTipoOng(resultado.getInt("ID_TIPO_ONG"));
			retorno.setIdEndereco(resultado.getInt("ID_ENDERECO"));
			retorno.setDataFundacao(resultado.getString("DATA_FUNDACAO"));
			retorno.setIdStatusOng(resultado.getInt("ID_STATUS_ONG"));
			retorno.setTelefoneOng(resultado.getString("TELEFONE_ONG"));
			retorno.setEmailOng(resultado.getString("EMAIL_ONG"));
			
		}
		
		return retorno;
		
	}
	
	public ArrayList<Ong> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ONG ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Ong> lista = new ArrayList<Ong>();
		
		
		while(resultado.next()) {
			Ong ong = new Ong();
			ong.setIdOng(resultado.getInt("ID_ONG"));
			ong.setIdLogin(resultado.getInt("ID_LOGIN"));
			ong.setNomeOng(resultado.getString("NOME_ONG"));
			ong.setDescricaoOng(resultado.getString("DESCRICAO_ONG"));
			ong.setIdTipoOng(resultado.getInt("ID_TIPO_ONG"));
			ong.setIdEndereco(resultado.getInt("ID_ENDERECO"));
			ong.setDataFundacao(resultado.getString("DATA_FUNDACAO"));
			ong.setIdStatusOng(resultado.getInt("ID_STATUS_ONG"));
			ong.setTelefoneOng(resultado.getString("TELEFONE_ONG"));
			ong.setEmailOng(resultado.getString("EMAIL_ONG"));
			
			lista.add(ong);
		}
		
		return lista;
		
	}
	
	public ArrayList<Ong> buscarPorNome(Ong ong) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ONG ");
		sql.append("WHERE NOME_ONG LIKE ? ");
		
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + ong.getNomeOng()+ "%");
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Ong> lista = new ArrayList<Ong>();
		
		
		while(resultado.next()) {
			Ong item = new Ong();
			item.setIdOng(resultado.getInt("ID_ONG"));
			item.setIdLogin(resultado.getInt("ID_LOGIN"));
			item.setNomeOng(resultado.getString("NOME_ONG"));
			item.setDescricaoOng(resultado.getString("DESCRICAO_ONG"));
			item.setIdTipoOng(resultado.getInt("ID_TIPO_ONG"));
			item.setIdEndereco(resultado.getInt("ID_ENDERECO"));
			item.setDataFundacao(resultado.getString("DATA_FUNDACAO"));
			item.setIdStatusOng(resultado.getInt("ID_STATUS_ONG"));
			item.setTelefoneOng(resultado.getString("TELEFONE_ONG"));
			item.setEmailOng(resultado.getString("EMAIL_ONG"));
			
			lista.add(item);
		}
		
		return lista;
		
	}
	
	
	public static void main(String[] args) {
		Ong ong1 = new Ong();
		ong1.setIdOng(1);
		ong1.setIdLogin(1);
		ong1.setNomeOng("AMIGOS DOS CAES");
		ong1.setDescricaoOng("ONG DE PROTECAO AOS CAES");
		ong1.setIdTipoOng(1);
		ong1.setIdEndereco(1);
		ong1.setDataFundacao("12/03/2020");
		ong1.setIdStatusOng(1);
		ong1.setTelefoneOng("99999999");
		ong1.setEmailOng("amigocaes@ong.com.br");

		
		OngDAO ongoad = new OngDAO();
		
		try {
			ongoad.salvar(ong1);
			System.out.println("A ONG foi salva com sucesso!");
		} catch(SQLException e) {
			System.out.println("Ocorreu um erro ao salvar");
			e.printStackTrace();
		}
	}

}
