import java.util.ArrayList;
import java.util.Scanner;

public class LlamadaContactos {
	//Scanner
	static Scanner scan = new Scanner(System.in);
	
	// Contador de objetos creados.		
	static Contacto[] lista_contactos = new Contacto[99];
    private static int contador_contactos = 0; 
    
	public static void main(String[] args) {
		int opcion;
		
		//Crear el ArrayList 
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		
		//Crear do while para menu con opciones 
		do {
			System.out.println("Menu De Agenda");
			System.out.println("1. Añadir un nuevo contacto");
			System.out.println("2. Comprobar existencia contacto");
			System.out.println("3. Listar contactos");
			System.out.println("4. Buscar un contacto");
			System.out.println("5. Eliminar un contacto");
			System.out.println("6. Salir");
			
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch (opcion) {
			case 1:
				nuevoContacto(contactos);
				break;
			case 2:
				existeContacto(contactos);
				break;
			case 3:
				listarContacto(contactos);
				break;
			case 4:
				buscarContacto(contactos);
				break;
			case 5:
				eliminarContacto(contactos);
				break;
			case 6: //Evitar que entre en default
				break;
			}
		}while(opcion != 6);
		
	}
	
//METODOS
	/*Metodo para crear un nuevo contacto, Añade un contacto a la agenda. No se pueden meter 
	 * contactos que existan, es decir, no podemos duplicar nombres, aunque tengan distinto teléfono.*/
public static void nuevoContacto(ArrayList<Contacto> contactos) {
	System.out.print("Introduce un nombre: ");
	String nombre = scan.nextLine();
	System.out.println("Introduce un telefono: ");
	int telefono = scan.nextInt();
	scan.nextLine(); //Para leer salto de linea
	Contacto c = new Contacto(nombre, telefono);
	//Añadir el contacto a la lista
	contactos.add(c);
	
}



/*Metodo para comprobar si un contacto existe*/
private static void existeContacto(ArrayList<Contacto> contactos) {
		System.out.println("Introduce un nombre a buscar: ");
		String nombre = scan.nextLine();
	for (int i=0; i< contador_contactos; i++) {
			if (nombre.equals(lista_contactos[i].getNombre())) {
				System.out.println("Ya existe un contacto con ese nombre");
				
			}
		}
		
	}
	

/*Metodo para listar los contactos existentes*/
private static void listarContacto(ArrayList<Contacto> contactos) {
	System.out.println("Introduce nombre de contacto: ");
	String nombre = scan.nextLine();
	scan.nextLine();
	
	
}
	
	
/*Metodo para buscar contactos*/
private static void buscarContacto(ArrayList<Contacto> contactos) {
		boolean encontrado = false;
		
		for (int i=0; i< contador_contactos; i++) {
			if(contactos.equals(lista_contactos[i].getNombre())) {
				System.out.println(lista_contactos[i].getNombre() + "-"  + "Tf:" + lista_contactos[i].getTelefono());
                encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Contacto inexistente");
		}
	}

/*Metodo para eliminar contactos*/
private static void eliminarContacto(ArrayList<Contacto> contactos) {
	System.out.println("Introduce posicion del contacto a eliminar: ");
	int posicion = scan.nextInt();
	
	Contacto c = contactos.get(posicion);
	System.out.println("Se va a eliminar el contacto " + c.toString());
	contactos.remove(posicion);
}

}
