package alumno.unlam.edu.ar.Transportes;

public class EmpresaDeTransporte {
	
	private Transporte vehiculo;
	private Paquete paquete;

	EmpresaDeTransporte(Transporte vehiculo, Paquete paquete){
		this.vehiculo = vehiculo;
		this.paquete = paquete;
	}
	
	public Boolean enviarPedidoADestino() {
		 if(this.paquete != null && this.vehiculo != null){
			 vehiculo.llevarPaquete();
			 return true;
		 }
		return false;
	}

}


