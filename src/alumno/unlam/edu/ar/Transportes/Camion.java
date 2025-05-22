package alumno.unlam.edu.ar.Transportes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Camion extends Transporte{
	
	private final Double MAX_VOLUMEN_CARGA = 20.0;
	private final Double MAX_PESO_CARGA = 16000.0;//en Kilos
	private final Integer MAX_CIUDADES_QUE_RECORRE = 1000;
	private static Integer idCamiontaGlobal = 0;
	private  Integer idCamion;
	private String idCamionPatente = "C";
	int contadorDeCiudades;
	private List<Ciudades> ciudadesUnicas;
	
	Camion(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo);
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE;
		this.ciudadesUnicas = new ArrayList<>();
		this.contadorDeCiudades = 0;
		idCamion =idCamiontaGlobal;
		idCamionPatente += idCamiontaGlobal;
		idAutoIncremental();
	}
	
	private void idAutoIncremental() {
		setIdCamion(++idCamiontaGlobal);
	}

	@Override
	public int cantidadDeCiudadesPorEnvio() {			
		for (int i = 0; i < contadorDePaquetesAgregados; i++) {
	        Paquete paquete = paquetes.get(i);
	        if (paquete != null && paquete.getCiudad() != null) {

	        	if(ciudadesUnicas.add(paquete.getCiudad())) {
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
	
	public String getIdCamionPatente() {
		return idCamionPatente;
	}
	
	private void setIdCamion(Integer idCamion) {
		this.idCamion = idCamion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idCamionPatente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		return Objects.equals(idCamionPatente, other.idCamionPatente);
	}

}
