package model;

public class loja {
	
	private int id;
	private String nome;
	private String site;
	
	public loja(int id, String nome, String site) {
		super();
		this.setId(id);
		this.setNome(nome);
		this.setSite(site);
	
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
