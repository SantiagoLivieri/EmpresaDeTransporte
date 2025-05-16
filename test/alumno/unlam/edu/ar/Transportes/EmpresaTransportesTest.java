package alumno.unlam.edu.ar.Transportes;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTransportesTest {

	@Test
	public void queSePuedaCrearUnaBicileta() {
		//Preparacion
		Bicicleta olmo, bianchi;
		Integer id = 1;
		Integer id2 = 2;
		Double volumenDeCargaBicicleta = 0.125;
		Double pesoDeCargaBicileta = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
	    Integer cantidadDePaquetesQueLlevaLaBici = 2;
	    
	    //Ejecucion
	     olmo = new Bicicleta(pesoDeCargaBicileta,cantidadDePaquetesQueLlevaLaBici,volumenDeCargaBicicleta,ciudadesQueViajaElPaqueteEnBicicleta);	
	     bianchi= new Bicicleta(pesoDeCargaBicileta,cantidadDePaquetesQueLlevaLaBici,volumenDeCargaBicicleta,ciudadesQueViajaElPaqueteEnBicicleta);	
	     
	    //Validacion
	    assertNotNull(olmo);
	    assertEquals(id, olmo.getIdBicicleta());
	    assertNotEquals(id, bianchi.getIdBicicleta());
	    assertEquals(id2, bianchi.getIdBicicleta());
	    assertNotEquals(volumenDeCargaBicicleta, olmo.calcularVolumenDelEnvioTotal(), 0.0);
	 
	}
	
	@Test
	public void queSePuedaAgregarUnPaqueteALaBicileta() {
		//Preparacion
		Bicicleta olmo;
		Paquete notbook,celular,impresora;
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
		
		
		//Ejecucion
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.BUENOS_AIRES);
		celular = new Paquete(pesoDePaquete2, altoDePaquete2, anchoDePaquete2, profundidadDePaquete2,argentina.BUENOS_AIRES);		
		impresora = new Paquete(pesoDePaquete3, altoDePaquete3, anchoDePaquete3, profundidadDePaquete3,argentina);
		
		olmo = new Bicicleta(pesoDeCargaBicileta,cantidadDePaquetesQueLlevaLaBici,volumenDeCargaBicicleta,ciudadesQueViajaElPaqueteEnBicicleta);		
		olmo.agregarPaqueteAlEnvio(notbook);
		olmo.agregarPaqueteAlEnvio(notbook);
		olmo.agregarPaqueteAlEnvio(celular);
		assertTrue(olmo.llevarPaquete(ciudadesQueViajaElPaquete));
	}
}
