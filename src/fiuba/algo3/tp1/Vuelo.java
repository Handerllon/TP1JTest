package fiuba.algo3.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vuelo implements Servicio{

	private Coordenada coordenada;
	private LocalDate fecha;
	private AsistenciaAlViajero asistenciaAlViajero;
	private ComidaEspecialABordo comidaEspecialAbordo;
	
	public Vuelo(Ciudad salida, Ciudad llegada, String fecha) {
		
		this.coordenada = new Coordenada(salida,llegada);
		this.fecha = LocalDate.parse(fecha);
		this.asistenciaAlViajero = new SinAsistenciaAlViajero();
		this.comidaEspecialAbordo = new SinComidaEspecialAbordo();
	}
	
	public void agregarAsistenciaAlViajero(){
		
		this.asistenciaAlViajero = new ConAsistenciaAlViajero();
	}
	
	public void agregarComidaEspecialAbordo(){
		
		this.comidaEspecialAbordo = new ConComidaEspecialAbordo();
	}
	
	public double agregarPrecio(double precioAnterior){
		double precio = 0.0;
		
		// Cuesta 1 peso por km
		precio = this.coordenada.obtenerDistancia()*1;
		
		//Si enviamos solo el precio, que es double a agregarCosteAsistencia, le agregara un 10%, ya que
		// sabra por el parametro que se trata de un vuelo
		precio = this.asistenciaAlViajero.agregarCosteAsistencia(precio);
		precio = this.comidaEspecialAbordo.agregarCostoComidaAbordo(precio);
		
		return (precioAnterior+precio);
	}
	
	public void actualizarDatos (ArrayList<Ciudad> ciudades){
		
		this.coordenada.renovarCoordenadas(ciudades);
		
		return;
	}
	
	public Coordenada getCoordenada(){
		
		return this.coordenada;
	}
	
	//No existe diferencia de fechas entre un mismo vuelo, pero ponemos estos metodos para cumplir con la
	//Interface, devolviendo la misma fecha hace que, al haber 1 solo vuelo en servicios, la duracion sea de 1 dia
	public LocalDate obtenerFechaInicial() {
		
		return fecha;
	}

	public LocalDate obtenerFechaFinal() {
		
		return fecha;
	}
}
