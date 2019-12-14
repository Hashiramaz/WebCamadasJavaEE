package model;

public class console {
	
	private int id;
	private String nome;
	private String empresa;
	
	public console(int id, String nome, String empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
	
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
