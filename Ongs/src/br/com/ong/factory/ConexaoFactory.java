package br.com.ong.factory;

import java.sql.*;

public class ConexaoFactory {
	
	private static String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=host.docker.internal)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=globaldb)))";
	private static String strUserID = "ONGBOOK";
	private static String strPassword = "ONGBOOK";
	
	public static Connection conectar() throws SQLException{
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection conexao = DriverManager.getConnection(dbURL,strUserID,strPassword);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
		} catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Não foi possível realizar a conexão!");
		}
	}

}
