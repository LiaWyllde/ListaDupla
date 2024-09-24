package controller;
import model.DLista;

public class ListaDupla {
	
	public static void main(String[] Args){
		DLista lista = new DLista();
		
		try {
			
			lista.insert("Gataços", 0);
			lista.append("Gataaaaon");
			lista.insert("Gato", 2);
			lista.insert("Gatos", 3);
			lista.insert("Gatinhos", 4);
			lista.append("Gatões");
			
			
			System.out.println(lista.getLast().toString()); 
			
			System.out.println(lista.quantidade());
		
			System.out.println(lista.getNo(2).toString());
			
			System.out.println(lista.toString());
			
			//lista.remove(5);
			//lista.remove(0);
			lista.remove(0);
			lista.remove(5);
			
			//lista.insert("Gatinhos", 7 );
			//lista.insert("Miau", 1 );
			
			System.out.println(lista.toString());
			
			System.out.println(lista.getLast().toString()); 
			System.out.println(lista.getF().toString()); 
			
			System.out.println(lista.quantidade());

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

