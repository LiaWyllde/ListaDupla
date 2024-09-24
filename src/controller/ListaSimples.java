package controller;
import model.Lista;

public class ListaSimples {
	
	public static void main(String[] Args){
		Lista lista = new Lista();
		
		try {
			
			lista.insert("Gataços", 0);
			lista.insert("Gataaaaon");
			lista.insert("Gato", 2);
			lista.insert("Gatos", 3);
			lista.insert("Gatinhos", 4);
			lista.insert("Gatões");
			
			System.out.println(lista.getLast().toString()); 
			
			System.out.println(lista.quantidade());
		
			System.out.println(lista.getNo(2).toString());
			
			System.out.println(lista.toString());
			
			lista.remove(5);
			lista.remove(0);
			lista.remove(0);
			lista.remove(1);
			
			System.out.println(lista.toString());
			
			System.out.println(lista.getLast().toString()); 
			System.out.println(lista.getF().toString()); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
