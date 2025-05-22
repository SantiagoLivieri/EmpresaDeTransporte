package alumno.unlam.edu.ar.Transportes;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTransportesTest {
	
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
			
			//VALIDACION
			assertFalse(andreani.enviarPedidoADestino());
		}
		
		@Test
		public void queSePuedaAgregarUnPaqueteAlVehiculo() {
			//Preparacion
			Bicicleta olmo;
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
			olmo = new Bicicleta(volumenDeCargaBicicleta, pesoDeCargaBicileta,ciudadesQueViajaElPaqueteEnBicicleta,cantidadDePaquetesQueLlevaLaBici);		
			notbook = new Paquete(pesoDePaquete, altoDePaquete, anchoDePaquete, profundidadDePaquete,argentina.ROSARIO);		
			andreani = new EmpresaDeTransporte(olmo, notbook);
				
			//VALIDACION
			assertTrue(andreani.asignarPaqueteAlVehiculo());
			assertTrue(andreani.enviarPedidoADestino());
			
		}
		
		
		
}
