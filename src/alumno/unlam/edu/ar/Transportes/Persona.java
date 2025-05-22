package alumno.unlam.edu.ar.Transportes;

import java.util.Objects;

abstract class Persona {

	private String nombre;
	private String apellido;
	private Integer id;

	Persona(String nombre, String apellido, Integer id){
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	
}
