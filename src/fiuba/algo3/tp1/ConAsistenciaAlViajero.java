package fiuba.algo3.tp1;

public class ConAsistenciaAlViajero extends AsistenciaAlViajero {


	public ConAsistenciaAlViajero(){
		
		//El vuelo tiene un 10% de coste adicional por tener asistencia al viajero
		this.adicionalVuelo = 0.1;
		//Cada noche del hotel cuesta 30 pesos mas por tener asistencia al viajero
		this.adicionalHotel = 30;
	}
	
	@Override
	public double agregarCosteAsistencia(double precioAnterior) {

		return precioAnterior+(precioAnterior*this.adicionalVuelo);
	}
	
	@Override
	public double agregarCosteAsistencia(double precioAnterior, int duracionEstadia){
		
		return precioAnterior+(duracionEstadia*this.adicionalHotel);
	}


}
