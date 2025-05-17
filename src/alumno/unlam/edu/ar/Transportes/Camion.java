package alumno.unlam.edu.ar.Transportes;

public class Camion extends Transporte{
	
	private final Double MAX_VOLUMEN_CARGA = 20.0;
	private final Double MAX_PESO_CARGA = 16000.0;//en Kilos
	private final Integer MAX_CANTIDAD_PAQUETES = 1000;
	private final Integer MAX_CIUDADES_QUE_RECORRE = 1000;
	private static Integer idCamiontaGlobal = 0;
	private  Integer idCamion;
	private String idCamionPatente = "C";
	int contadorDePaquetesAgregados;
	int contadorDeCiudades;
	Paquete[] arrayDePaquetes = new Paquete[MAX_CANTIDAD_PAQUETES];
	Ciudades [] ciudadesUnicas = new Ciudades[MAX_CIUDADES_QUE_RECORRE];
	
	Camion(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo);
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE;
		Paquete[] arrayDePaquetes = this.arrayDePaquetes;
		this.contadorDePaquetesAgregados = 0;
		this.contadorDeCiudades = 0;
		idCamion =idCamiontaGlobal;
		idCamionPatente += idCamiontaGlobal;
		idAutoIncremental();
	}
	
	public void idAutoIncremental() {
		setIdCamion(++idCamiontaGlobal);
	}

	@Override
	public Integer numeroDePaquete(Paquete paquete) {
		System.out.println(paquete.getidPaquete());
		return paquete.getidPaquete();
	}

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
	public void agregarPaqueteAlEnvio(Paquete paquete) {
		for (int i = 0 ; i < arrayDePaquetes.length ; i++){	 
			 if(paquete != null){
				//Si el paquete que agrego no es nulo			
			 if(!existePaquete(paquete)) {	
								arrayDePaquetes[contadorDePaquetesAgregados] = paquete;
								contadorDePaquetesAgregados++;
						}
					}
				 }	 
	}

	@Override
	public Double calcularVolumenDelEnvioTotal() {
		Double volumenDelEnvioTotal = 0.0;
		for (int i = 0; i < arrayDePaquetes.length; i++) {
			if(arrayDePaquetes[i] != null )
			volumenDelEnvioTotal += arrayDePaquetes[i].calcularVolumen();
		}
		return volumenDelEnvioTotal;
	}

	@Override
	public Double calcularPesoDelEnvioTotal() {
		Double pesoDelEnvioTotal = 0.0;
		for (int i = 0; i < arrayDePaquetes.length; i++) {
			if(arrayDePaquetes[i] != null )
			pesoDelEnvioTotal += arrayDePaquetes[i].getPeso();
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
	                }
	            }

	            // Si no está, la agregamos            
	                ciudadesUnicas[contadorDeCiudades] = ciudad;
	                contadorDeCiudades++;
	            }
	        }	    
	    return contadorDeCiudades;
	}

	@Override
	public Boolean llevarPaquete(Integer maxCiudadesQueRecorreElVehiculo) {
		Double volumenDelPaquete = 0.0;
		Double pesoDelpaquete =0.0;
		Integer cantidadDeCiudadesTotal = 0;
		
		volumenDelPaquete = calcularVolumenDelEnvioTotal(); 
		pesoDelpaquete = calcularPesoDelEnvioTotal();
		cantidadDeCiudadesTotal = cantidadDeCiudadesPorEnvio();
		
		if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE)){
			System.out.println("El Camion llevara el paquete" + " " + contadorDeCiudades);
			return true;
			//return arrayDePaquetes[];
		}else {
			System.out.println("El Camion no llevara el paquete");
			return false;
		}	 
	}
	
	public String getIdCamionPatente() {
		return idCamionPatente;
	}
	
	public Integer getIdCamion() {
		return idCamion;
	}

	private void setIdCamion(Integer idCamion) {
		this.idCamion = idCamion;
	}

}
