package negocio;

public class Gerente {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	public Gerente(int id) {
		this.id=id;
	};
	
	public Gerente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Gerente(int id, String nome, String email, String telefone) {
		this(nome, email, telefone);
		this.id=id;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void exibir() {
		System.out.println("Dados Gerente: \n" + this);
	}	
	
	@Override
	public String toString() {
		return String.format("%s;%s;%s", 
				this.nome, 
				this.email, 
				this.telefone);
	}
	
}
