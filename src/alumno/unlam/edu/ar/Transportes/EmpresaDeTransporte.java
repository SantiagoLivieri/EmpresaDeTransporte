package alumno.unlam.edu.ar.Transportes;

public class EmpresaDeTransporte {

	public static void main(String[] args) {
		//PAQUETES
		Double pesoDePaquete = 7.5;
		Double pesoDePaquete2 = 0.5;
		Double pesoDePaquete3 = 450.5;
		
		Double altoDePaquete = 0.3;
		Double altoDePaquete2 = 0.5;
		Double altoDePaquete3 = 0.3; 
		
		Double anchoDePaquete = 0.4;
		Double anchoDePaquete2 = 0.4;
		Double anchoDePaquete3 = 0.3;
		
		Double profundidadDePaquete = 0.3;
		Double profundidadDePaquete2 = 0.4;
		Double profundidadDePaquete3 = 0.3;
			
		Integer ciudadesQueViajaElPaquete = 1;
		Ciudades argentina = null;
		
		//	BICICLETA
		Double volumenDeCargaBicicleta = 0.125;
		Double pesoDeCargaBicileta = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
	    Integer cantidadDePaquetesQueLlevaLaBici = 2;
	        
	    //AUTO
		Double volumenDeCargaAutomovil = 2.0;
		Double pesoDeCargaAutomovil = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnAutomovil = 3;
	    
	    //CAMION
	    Double volumenDeCargaCamion = 20.0;
		Double pesoDeCargaCamion = 16000.0;
	    Integer ciudadesQueViajaElPaqueteEnCamion = 10000;
	   
		Paquete notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		Paquete celular = new Paquete(pesoDePaquete2, altoDePaquete2, anchoDePaquete2, profundidadDePaquete2,argentina.BUENOS_AIRES);		
		Paquete impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina);
		
		Bicicleta olmo = new Bicicleta(pesoDeCargaBicileta,cantidadDePaquetesQueLlevaLaBici,volumenDeCargaBicicleta,ciudadesQueViajaElPaqueteEnBicicleta);		
		olmo.agregarPaqueteAlEnvio(notbook);
		olmo.agregarPaqueteAlEnvio(notbook);
		olmo.agregarPaqueteAlEnvio(celular);
		olmo.llevarPaquete(ciudadesQueViajaElPaquete);
		
		Automovil renault = new Automovil(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		Automovil renault1 = new Automovil(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		renault.agregarPaqueteAlEnvio(impresora);
		renault.agregarPaqueteAlEnvio(impresora);
		renault.agregarPaqueteAlEnvio(celular);
		renault.agregarPaqueteAlEnvio(notbook);
		renault.agregarPaqueteAlEnvio(impresora);
		System.out.println(renault.getIdAutoPatente());
		System.out.println(renault.getIdAutoPatente());
		renault.llevarPaquete(ciudadesQueViajaElPaqueteEnAutomovil);
		
		Camion iveco = new Camion(volumenDeCargaCamion,pesoDeCargaCamion,ciudadesQueViajaElPaqueteEnCamion);		
		iveco.agregarPaqueteAlEnvio(impresora);
		iveco.agregarPaqueteAlEnvio(celular);
		iveco.agregarPaqueteAlEnvio(notbook);
		iveco.llevarPaquete(ciudadesQueViajaElPaqueteEnCamion);
	}

}


