package model;

public class DNo {
	
	private String letra;
	private DNo proximo;
	private DNo anterior;
	
	public DNo(String l) {
		this.letra = l;
	}

	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public DNo getProximo() {
		return proximo;
	}
	public void setProximo(DNo proximo) {
		this.proximo = proximo;
	}
	public DNo getAnterior() {
		return anterior;
	}
	public void setAnterior(DNo anterior) {
		this.anterior = anterior;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return letra.toString();
	}
}
