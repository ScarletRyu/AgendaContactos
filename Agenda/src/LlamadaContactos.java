import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LlamadaContactos {
	//Scanner
	static Scanner scan = new Scanner(System.in);
	//Crear el ArrayList (fuera del static void main para que lo reconozcan todas las instancias de la clase
	static ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	public static void main(String[] args) {
		int opcion;
		
		
		
		//Crear do while para menu con opciones 
		do {
			System.out.println("Menu De Agenda");
			System.out.println("1. Añadir un nuevo contacto");
			System.out.println("2. Listar contactos");
			System.out.println("3. Buscar un contacto");
			System.out.println("4. Eliminar un contacto");
			System.out.println("5. Salir");
			
			
			opcion = scan.nextInt();
			scan.nextLine();
			
			switch (opcion) {
			case 1:
				nuevoContacto(contactos);
				break;
			case 2:
				listarContacto();
				break;
			case 3:
				System.out.println("Introduce nombre a buscar: ");
				String nombreBuscar = scan.nextLine();
				buscarContacto(nombreBuscar);
				break;
			case 4:
				System.out.println("Introduce nombre a borrar: ");
				String nombreEliminar = scan.nextLine();
				eliminarContacto(nombreEliminar);
				break;
			case 5:
				//Evitar que entre en default
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
	
	//Controlar si existe 
	if(contactoExiste(nombre) == false) {
	Contacto c = new Contacto(nombre, telefono);
	//Añadir el contacto a la lista
	contactos.add(c);
	
	//Si no lo hace

	}else {
		System.out.println("Contacto Duplicado");
	}
	}



//Continuacion del metodo para crear contactos, no podemos duplicar nombres, aunque tengan distinto teléfono
public static  boolean contactoExiste (String nombre) {
	//Crear un boolean para comprobar si el nombre que introducimos esta repetido o no
	boolean comprobarExistencia = false;
	for (int i = 0; i< contactos.size(); i++) {
		if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
			
			comprobarExistencia = true;
		}
	
		else {
			comprobarExistencia = false;
		}
	}return comprobarExistencia;
	
}
	

/*Metodo para listar los contactos existentes*/
public static void listarContacto() {
	Iterator listIt = contactos.iterator();
	while(listIt.hasNext()) {
		Contacto contObj1  = (Contacto) listIt.next();
		System.out.println(contObj1);
	}
	
	
}
	
	
/*Metodo para buscar contactos*/
public static void buscarContacto(String nombre) {
		//Creamos la variable busquedaContacto e introducimos los parametro dentro de contactos en ella
		for(Contacto busquedaContacto: contactos) {
			if (busquedaContacto.getNombre().equalsIgnoreCase(nombre)) {
				System.out.println(busquedaContacto.toStringTelefono());
			}
		}
		
		
	}

/*Metodo para eliminar contactos*/
public static void eliminarContacto(String nombre) {
	//Recorremos el ArrayList con un for para buscar dentro de el si esta el nombre que vamos a eliminar
	for (int i = 0; i < contactos.size(); i++) {
		if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
			contactos.remove(i);
			System.out.println("El contacto ha sido eliminado");
		}
		
	}
	
	
	
}

}
