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
	int contadorDePaquetesAgregados;
	int contadorDeCiudades;
	Paquete[] arrayDePaquetes = new Paquete[MAX_CANTIDAD_PAQUETES];
	Ciudades [] ciudadesUnicas = new Ciudades[MAX_CIUDADES_QUE_RECORRE_VEHICULO];
	
	Bicicleta(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo, Integer maxCantidadPaquetes) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo);
		maxCantidadPaquetes = this.MAX_CANTIDAD_PAQUETES;
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE_VEHICULO;
		this.contadorDePaquetesAgregados = 0;
		this.contadorDeCiudades = 0;
		Paquete[]  arrayDePaquetes= this.arrayDePaquetes;	
		idBicicleta =idBicicletaGlobal;
		idBicicletaPatente += idBicicletaGlobal;
		idAutoIncremental();
	}
	
	private void idAutoIncremental() {
		setIdBicicleta(++idBicicletaGlobal);
	}
	
		
	@Override
	public String numeroPaquetePatente(Paquete paquete) {
		System.out.println(paquete.getIdPaquetePatente());
		return paquete.getIdPaquetePatente();
	}
	
	@Override
	public Boolean existePaquete(Paquete paquete) {
		 for (Paquete paquete2 : arrayDePaquetes) {				 
				 if(paquete2 != null) {					
					 if(paquete.getIdPaquetePatente() == paquete2.getIdPaquetePatente()) {
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
		 for (int i = 0 ; i < arrayDePaquetes.length ; i++){	 
			 if(paquete != null){
				//Si el paquete que agrego no es nulo			
			 if(!existePaquete(paquete)) {	
								arrayDePaquetes[contadorDePaquetesAgregados] = paquete;
								contadorDePaquetesAgregados++;
								return true;
						}
					}
				 }
		return false;	 
			 }
	
	@Override			
	public Double calcularVolumenDelEnvioTotal() {
		Double volumenDelEnvioTotal = 0.0;
		for (int i = 0; i < arrayDePaquetes.length; i++) {
			if(arrayDePaquetes[i] != null ) {
				volumenDelEnvioTotal += arrayDePaquetes[i].calcularVolumen();
			}
		}
		return volumenDelEnvioTotal;
	}
	
	@Override
	public Double calcularPesoDelEnvioTotal() {
		Double pesoDelEnvioTotal = 0.0;
		for (int i = 0; i < arrayDePaquetes.length; i++) {
			if(arrayDePaquetes[i] != null ) {
			pesoDelEnvioTotal += arrayDePaquetes[i].getPeso();
			}
		}
		return pesoDelEnvioTotal;
	}
	
	@Override
	public int cantidadDeCiudadesPorEnvio() {			
		for (int i = 0; i < contadorDePaquetesAgregados; i++) {
	        Paquete paquete = arrayDePaquetes[i];
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
		
		
		if(arrayDePaquetes[0].getCiudad() != null) {
			if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (0 < cantidadDeCiudadesTotal && cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE_VEHICULO)){
				System.out.println("La Bicicleta llevara el paquete");
				return true;				
			}else {
				System.out.println("La bicileta no llevara el paquete");
				return false;
			}	 
			
		}else {
			System.out.println("La bicileta  no llevara el paquete, porque el primer paquete no tiene destino");
			return false;
		}
		
	}
	
	public String getIdBicicletaPatente() {
		return idBicicletaPatente;
	}
	
	public Integer getIdBicicleta() {
		return idBicicleta;
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
