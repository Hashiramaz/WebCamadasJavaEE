package model;

public class studio {
	private int id;
	private String nome;
	private String pais;
	
	public studio(int id, String nome, String pais) {
		super();
		this.setId(id);
		this.setNome(nome);
		this.setPais(pais);
	
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
