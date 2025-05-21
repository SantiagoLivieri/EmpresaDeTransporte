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
	int contadorDePaquetesAgregados;
	int contadorDeCiudades;
	private List<Paquete> paquetes; 
	private Set<Ciudades> ciudadesUnicas = new HashSet<>();
	
	Automovil(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorre) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorre);
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorre = this.MAX_CIUDADES_QUE_RECORRE;
		this.paquetes = new ArrayList<>();
		this.contadorDePaquetesAgregados = 0;
		this.contadorDeCiudades = 0;
		idAuto =idAutoGlobal;
		this.idAutoPatente += idAutoGlobal;
		idAutoIncremental();
	}
	
	private void idAutoIncremental() {
		setIdAuto(++idAutoGlobal);
	}
	
	@Override
	public String numeroPaquetePatente(Paquete paquete) {
		System.out.println(paquete.getIdPaquetePatente());
		return paquete.getIdPaquetePatente();
	}
	
	@Override
	public Boolean existePaquete(Paquete paquete) {
		 for (Paquete paquete2 : paquetes) {				 
				 if(paquete2 != null) {					
					 if(paquete.equals(paquete2)) {
						//Da verdadero si el paquete que estoy agregando es igual al paquete que ya agrege
				    	  return  true;  
					 }
						//Da falso si el paquete es diferente		      
				 	}		 
			 	}//Da falso si el paquete es nulo 
		 return false; 	
		 	}
			
	@Override
	public Boolean agregarPaqueteAlEnvio(Paquete paquete) {	
			if(paquete != null ){
				if(!existePaquete(paquete)) {
					//Si el paquete que agrego no es nulo	
					paquetes.add(paquete);
					contadorDePaquetesAgregados++;
					return true;
				}
		}		
		return false;
	}
		
	@Override
	public Double calcularVolumenDelEnvioTotal() {
		Double volumenDelEnvioTotal = 0.0;
		for (int i = 0; i < paquetes.size(); i++) {
			if(paquetes.get(i) != null )
			volumenDelEnvioTotal += paquetes.get(i).calcularVolumen();
		}
		return volumenDelEnvioTotal;
	}
	
	@Override
	public Double calcularPesoDelEnvioTotal() {
		Double pesoDelEnvioTotal = 0.0;
		for (int i = 0; i < paquetes.size(); i++) {
			if(paquetes.get(i) != null )
			pesoDelEnvioTotal += paquetes.get(i).getPeso();
		}
		return pesoDelEnvioTotal;
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
	
	public String getIdAutoPatente() {
		return idAutoPatente;
	}

	public Integer getIdAuto() {
		return idAuto;
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
