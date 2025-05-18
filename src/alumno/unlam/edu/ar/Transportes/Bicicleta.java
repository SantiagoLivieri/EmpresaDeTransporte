package alumno.unlam.edu.ar.Transportes;

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
	
	//Transporte(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo)
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
	
	/*
	//Transporte(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo)
	Bicicleta(Double maxVolumenDeCarga, Integer maxCiudadesQueRecorreElVehiculo, Double maxPesoDeCarga, Integer maxCantidadPaquetes){
		super( maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo );
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE_VEHICULO;
		maxCantidadPaquetes = this.MAX_CANTIDAD_PAQUETES;
		Paquete[]  arrayDePaquetes= this.arrayDePaquetes;
		this.contadorDePaquetesAgregados = 0;
		this.contadorDeCiudades = 0;
		idBicicleta =idBicicletaGlobal;
		idBicicletaPatente += idBicicletaGlobal;
		idAutoIncremental();
	}*/

	public void idAutoIncremental() {
		setIdBicicleta(++idBicicletaGlobal);
	}
	
	@Override
	public Integer numeroDePaquete(Paquete paquete) {
		System.out.println(paquete.getidPaquete());
		return paquete.getidPaquete();
	}
	
	
	public String numeroPaquetePatente(Paquete paquete) {
		System.out.println(paquete.getIdPaquetePatente());
		return paquete.getIdPaquetePatente();
	}
	
	
	/*@Override
	public Boolean existePaquete(Paquete paquete) {
		// boolean existe = false;
		 for (Paquete paquete2 : arrayDePaquetes) {
			 if(paquete2 != null && paquete2.getIdPaquetePatente().equals(paquete.getIdPaquetePatente())) {
		    	  return true;       
			 }
		 }		 	   			
			return false;		       
	   }*/
		
	@Override
	public Boolean existePaquete(Paquete paquete) {
		 for (Paquete paquete2 : arrayDePaquetes) {				 
				 if(paquete2 != null) {					
					 if(paquete.getidPaquete() == paquete2.getidPaquete()) {
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
	
	
	/*
	@Override
	public void agregarPaqueteAlEnvio(Paquete paquete) {

		Paquete[] agregarPaquetesAlArray = new Paquete[MAX_CANTIDAD_PAQUETES];
		 		
		 for (int i = 0 ; i < arrayDePaquetes.length ; i++){
			 if(!existePaquete(paquete)) {
			 agregarPaquetesAlArray[MAX_CANTIDAD_PAQUETES-i-1] = paquete;
		 
			if((arrayDePaquetes[i] != agregarPaquetesAlArray[i])){				
					arrayDePaquetes[MAX_CANTIDAD_PAQUETES-i-1] = paquete;					
				}				
			}
		}
	}*/
		
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
	
	/*
	@Override
	public int cantidadDeCiudadesPorEnvio() {
		int cantidadDeCiudadesPorEnvio = 0;
		Paquete[] compararCiudadesDeArray = new Paquete[MAX_CANTIDAD_PAQUETES];
		compararCiudadesDeArray= arrayDePaquetes;
		
		if(arrayDePaquetes[cantidadDeCiudadesPorEnvio].getCiudad() != null) {
			cantidadDeCiudadesPorEnvio++;		
		for (int i = 0; i < arrayDePaquetes.length; i++) {
			if(arrayDePaquetes[i].getCiudad() != null) {				
			for (int j = 4; j > arrayDePaquetes.length; j--) {

					if(compararCiudadesDeArray[j-3].getCiudad() != null) {
						if(arrayDePaquetes[i].getCiudad().equals(compararCiudadesDeArray[j-3].getCiudad())) {
							//Si es la misma Ciudad no hace nada
							}else {//Si son diferentes Ciudades
								cantidadDeCiudadesPorEnvio++;
							}	
						}
				 	}	
				}
			}
		}
		return cantidadDeCiudadesPorEnvio;
	}
	*/
				
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

}
