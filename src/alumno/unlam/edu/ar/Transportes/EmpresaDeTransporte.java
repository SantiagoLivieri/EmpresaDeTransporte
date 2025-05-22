package alumno.unlam.edu.ar.Transportes;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDeTransporte {
	
	private Transporte vehiculo;
	private Paquete paquete;
	//protected List<Transporte> vehiculo; 

	EmpresaDeTransporte(Transporte vehiculo, Paquete paquete){
		//this.vehiculo = new ArrayList<>();
		this.vehiculo = vehiculo;
		this.paquete = paquete;
	}
	
	
	public Boolean asignarPaqueteAlVehiculo() {
		if(vehiculo.agregarPaqueteAlEnvio(paquete)) {
			return true;
		}
		return false;
	}
	
	public Boolean enviarPedidoADestino() {
		 if(this.paquete != null && this.vehiculo != null){
			 vehiculo.llevarPaquete();
			 return true;
		 }
		return false;
	}
	
}


