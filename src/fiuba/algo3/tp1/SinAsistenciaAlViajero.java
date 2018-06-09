package fiuba.algo3.tp1;

public class SinAsistenciaAlViajero extends AsistenciaAlViajero {
	//Al no tener asistencia, cuando se le pide agregar los costes, devuelve el mismo precio que le mandaron
	public SinAsistenciaAlViajero(){
		
		this.adicionalVuelo = 0.0;
		this.adicionalHotel = 0;
	}
	
	@Override
	public double agregarCosteAsistencia(double precioAnterior) {

		return (precioAnterior);
	}
	
	@Override
	public double agregarCosteAsistencia(double precioAnterior,int duracionEstadia){
		
		return (precioAnterior);
	}

}
