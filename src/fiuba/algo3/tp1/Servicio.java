package fiuba.algo3.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

public interface Servicio {
	
	public double agregarPrecio(double precioAnterior);

	public void actualizarDatos(ArrayList<Ciudad> ciudades);
	
	public LocalDate obtenerFechaInicial();
	
	public LocalDate obtenerFechaFinal();

	public void agregarAsistenciaAlViajero();

	public void agregarComidaEspecialAbordo();
	
}
