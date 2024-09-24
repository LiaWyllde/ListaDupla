package model;

public class No {
	
	private String palavra;
	private No proximo;
	
/**
 * @param e no construtor, serve para facilitar o caminho
 * se o nó fosse iniciado em null, eu teria que fazer um set palavra
 * para aí sim conseguir alocar no nó
 */
	
	public No(String e) {
		this.proximo = null;
		this.palavra = e;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public No getProximo() {
		return proximo;
	}
	
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return palavra.toString();
	}
}
