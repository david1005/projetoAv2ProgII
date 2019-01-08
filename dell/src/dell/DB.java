package dell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3308/banco?useSSL=false&useTimezone=true&serverTimezone=UTC";

	
	//OBTÉM CONEXÃO COM O BANCO 
	public static boolean getConnection() {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, "root", "");
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//JOptionPane.showMessageDialog(null, "Conectado com sucesso");
			 System.out.println("Conectou");
			return true;
		} catch (ClassNotFoundException erro) {
			erro.printStackTrace();
			return false;
		} catch (SQLException erro) {
			erro.printStackTrace();
			return false;
		}
	}

	public static void close() {
		closeResultSet();
		closeStatement();
		closeConnection();
	}

	public static void closeConnection() {
		try {
			connection.close();
			//JOptionPane.showMessageDialog(null, "Desconectado com Sucesso.");
			 //System.out.println("Desconectou");
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
	}

	public static void closeStatement() {
		try {
			statement.close();
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public static void closeResultSet() {
		try {
			resultSet.close();

		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public static void setResultSet(String sql) {
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException erro) {
			erro.printStackTrace();
		}

	}

	public static int runSQL(String sql) {
		int quant = 0;
		try {
			quant = statement.executeUpdate(sql);
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		return quant;
	}
}
