package alumno.unlam.edu.ar.Transportes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Automovil extends Transporte{

	private final Double MAX_VOLUMEN_CARGA = 2.0;
	private final Double MAX_PESO_CARGA = 500.0;
	private final Integer MAX_CIUDADES_QUE_RECORRE = 3;
	private static Integer idAutoGlobal = 0;
	private  Integer idAuto;
	private String idAutoPatente = "A";
	int contadorDeCiudades;
	private List<Ciudades> ciudadesUnicas; 
	
	Automovil(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorre) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorre);
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorre = this.MAX_CIUDADES_QUE_RECORRE;
		ciudadesUnicas = new ArrayList<>();
		this.contadorDeCiudades = 0;
		idAuto =idAutoGlobal;
		this.idAutoPatente += idAutoGlobal;
		idAutoIncremental();
	}
	
	private void idAutoIncremental() {
		setIdAuto(++idAutoGlobal);
	}
	
	@Override
	public int cantidadDeCiudadesPorEnvio() {			
		for (int i = 0; i < contadorDePaquetesAgregados; i++) {
	        Paquete paquete = paquetes.get(i);
	        if (paquete != null && paquete.getCiudad() != null) {

	        	if(ciudadesUnicas.size() < MAX_CIUDADES_QUE_RECORRE) {
	        		ciudadesUnicas.add(paquete.getCiudad());
		            contadorDeCiudades++;
	        	}	                      
	        }              
		}     
	    return contadorDeCiudades;
	}

	@Override
	public Boolean llevarPaquete() {
		Double volumenDelPaquete = 0.0;
		Double pesoDelpaquete =0.0;
		Integer cantidadDeCiudadesTotal = 0;
		
		volumenDelPaquete = calcularVolumenDelEnvioTotal(); 
		pesoDelpaquete = calcularPesoDelEnvioTotal();
		cantidadDeCiudadesTotal = cantidadDeCiudadesPorEnvio();
		
		if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE)){
			return true;
		}else {
			return false;
		}	 
	}
	
	public String getIdAutoPatente() {
		return idAutoPatente;
	}

	public void setIdAuto(Integer idAuto) {
		this.idAuto = idAuto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAutoPatente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovil other = (Automovil) obj;
		return Objects.equals(idAutoPatente, other.idAutoPatente);
	}
}