package fiuba.algo3.tp1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Estadia implements Servicio{
	
	private Hotel hotel;
	private LocalDate fechaCheckIn;
	private LocalDate fechaCheckOut;
	private AsistenciaAlViajero asistenciaAlViajero;
	
	public Estadia(Hotel hotel, String fechaCheckIn, String fechaCheckOut) {
		
		this.hotel = hotel;
		this.fechaCheckIn = LocalDate.parse(fechaCheckIn);
		this.fechaCheckOut = LocalDate.parse(fechaCheckOut);
		this.asistenciaAlViajero = new SinAsistenciaAlViajero();
	}

	public void agregarAsistenciaAlViajero(){
		
		this.asistenciaAlViajero = new ConAsistenciaAlViajero();
	}
	
	public double agregarPrecio(double precioAnterior) {
		double precio = 0;
		int dias = 0;

		dias = (int) ((ChronoUnit.DAYS.between(fechaCheckIn,fechaCheckOut)));
		precio = dias*(hotel.obtenerPrecioPorNoche());
		
		//Al llamar agregarCosteAsistencia con los dias y el precio, sabe que se trata del hotel
		precio = this.asistenciaAlViajero.agregarCosteAsistencia(precio, dias);
		return (precioAnterior+precio);
	}

	public void actualizarDatos(ArrayList<Ciudad> ciudades) {
		//Al hotel no le interesa la coordenada de la ciudad si esta es cambiada, pero de todas maneras
		//actualizamos el dato por si en algun momento llega a ser necesario
		for (int x = 0; x<ciudades.size();x++){
			if(this.hotel.soyDeCiudad(ciudades.get(x)))
				this.hotel.modificarCiudad(ciudades.get(x));
		}
	}

	public LocalDate obtenerFechaInicial() {
		
		return fechaCheckIn;
	}

	public LocalDate obtenerFechaFinal() {
		
		return fechaCheckOut;
	}

	public void agregarComidaEspecialAbordo() {
		//No debe hacer nada
		
	}

}
