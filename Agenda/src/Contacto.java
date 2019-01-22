
public class Contacto {
	
//ATRIBUTOS
	
	private String nombre;
	private int telefono;
	
/*Un contacto est� definido por un nombre(String) y un tel�fono(num�rico) */	
	public Contacto(String nombre, int telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}

//GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	//toString
	public String toString() {
        return nombre + ". Telefono = " + telefono;
    }
	
	
}