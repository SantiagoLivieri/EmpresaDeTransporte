package alumno.unlam.edu.ar.Transportes;

public class Bicicleta extends Transporte{

	private final Integer MAX_CANTIDAD_PAQUETES = 2;
	private final Double MAX_VOLUMEN_CARGA = 0.125;
	private final Double MAX_PESO_CARGA = 15.0;
	private final Integer MAX_CIUDADES_QUE_RECORRE_VEHICULO = 1;
	Paquete[] arrayDePaquetes = new Paquete[MAX_CANTIDAD_PAQUETES];
	
	
	Bicicleta(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo, Integer maxCantidadPaquetes) {
		super(maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo);
		maxCantidadPaquetes = this.MAX_CANTIDAD_PAQUETES;
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE_VEHICULO;
		Paquete[]  arrayDePaquetes= this.arrayDePaquetes;	
	}
	
	Bicicleta(Double maxPesoDeCarga, Integer maxCantidadPaquetes, Double maxVolumenDeCarga, Integer maxCiudadesQueRecorreElVehiculo){
		super( maxVolumenDeCarga, maxPesoDeCarga, maxCiudadesQueRecorreElVehiculo );
		maxVolumenDeCarga = this.MAX_VOLUMEN_CARGA;
		maxPesoDeCarga = this.MAX_PESO_CARGA;
		maxCiudadesQueRecorreElVehiculo = this.MAX_CIUDADES_QUE_RECORRE_VEHICULO;
		maxCantidadPaquetes = this.MAX_CANTIDAD_PAQUETES;
		Paquete[]  arrayDePaquetes= this.arrayDePaquetes;
	}

	@Override
	public Integer numeroDePaquete(Paquete paquete) {
		System.out.println(paquete.getidPaquete());
		return paquete.getidPaquete();
	}
	
	@Override
	public Boolean existePaquete(Paquete paquete) {
		 boolean existe = false;
		 for (Paquete paquete2 : arrayDePaquetes) {
			 if(paquete2 != null && paquete2.getidPaquete().equals(paquete.getidPaquete())) {
		    	  existe = true;       
			 }
			 return existe;			 
		 }		 	   			
			return existe;		       
	   }
		
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
				
	@Override
	public void llevarPaquete(Integer maxCiudadesQueRecorreElVehiculo) {
		Double volumenDelPaquete = 0.0;
		Double pesoDelpaquete =0.0;
		Integer cantidadDeCiudadesTotal=0;
		
		volumenDelPaquete = calcularVolumenDelEnvioTotal(); 
		pesoDelpaquete = calcularPesoDelEnvioTotal();
		cantidadDeCiudadesTotal = cantidadDeCiudadesPorEnvio();
		
		
		if(arrayDePaquetes[0].getCiudad() != null) {
			if((volumenDelPaquete <= MAX_VOLUMEN_CARGA) && (pesoDelpaquete <= MAX_PESO_CARGA) && (0 < cantidadDeCiudadesTotal && cantidadDeCiudadesTotal <= MAX_CIUDADES_QUE_RECORRE_VEHICULO)){
				System.out.println("La Bicicleta llevara el paquete");
				//return arrayDePaquetes[];
			}else {
				System.out.println("La bicileta no llevara el paquete");
			}	 
			
		}else {
			System.out.println("La bicileta  no llevara el paquete, porque el primer paquete no tiene destino");
		}
		
	}

}
