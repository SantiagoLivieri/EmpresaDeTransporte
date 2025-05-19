package alumno.unlam.edu.ar.Transportes;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDeTransporte {
	
	private Transporte vehiculo;
	private Paquete paquete;
	private List<Paquete> paquetes; 

	EmpresaDeTransporte(Transporte vehiculo, Paquete paquete){
		this.vehiculo = vehiculo;
		this.paquete = paquete;
		this.paquetes = new ArrayList<>();
	}
	
	public Boolean enviarPedidoADestino() {
		 if(this.paquete != null && this.vehiculo != null){
			 vehiculo.llevarPaquete();
			 return true;
		 }
		return false;
	}

}


