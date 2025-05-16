package alumno.unlam.edu.ar.Transportes;

abstract class Transporte {

		protected Double maxVolumenDeCarga;
		protected Double maxPesoDeCarga;
		protected Integer maxCiudadesQueRecorreElVehiculo;
		

		Transporte(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo){
			this.maxVolumenDeCarga = maxVolumenDeCarga;
			this.maxPesoDeCarga = maxPesoDeCarga; 
			this.maxCiudadesQueRecorreElVehiculo = maxCiudadesQueRecorreElVehiculo;
		}
		
		
		abstract  Integer numeroDePaquete(Paquete paquete);
		abstract  Boolean existePaquete(Paquete paquete);
		abstract void agregarPaqueteAlEnvio(Paquete paquete); 
		
		abstract Double calcularVolumenDelEnvioTotal(); 		
		abstract Double calcularPesoDelEnvioTotal(); 		
		abstract int cantidadDeCiudadesPorEnvio();
		
		abstract Boolean llevarPaquete(Integer maxCiudadesQueRecorreElVehiculo);
		
		
		
}
