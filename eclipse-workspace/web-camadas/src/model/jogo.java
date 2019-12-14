package model;

public class jogo {
	
	private int id;
	private String nome;
	private String data;
	private String console;
	private String studio;
	private String loja;
	
	public jogo(int id, String nome, String data, String console, String studio, String loja) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.console= console;
		this.studio = studio;
		this.loja = loja;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public String getLoja() {
		return loja;
	}
	public void setLoja(String loja) {
		this.loja = loja;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
