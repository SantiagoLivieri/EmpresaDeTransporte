package alumno.unlam.edu.ar.Transportes;

import java.util.Iterator;

public class Paquete {
	private Double peso;
	private Double alto;
	private Double ancho;
	private Double profundidad;
	private Double volumen;
	private static Integer idPaqueteGlobal = 0;
	private  Integer idPaquete;
	private String idPaquetePatente = "P";
	private Ciudades ciudadqQueViajaElPaquete;
	
	Paquete(Double peso, Double alto, Double ancho, Double profundidad){
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		idPaquete =idPaqueteGlobal;
		idPaquetePatente += idPaqueteGlobal;
		idAutoIncremental();
	}
	
	Paquete(Double peso, Double alto, Double ancho, Double profundidad,Ciudades ciudadqQueViajaElPaquete){
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.ciudadqQueViajaElPaquete = ciudadqQueViajaElPaquete;
		idPaquete =idPaqueteGlobal;
		idPaquetePatente += idPaqueteGlobal;
		idAutoIncremental();
	}
	
	public void idAutoIncremental() {
		setIdPaquete(++idPaqueteGlobal);
	}

	public Integer getidPaquete() {
		return idPaquete;
	}
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAlto() {
		return alto;
	}

	public void setAlto(Double alto) {
		this.alto = alto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	
	public Double calcularVolumen() {
		return this.volumen = (this.profundidad * this.alto * this.ancho);
	}
	
	public Ciudades getCiudad() {
		return ciudadqQueViajaElPaquete;
	}

	public String getIdPaquetePatente() {
		return idPaquetePatente;
	}
	
	public Integer getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Integer idPaquete) {
		this.idPaquete = idPaquete;
	}
	
}
