package alumno.unlam.edu.ar.Transportes;

public class Automovil extends Transporte{

	private final Double MAX_VOLUMEN_CARGA = 2.0;
	private final Double MAX_PESO_CARGA = 500.0;
	private final Integer MAX_CIUDADES_QUE_RECORRE = 3;
	private final Integer MAX_CANTIDAD_PAQUETES = 10;
	int contadorDePaquetesAgregados;
	int contadorDeCiudades;
	Paquete[] arrayDePaquetes = new Paquete[MAX_CANTIDAD_PAQUETES];
	Ciudades [] ciudadesUnicas = new Ciudades[MAX_CIUDADES_QUE_RECORRE];
	
	
	Automovil(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorre) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorre);
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorre = this.MAX_CIUDADES_QUE_RECORRE;
		Paquete[] arrayDePaquetes = this.arrayDePaquetes;
		this.contadorDePaquetesAgregados = 0;
		this.contadorDeCiudades = 0;
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
	                    return MAX_CIUDADES_QUE_RECORRE + 1;
	                }
	            }

	            // Si no está, la agregamos
	            if (!ciudadYaAgregada) {
	                if (contadorDeCiudades >= MAX_CIUDADES_QUE_RECORRE) {
	                    return MAX_CIUDADES_QUE_RECORRE + 1; // Se excedió el límite
	                }
	                ciudadesUnicas[contadorDeCiudades] = ciudad;
	                contadorDeCiudades++;
	            }
	        }
		}   
	    
	    return contadorDeCiudades;
	}
		
	
	
	@Override
	void llevarPaquete(Integer maxCiudadesQueRecorre) {
		Double volumenDelPaquete = 0.0;
		Double pesoDelpaquete =0.0;
		Integer cantidadDeCiudadesTotal = 0;
		
		volumenDelPaquete = calcularVolumenDelEnvioTotal(); 
		pesoDelpaquete = calcularPesoDelEnvioTotal();
		cantidadDeCiudadesTotal = cantidadDeCiudadesPorEnvio();
		
		if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE)){
			System.out.println("El Auto llevara el paquete" + " " + contadorDeCiudades);
			//return arrayDePaquetes[];
		}else {
			System.out.println("El Auto no llevara el paquete");
		}	 
	}
}
