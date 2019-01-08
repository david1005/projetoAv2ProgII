package dell;

public class Produto {
	private String nome;
	private int cod, quan;
	private double preco;
	
	public Produto(String nome, int cod, int quan, double preco) {
		this.nome= nome;
		this.cod = cod;
		this.quan = quan;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int getQuan() {
		return quan;
	}
	
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
