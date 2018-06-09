package fiuba.algo3.tp1;

public abstract class AsistenciaAlViajero {

	protected double adicionalVuelo;
	protected int adicionalHotel;
	
	public abstract double agregarCosteAsistencia(double precioAnterior);
	
	public abstract double agregarCosteAsistencia(double precioAnterior,int duracionEstadia);
}
