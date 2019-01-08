package dell;

import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC  implements ClienteDao {

	@Override
	public boolean inserir(Cliente c) {
		String sql = "INSERT INTO clientes (nome, email, cpf) VALUES ('"+ c.getNome() + "','" +c.getEmail() + 
				"','" + c.getCpf() + "')";
		return executaSQL(sql);
	}

	@Override
	public boolean remover(String cpf) {
		String sql = "DELETE FROM clientes WHERE cpf = '" + cpf + "'";
		return executaSQL(sql);
	}
	
	
	

	
	private boolean executaSQL(String sql) {
		boolean sucesso = false;
		if(DB.getConnection()) {
			if (DB.runSQL(sql)> 0 ) {
				sucesso = true;
			}
			DB.close();
		}
		return sucesso;
	}

	@Override
	public List<Cliente> clientes() {
		String sql = "SELECT * FROM  clientes";
		return executaConsulta(sql);
	}
	private List <Cliente> executaConsulta(String sql){
		List<Cliente> cliente = new ArrayList<Cliente>();
		if (DB.getConnection()) {
			try {
				DB.setResultSet(sql);
				while(DB.resultSet.next()) {
					String nome = DB.resultSet.getString("NOME");
					String email = DB.resultSet.getString("EMAIL");
					String cpf = DB.resultSet.getString("CPF");
					cliente.add(new Cliente(nome, email, cpf));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DB.close();
			}
		}
		return cliente;		
	}

	
}
