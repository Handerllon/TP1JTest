package fiuba.algo3.tp1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Duracion {
	
	private LocalDate fechaIda;
	private LocalDate fechaVuelta;
	
	public int obtenerDuracion(ArrayList<Servicio> servicios) {
		if (servicios.isEmpty())
			return 0;
		else{
			this.calcularDuracion(servicios);
			//Es el caso en donde solo existe 1 vuelo en el viaje
			if (fechaIda == fechaVuelta)
				return 1;
			else
				//Agregamos un dia, ya que la resta no tomaria en cuenta el "ultimo" o "primer" dia del viaje
				return (int) ((ChronoUnit.DAYS.between(fechaIda,fechaVuelta))+1);
		}
	}

	public void calcularDuracion(ArrayList<Servicio> servicios) {
		//Le damos algun valor valido a cada fecha para luego comparar
		this.fechaIda = servicios.get(0).obtenerFechaInicial();
		this.fechaVuelta = servicios.get(0).obtenerFechaFinal();
		
		for (int x = 0; x<servicios.size();x++){
			if (servicios.get(x).obtenerFechaInicial().isBefore(fechaIda)){
				this.fechaIda = servicios.get(x).obtenerFechaInicial();
			}
			if (servicios.get(x).obtenerFechaFinal().isAfter(fechaVuelta)){
				this.fechaVuelta = servicios.get(x).obtenerFechaFinal();
			}
		}
	}

}
