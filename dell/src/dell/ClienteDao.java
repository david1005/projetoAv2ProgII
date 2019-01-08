package dell;

import java.util.List;

public interface ClienteDao {
	
	boolean inserir (Cliente c);
	boolean remover(String string); 
	//boolean editar(String c);
	public List <Cliente> clientes();

}
