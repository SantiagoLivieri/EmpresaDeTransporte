package alumno.unlam.edu.ar.Transportes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Transporte {

		protected Double maxVolumenDeCarga;
		protected Double maxPesoDeCarga;
		protected Integer maxCiudadesQueRecorreElVehiculo;
		private String idTransportePatente;
		int contadorDePaquetesAgregados;
		protected List<Paquete> paquetes; 

		Transporte(Double maxVolumenDeCarga, Double maxPesoDeCarga, Integer maxCiudadesQueRecorreElVehiculo){
			this.maxVolumenDeCarga = maxVolumenDeCarga;
			this.maxPesoDeCarga = maxPesoDeCarga; 
			this.maxCiudadesQueRecorreElVehiculo = maxCiudadesQueRecorreElVehiculo;
			this.paquetes = new ArrayList<>();
			this.contadorDePaquetesAgregados = 0;
			
		}

		public String numeroPaquetePatente(Paquete paquete) {
			return paquete.getIdPaquetePatente();
		}
		
		public Boolean existePaquete(Paquete paquete) {
			 for (Paquete paquete2 : paquetes) {				 
					 if(paquete2 != null) {					
						 if(paquete.equals(paquete2)) {
							//Da verdadero si el paquete que estoy agregando es igual al paquete que ya agrege
					    	  return  true;  
						 }
							//Da falso si el paquete es diferente		      
					 	}		 
				 	}//Da falso si el paquete es nulo 
			 return false; 	
			 	}
		
		
		public Boolean agregarPaqueteAlEnvio(Paquete paquete) {	
				if(paquete != null ){
					if(!existePaquete(paquete)) {
						//Si el paquete que agrego no es nulo	
						paquetes.add(paquete);
						contadorDePaquetesAgregados++;
						return true;
					}
			}		
			return false;
		} 
		
		public Double calcularVolumenDelEnvioTotal() {
			Double volumenDelEnvioTotal = 0.0;
			for (int i = 0; i < paquetes.size(); i++) {
				if(paquetes.get(i) != null )
				volumenDelEnvioTotal += paquetes.get(i).calcularVolumen();
			}
			return volumenDelEnvioTotal;
		}
		
		public Double calcularPesoDelEnvioTotal() {
			Double pesoDelEnvioTotal = 0.0;
			for (int i = 0; i < paquetes.size(); i++) {
				if(paquetes.get(i) != null )
				pesoDelEnvioTotal += paquetes.get(i).getPeso();
			}
			return pesoDelEnvioTotal;
		}
		
		abstract int cantidadDeCiudadesPorEnvio();
		
		abstract Boolean llevarPaquete();


		@Override
		public int hashCode() {
			return Objects.hash(idTransportePatente);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			Transporte other = (Transporte) obj;
			return Objects.equals(idTransportePatente, other.idTransportePatente);
		}
		
		
		
}
