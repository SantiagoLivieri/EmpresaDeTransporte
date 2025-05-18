package alumno.unlam.edu.ar.Transportes;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTransportesTest {

	@Test
	public void queSePuedaCrearUnaBicileta() {
		//Preparacion
		Bicicleta olmo;
		String idPatente = "B0";
		Double volumenDeCargaBicicleta = 0.125;
		Double pesoDeCargaBicileta = 15.0;
	    Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
	    Integer cantidadDePaquetesQueLlevaLaBici = 2;
	    
	    //Ejecucion
	     olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);		
	   
	    //Validacion
	    assertNotNull(olmo);
	    assertEquals(idPatente, olmo.getIdBicicletaPatente());
	    assertNotEquals(volumenDeCargaBicicleta, olmo.calcularVolumenDelEnvioTotal(), 0.0);
	 
	}
	
	@Test
	public void queSePuedaAgregarUnPaqueteALaBicileta() {
		//Preparacion
		Bicicleta olmo;
		Paquete notbook;
		//PAQUETES
		Double pesoDePaquete = 0.5;	
		Double altoDePaquete = 0.3;		
		Double anchoDePaquete = 0.4;
		Double profundidadDePaquete = 0.3;			
		Ciudades argentina = null;
				
		//	BICICLETA
		Double volumenDeCargaBicicleta = 0.125;
		Double pesoDeCargaBicileta = 15.0;
		Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
		Integer cantidadDePaquetesQueLlevaLaBici = 2;
		
		
		//Ejecucion
		notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
		
		olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
		assertTrue(olmo.agregarPaqueteAlEnvio(notbook));
	}
	
		@Test
		public void queLaBicicletaLleveElPaquete() {
			//Preparacion
			Bicicleta olmo;
			Paquete notbook;
			//PAQUETES
			Double pesoDePaquete = 0.5;	
			Double altoDePaquete = 0.3;		
			Double anchoDePaquete = 0.4;
			Double profundidadDePaquete = 0.3;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
			olmo.agregarPaqueteAlEnvio(notbook);
			assertTrue(olmo.llevarPaquete());
	}
		
		@Test
		public void queLaBicicletaLleveDosPaquetesDiferentesConElMismoDestino() {
			//Preparacion
			Bicicleta olmo;
			Paquete notbook, celular;
			
			//PAQUETES
			Double pesoDePaquete = 0.5;	
			Double altoDePaquete = 0.3;		
			Double anchoDePaquete = 0.4;
			Double profundidadDePaquete = 0.3;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
			olmo.agregarPaqueteAlEnvio(notbook);
			olmo.agregarPaqueteAlEnvio(celular);
			assertTrue(olmo.llevarPaquete());
	}
		
		@Test
		public void queLaBicicletaLleveDosPaquetesDiferentesElPrimeroConDestino() {
			//Preparacion
			Bicicleta olmo;
			Paquete notbook, celular;
			
			//PAQUETES
			Double pesoDePaquete = 0.5;	
			Double altoDePaquete = 0.3;		
			Double anchoDePaquete = 0.4;
			Double profundidadDePaquete = 0.3;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina);
			
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
			olmo.agregarPaqueteAlEnvio(notbook);
			olmo.agregarPaqueteAlEnvio(celular);
			assertTrue(olmo.llevarPaquete());
	}
		
		@Test
		public void queLaBicicletaLleveMaximoQuinceKilos() {
			//Preparacion
			Bicicleta olmo;
			Paquete notbook, celular;
			
			//PAQUETES
			Double pesoDePaquete = 7.5;	
			Double altoDePaquete = 0.3;		
			Double anchoDePaquete = 0.4;
			Double profundidadDePaquete = 0.3;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina);
			
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
			olmo.agregarPaqueteAlEnvio(notbook);
			olmo.agregarPaqueteAlEnvio(celular);
			assertTrue(olmo.llevarPaquete());
	}
		
		@Test
		public void queLaBicicletaLleveMaximoCeroPuntoCientoVeinteCincoMetrosCubicos() {
			//Preparacion
			Bicicleta olmo;
			Paquete notbook, celular;
			
			//PAQUETES
			Double pesoDePaquete = 7.5;	
			Double altoDePaquete = 0.5;		
			Double anchoDePaquete = 0.31;
			Double profundidadDePaquete = 0.4;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);
			celular = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina);
			
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			
			olmo.agregarPaqueteAlEnvio(notbook);
			olmo.agregarPaqueteAlEnvio(celular);
			assertTrue(olmo.llevarPaquete());
	}
		
		@Test
		public void queNoSePuedaAgregareAUnaBiciletaVacia() {
			//Preparacion
			Bicicleta olmo = null;
			Paquete notbook;
			EmpresaDeTransporte andreani;
			//PAQUETES
			Double pesoDePaquete = 0.5;	
			Double altoDePaquete = 0.3;		
			Double anchoDePaquete = 0.4;
			Double profundidadDePaquete = 0.3;			
			Ciudades argentina = null;
					
			//	BICICLETA
			Double volumenDeCargaBicicleta = 0.125;
			Double pesoDeCargaBicileta = 15.0;
			Integer ciudadesQueViajaElPaqueteEnBicicleta = 1;
			Integer cantidadDePaquetesQueLlevaLaBici = 2;
			
			
			//Ejecucion
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);		
			andreani = new EmpresaDeTransporte(olmo, notbook);
			//olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);			

			assertFalse(andreani.enviarPedidoADestino());
		}
		
}
