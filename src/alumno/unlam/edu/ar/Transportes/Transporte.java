package alumno.unlam.edu.ar.Transportes;

import java.util.Objects;

abstract class Transporte {

		protected Double maxVolumenDeCarga;
		protected Double maxPesoDeCarga;
		protected Integer maxCiudadesQueRecorreElVehiculo;
		private String idAutoPatente;
		

		Transporte(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo){
			this.maxVolumenDeCarga = maxVolumenDeCarga;
			this.maxPesoDeCarga = maxPesoDeCarga; 
			this.maxCiudadesQueRecorreElVehiculo = maxCiudadesQueRecorreElVehiculo;
		}
		
		
		abstract  String numeroPaquetePatente(Paquete paquete);
		abstract  Boolean existePaquete(Paquete paquete);
		abstract Boolean agregarPaqueteAlEnvio(Paquete paquete); 
		
		abstract Double calcularVolumenDelEnvioTotal(); 		
		abstract Double calcularPesoDelEnvioTotal(); 		
		abstract int cantidadDeCiudadesPorEnvio();
		
		abstract Boolean llevarPaquete();


		@Override
		public int hashCode() {
			return Objects.hash(idAutoPatente);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Transporte other = (Transporte) obj;
			return Objects.equals(idAutoPatente, other.idAutoPatente);
		}
		
		
		
}
