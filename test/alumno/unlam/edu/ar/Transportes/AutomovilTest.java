package alumno.unlam.edu.ar.Transportes;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutomovilTest {

	@Test
	public void queElAutoLleveDosPaquetesDiferentesConDestinoDiferente() {
		//Preparacion
		Automovil renault;
		Paquete notbook,notbook1, celular, impresora;
		
		//PAQUETES
		Double pesoDePaquete = 10.5;
		Double pesoDePaquete2 = 10.5;
		Double pesoDePaquete3 = 420.5;
		
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
		Double pesoDeCargaAutomovil = 500.0;
	    Integer ciudadesQueViajaElPaqueteEnAutomovil = 3;
	    
		//Ejecucion
		renault = new Automovil(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		notbook1 = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete2, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.SALTA);
		
		
		renault.agregarPaqueteAlEnvio(notbook);
		renault.agregarPaqueteAlEnvio(notbook1);
		renault.agregarPaqueteAlEnvio(celular);
		renault.agregarPaqueteAlEnvio(impresora);
		
		//VALIDACION	
		assertTrue(renault.llevarPaquete());
}

	
	@Test
	public void queElAutoNoPuedaTenerLaMismaPatente() {
		//Preparacion
		Automovil renault, renault1;
		Paquete notbook, notbook1,  celular,celular1, impresora, impresora1;
		
		//PAQUETES
		Double pesoDePaquete = 7.5;
		Double pesoDePaquete2 = 0.5;
		Double pesoDePaquete3 = 150.5;
		
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
		renault = new Automovil(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		renault1 = new Automovil(volumenDeCargaAutomovil, pesoDeCargaAutomovil, ciudadesQueViajaElPaqueteEnAutomovil);
		
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		notbook1 = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.MARDELPLATA);
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.MARDELPLATA);
		celular1 = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.SALTA);
		impresora1 = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina.ROSARIO);
		
		renault.agregarPaqueteAlEnvio(notbook1);
		renault.agregarPaqueteAlEnvio(celular);
		renault.agregarPaqueteAlEnvio(celular1);
		renault.agregarPaqueteAlEnvio(impresora);
		renault.agregarPaqueteAlEnvio(impresora1);

		//VALIDACION
		System.out.println("Existe el paquete: " + renault.existePaquete(notbook));
		System.out.println("Se agregego el paquete: " + renault.agregarPaqueteAlEnvio(notbook));
		System.out.println("Existe el paquete: " + renault.existePaquete(notbook));
		System.out.println("El Volumen del envio es: " + renault.calcularVolumenDelEnvioTotal());
		System.out.println("El Peso del envio es: " + renault.calcularPesoDelEnvioTotal());
		System.out.println("Cantidad de Ciudades: " + renault.cantidadDeCiudadesPorEnvio());
		System.out.println("El Auto llevo el paquete: " + renault.llevarPaquete());
		
		assertTrue(renault.llevarPaquete());
		assertNotEquals(renault.getIdAutoPatente(), renault1.getIdAutoPatente());
	}
}
