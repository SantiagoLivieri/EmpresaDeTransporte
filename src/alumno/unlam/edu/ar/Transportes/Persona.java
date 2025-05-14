package alumno.unlam.edu.ar.Transportes;

abstract class Persona {

	private String nombre;
	private String apellido;
	private Integer id;

	Persona(String nombre, String apellido, Integer id){
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
	}
}
