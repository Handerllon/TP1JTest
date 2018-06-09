package fiuba.algo3.tp1;

import java.util.ArrayList;

public class Viaje {

	private String nombreViaje;
	private ArrayList<Servicio> servicios;
	private double costo;
	private Duracion duracion;
	
	public Viaje(String unNombre) {
		nombreViaje = unNombre;
		servicios = new ArrayList<Servicio>();
		costo = 0;
		duracion = new Duracion();
	}

	public boolean soyViaje(String nombreViaje) {
		
		return (this.nombreViaje == nombreViaje);
		
	}

	public void agregarVuelo(Ciudad salida, Ciudad llegada, String fecha) {
		
		Vuelo nuevoVuelo;
		
		if (!salida.soyDelMismoPaisQue(llegada)){
			nuevoVuelo = new VueloInternacional(salida,llegada,fecha);
		}
		else{
			nuevoVuelo = new Vuelo(salida,llegada,fecha);
		}
		servicios.add(nuevoVuelo);
	}
	
	public double obtenerCosto() {
		this.costo = 0;
		if (!servicios.isEmpty()){
			for (int x=0; x < servicios.size();x++){
				costo = servicios.get(x).agregarPrecio(costo);
			}
		}
		return costo;
	}

	public int obtenerDuracion() {
		
		return duracion.obtenerDuracion(servicios);
	}

	public void actualizarCiudades(ArrayList<Ciudad> ciudades) {
		for (int x=0; x < servicios.size();x++){
			servicios.get(x).actualizarDatos(ciudades);
		}
		return;
	}

	public void agregarEstadia(Hotel hotel, String fechaCheckIn, String fechaCheckOut) {
		
		Estadia nuevaEstadia = new Estadia(hotel, fechaCheckIn,fechaCheckOut);
		
		servicios.add(nuevaEstadia);
	}

	public void agregarAsistenciaAlViajero() {
		//Cada elemento de servicios hara algo diferente cuando se le agregue asistencia al viajero
		for (int x = 0; x<servicios.size();x++){
			servicios.get(x).agregarAsistenciaAlViajero();
		}
	}

	public void agregarComidaEspecialABordo() {
		//Nuevamente cada elemento de servicio hace algo diferente. En este caso las estadias no deben
		//Realizar ninguna accion
		for (int x = 0; x<servicios.size();x++){
			servicios.get(x).agregarComidaEspecialAbordo();
		}
		
	}
	
	public void agregarPaquete(Paquete paqueteDeseado) {

		servicios.add(paqueteDeseado);
	}

}
