package alumno.unlam.edu.ar.Transportes;

import java.util.Objects;

public class Bicicleta extends Transporte{

	private final Integer MAX_CANTIDAD_PAQUETES = 2;
	private final Double MAX_VOLUMEN_CARGA = 0.125;
	private final Double MAX_PESO_CARGA = 15.0;
	private final Integer MAX_CIUDADES_QUE_RECORRE_VEHICULO = 1;
	private static Integer idBicicletaGlobal = 0;
	private  Integer idBicicleta;
	private String idBicicletaPatente = "B";
	int contadorDeCiudades;
	Ciudades [] ciudadesUnicas = new Ciudades[MAX_CIUDADES_QUE_RECORRE_VEHICULO];
	
	Bicicleta(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo, Integer maxCantidadPaquetes) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo);
		maxCantidadPaquetes = this.MAX_CANTIDAD_PAQUETES;
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE_VEHICULO;
		this.contadorDeCiudades = 0;	
		idBicicleta =idBicicletaGlobal;
		idBicicletaPatente += idBicicletaGlobal;
		idAutoIncremental();
	}
	
	private void idAutoIncremental() {
		setIdBicicleta(++idBicicletaGlobal);
	}
	
	@Override
	public int cantidadDeCiudadesPorEnvio() {			
		for (int i = 0; i < contadorDePaquetesAgregados; i++) {
	        Paquete paquete = paquetes.get(i);
	        if (paquete != null && paquete.getCiudad() != null) {
	            Ciudades ciudad = paquete.getCiudad(); 
	            boolean ciudadYaAgregada = false;

	            // Verificar si la ciudad ya está en el array
	            for (int j = 0; j < contadorDeCiudades; j++) {
	                if (ciudadesUnicas[j].equals(ciudad)) {
	                    ciudadYaAgregada = true;
	                    //return MAX_CIUDADES_QUE_RECORRE_VEHICULO + 1;
	                }
	            }

	            // Si no está, la agregamos
	            if (!ciudadYaAgregada) {
	                if (contadorDeCiudades > MAX_CIUDADES_QUE_RECORRE_VEHICULO) {
	                    return MAX_CIUDADES_QUE_RECORRE_VEHICULO + 1; // Se excedió el límite
	                }
	                ciudadesUnicas[contadorDeCiudades] = ciudad;
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
		Integer cantidadDeCiudadesTotal=0;
		
		volumenDelPaquete = calcularVolumenDelEnvioTotal(); 
		pesoDelpaquete = calcularPesoDelEnvioTotal();
		cantidadDeCiudadesTotal = cantidadDeCiudadesPorEnvio();
		
		
		if(paquetes.get(0).getCiudad() != null) {
			if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (0 < cantidadDeCiudadesTotal && cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE_VEHICULO)){
				return true;				
			}else {
				return false;
			}	 
			
		}else {
			return false;
		}
		
	}
	
	public String getIdBicicletaPatente() {
		return idBicicletaPatente;
	}
	
	private void setIdBicicleta(Integer idBicicleta) {
		this.idBicicleta = idBicicleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idBicicletaPatente);
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
		Bicicleta other = (Bicicleta) obj;
		return Objects.equals(idBicicletaPatente, other.idBicicletaPatente);
	}

}
