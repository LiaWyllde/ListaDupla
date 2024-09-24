package model;

import model.DNo;

public class DLista {
	
	private DNo primeiro = null;
	private DNo ultimo = null;
	private static int qt = 0;
	
	public void prepend(String l) {
		
		DNo nozinho = new DNo(l);
		
		if (qt == 0) {
			this.primeiro = nozinho;
			this.ultimo = nozinho;
			++qt;
		} else {
			this.primeiro.setAnterior(nozinho);
			nozinho.setProximo(primeiro);
			this.primeiro = nozinho;
			++qt;
		}
	} 
	
	public void append(String l) {
		
		if (qt == 0) {
			prepend(l);
		} else {
			DNo nozinho = new DNo(l);
			nozinho.setAnterior(ultimo);
			this.ultimo.setProximo(nozinho);
			this.ultimo = nozinho;
			++qt;
		}
	}
	public DNo getNo(int index) throws Exception {
		
		if (qt == 0) {
			throw new Exception ("A lista está vazia");
		} else if (index == 0) {
			return this.primeiro;
		} else {
			DNo armazena = primeiro;
			
			for (int i = 0; i < index ; i++) {
				armazena = armazena.getProximo();
			}
			if (armazena == null) {
				//System.out.println("Não há nada na posição " + index);
				return null;
			} else {
				return armazena;
			}
		}
	}
	
	public void insert(String l, int index) throws Exception {
		if (index == 0) {
			prepend(l);
		} else {
			if (index >= qt) {
				append(l);
			} else {
				DNo armazena = getNo(index);
				DNo nozinho = new DNo(l);
				DNo anterior = armazena.getAnterior();
				//armazena tem o valor do que estava no lugar
				//anterior é o anterior do armazena
				
				anterior.setProximo(nozinho);
				nozinho.setProximo(armazena);
				nozinho.setAnterior(anterior);
				armazena.setAnterior(nozinho);
				++qt;
			}
		}
	}
	
	public void remove(int index) throws Exception {
		
		if (qt == 0) {
			throw new Exception ("A lista está vazia");
			
		} else if (index == 0) {
			if (qt == 1) {
				this.primeiro = null;
				this.ultimo = null;
			}else {
				this.primeiro = primeiro.getProximo();
				primeiro.setAnterior(null);
			}
			--qt;
		} else if (index >= qt) {
			
			DNo novoUltimo = this.ultimo.getAnterior();
			novoUltimo.setProximo(null);
			this.ultimo = null;
			this.ultimo = novoUltimo;
			--qt;
			
		} else {
			
			DNo vaiSumir = getNo(index);
			
			if (vaiSumir == this.ultimo) {
				
				DNo novoUltimo = this.ultimo.getAnterior();
				novoUltimo.setProximo(null);
				this.ultimo = null;
				this.ultimo = novoUltimo;
				
			} else {
				
				DNo anterior = vaiSumir.getAnterior();
				DNo proximo = vaiSumir.getProximo();
				
				anterior.setProximo(proximo);
				proximo.setAnterior(anterior);
			}
			--qt;
		}
		
	}
	
	public DNo getLast() {
		return this.ultimo;
	}
	
	public DNo getF() {
		return primeiro;
	}
	
	public int quantidade() {
		return qt;
	}
	
	@Override
	public String toString() {
		
		if (qt == 0) {
			return "[]";
		} 
		
		StringBuilder builder = new StringBuilder("[");
		DNo cat = primeiro;
		
		builder.append(cat.getLetra());
		while (cat.getProximo() != null) {
			builder.append(", ");
			cat = cat.getProximo();
			builder.append(cat.getLetra());
			//adiciona a palavra do get ao builder que builda a string
		}
		
		builder.append("]");
		
		return builder.toString();
	}
}
