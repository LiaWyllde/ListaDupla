package model;

public class Lista {
	
	private No primeiro = null;
	private No ultimo = null;
	private static int qtElements = 0;
	
	public void insert(String palavra) {
		
		No nozinho = new No(palavra);
		
		if (qtElements == 0) {
			//nozinho.setProximo(null); o objeto já vem com null 
			this.primeiro = nozinho;
			this.ultimo = nozinho;
			++qtElements;
		} else {
			this.ultimo.setProximo(nozinho);
			this.ultimo = nozinho;
			++qtElements;
		}
	}
	
	public void insert(String palavra, int index) {
		
		No nozinho = new No(palavra);
		
		if (qtElements == 0) {
			this.primeiro = nozinho;
			this.ultimo = nozinho;
			++qtElements;
			//se não tiver elemento nenhum, só adiciona
		} else if (index == 0) {
			nozinho.setProximo(primeiro);
			this.primeiro = nozinho;
			++qtElements;
		} else {
			
			/*
			 * se tiver elementos o (no que)guarda recbe o valor
			 * naquela posição e aí vejo se a posição estava vazia
			 * se estiver, adiciono o conteúdo e ++ na quantidade
			 * se não estiver, coloco como proximo do nozinho
			 */
			
			No guarda = primeiro;
			No anterior = null;
			
			for (int i = 0; i < index; i++) {
				if (i == (index-1)) {
					anterior = guarda;
				}
				guarda = guarda.getProximo();
			}
			if (guarda == null) {
				//dava pra reaproveitar o metodo anterior
				anterior.setProximo(nozinho);
				this.ultimo = nozinho;
				++qtElements;
				
			} else {
				anterior.setProximo(nozinho);
				nozinho.setProximo(guarda);
				++qtElements;
			}
		}
	}
	
	public No getNo(int index) throws Exception {
		
		
		if (qtElements == 0) {
			throw new Exception ("O index está vazio");}
			
		No guarda = primeiro;
		
		if (guarda == null) {
			throw new Exception ("Não há nada no índice");}
		
		for (int i = 0; i < index; i++) {
			guarda = guarda.getProximo();
		}
		if (guarda == null) {
			throw new Exception ("O index está vazio");
		} else {
			return guarda;
		}
	}
	
	public void remove(int index) throws Exception {
		
		if (qtElements == 0) {
			throw new Exception ("Lista vazia.");
		} else if (qtElements == 1) {
			this.primeiro = null;
			this.ultimo = null;
			--qtElements;
		} else {
			No guarda = getNo(index);
			if (guarda == null) {
				throw new Exception ("Não há nada no índice");
			}
			
			No anterior = getNo(index-1);
			
			if (guarda == ultimo) {
				this.ultimo = anterior;
			}
			
			if (guarda == primeiro) {
				this.primeiro = guarda.getProximo();
			}
			
			anterior.setProximo(guarda.getProximo());
			guarda = null;
			--qtElements;
			
			
		}
	}
	
	public int quantidade() {
		return qtElements;
	}
	
	public No getLast() {
		return ultimo;
	}
	
	public No getF() {
		return primeiro;
	}
	
	@Override
	public String toString() {
		
		if (qtElements == 0) {
			return "[]";
		} 
		
		StringBuilder builder = new StringBuilder("[");
		No cat = primeiro;
		
		builder.append(cat.getPalavra());
		while (cat.getProximo() != null) {
			builder.append(", ");
			cat = cat.getProximo();
			builder.append(cat.getPalavra());
			//adiciona a palavra do get ao builder que builda a string
		}
		
		builder.append("]");
		
		return builder.toString();
	}
	
	
}
