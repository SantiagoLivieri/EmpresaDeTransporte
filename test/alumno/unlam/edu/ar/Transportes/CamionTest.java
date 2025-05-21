package alumno.unlam.edu.ar.Transportes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CamionTest {
	
	@Test
	public void queElCamionLleveDosPaquetesDiferentesConDestinoDiferente() {
		//Preparacion
		Camion iveco;
		Paquete notbook, celular, impresora;
		
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
				
		//CAMION
	    Double volumenDeCargaCamion = 20.0;
		Double pesoDeCargaCamion = 16000.0;
	    Integer ciudadesQueViajaElPaqueteEnCamion = 10000;
	    
		//Ejecucion
	    iveco = new Camion(volumenDeCargaCamion,pesoDeCargaCamion,ciudadesQueViajaElPaqueteEnCamion);
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.MARDELPLATA);
			
		iveco.agregarPaqueteAlEnvio(impresora);
		iveco.agregarPaqueteAlEnvio(celular);
		iveco.agregarPaqueteAlEnvio(notbook);
		
		//VALIDACION
		assertTrue(iveco.llevarPaquete());
}

	
	@Test
	public void queElCamionNoPuedaTenerLaMismaPatente() {
		//Preparacion
		Camion iveco,iveco1;
		Paquete notbook, celular, impresora;
		
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
				
		//AUTOMOVIL
		Double volumenDeCargaAutomovil = 2.0;
		Double pesoDeCargaAutomovil = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnAutomovil = 3;
	    
		//Ejecucion
	    iveco = new Camion(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
	    iveco1 = new Camion(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.MARDELPLATA);
		
		iveco.agregarPaqueteAlEnvio(notbook);
		iveco.agregarPaqueteAlEnvio(celular);
		iveco.agregarPaqueteAlEnvio(impresora);

		//VALIDACION
		assertNotEquals(iveco.getIdCamionPatente(), iveco1.getIdCamionPatente());
	}
	
	@Test
	public void queElCamionPuedaLlevarMuchosPaquetesAMuchosDestinos() {
		//Preparacion
		Camion iveco;
		Paquete notbook, celular, impresora,notbook1, celular1, impresora1;
		
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
				
		//AUTOMOVIL
		Double volumenDeCargaAutomovil = 2.0;
		Double pesoDeCargaAutomovil = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnAutomovil = 3;
	    
		//Ejecucion
	    iveco = new Camion(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.MARDELPLATA);
		notbook1 = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular1 = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora1 = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.MARDELPLATA);
		
		iveco.agregarPaqueteAlEnvio(notbook);
		iveco.agregarPaqueteAlEnvio(celular);
		iveco.agregarPaqueteAlEnvio(impresora);
		iveco.agregarPaqueteAlEnvio(notbook1);
		iveco.agregarPaqueteAlEnvio(celular1);
		iveco.agregarPaqueteAlEnvio(impresora1);

		//VALIDACION
		assertTrue(iveco.llevarPaquete());
	}
}
