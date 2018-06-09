package fiuba.algo3.tp1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paquete implements Servicio {

	private String nombrePaquete;
	private ArrayList<Servicio> serviciosEnPaquete;
	private double descuentoEnVuelos;
	private double descuentoEnHoteles;
	
	public Paquete (String unNombreDePaquete){
		
		this.nombrePaquete = unNombreDePaquete;
		this.serviciosEnPaquete = new ArrayList<Servicio>();
		//Si multiplicamos por 0.8 aplica un 20% de descuento en hoteles, propio de comprar un paquete
		this.descuentoEnHoteles = 0.8;
		//Si multiplicamos por 0.9 aplica un 10% de descuento en vuelos, propio de comprar un paquete
		this.descuentoEnVuelos = 0.9;
	}

	public void agregarVuelo(Ciudad salida, Ciudad llegada, String fecha) {
		Vuelo nuevoVuelo;
		
		if (!salida.soyDelMismoPaisQue(llegada)){
			nuevoVuelo = new VueloInternacional(salida,llegada,fecha);
		}
		else{
			nuevoVuelo = new Vuelo(salida,llegada,fecha);
		}
		
		serviciosEnPaquete.add(nuevoVuelo);
		
	}

	public void agregarEstadia(Hotel hotelBuscado, String fechaCheckIn, String fechaCheckOut) {
		
		Estadia nuevaEstadia = new Estadia(hotelBuscado, fechaCheckIn,fechaCheckOut);
		
		serviciosEnPaquete.add(nuevaEstadia);
	}
	
	public boolean soyPaquete(String nombrePaquete) {
		
		return (this.nombrePaquete == nombrePaquete);
	}

	@Override
	//El precio del paquete serian los precios de cada uno de los servicios dentro de el
	//Tenemos que diferenciar los hoteles de los vuelos para realizar el descuento
	public double agregarPrecio(double precioAnterior) {
		double costoHoteles = 0;
		double costoVuelos = 0;
		if (!serviciosEnPaquete.isEmpty()){
			for (int x=0; x < serviciosEnPaquete.size();x++){
				//Sabemos que dentro de paquete solo puede haber vuelos o hoteles, entonces los diferenciamos
				if (serviciosEnPaquete.get(x) instanceof Vuelo)
					costoVuelos = serviciosEnPaquete.get(x).agregarPrecio(costoVuelos);
				else
					//Caso que es un hotel
					costoHoteles = serviciosEnPaquete.get(x).agregarPrecio(costoHoteles);
			}
		}
		//Devuelve el precio de vuelos con un 10% de dto y el de hoteles con un 20% de dto
		return (costoVuelos*this.descuentoEnVuelos)+(costoHoteles*this.descuentoEnHoteles);
	}

	@Override
	//Hace lo mismo que viaje cuando se le pide actualizar datos
	public void actualizarDatos(ArrayList<Ciudad> ciudades) {
		for (int x=0; x < serviciosEnPaquete.size();x++){
			serviciosEnPaquete.get(x).actualizarDatos(ciudades);
		}
		return;
		
	}

	@Override
	public void agregarAsistenciaAlViajero() {
		//Suponemos que el paquete viene sin asistencia al viajero, si se quiere se le puede agregar
		for (int x = 0; x<serviciosEnPaquete.size();x++){
			serviciosEnPaquete.get(x).agregarAsistenciaAlViajero();
		}	
	}

	@Override
	public void agregarComidaEspecialAbordo() {
		//Suponemos que los vuelos en el paquete vienen sin comida especial Abordo
		for (int x = 0; x<serviciosEnPaquete.size();x++){
			serviciosEnPaquete.get(x).agregarComidaEspecialAbordo();
		}
	}
	
	//Para el manejo de fechas de paquete tendremos que replicar lo que hace la clase Duracion en viaje
	//Solo que separado en dos tramos, la fecha inicial y final. Pero del paquete
	@Override
	public LocalDate obtenerFechaInicial() {
		//Le damos algun valor valido a fechaInicail para luegoComparar
		LocalDate fechaIda = serviciosEnPaquete.get(0).obtenerFechaInicial();
				
		for (int x = 0; x<serviciosEnPaquete.size();x++){
			if (serviciosEnPaquete.get(x).obtenerFechaInicial().isBefore(fechaIda)){
				fechaIda = serviciosEnPaquete.get(x).obtenerFechaInicial();
			}
		}
		return fechaIda;
	}
	
	@Override
	public LocalDate obtenerFechaFinal() {
		//Le damos algun valor valido a fechaInicail para luegoComparar
		LocalDate fechaVuelta = serviciosEnPaquete.get(0).obtenerFechaFinal();
						
		for (int x = 0; x<serviciosEnPaquete.size();x++){
			if (serviciosEnPaquete.get(x).obtenerFechaFinal().isAfter(fechaVuelta)){
				fechaVuelta = serviciosEnPaquete.get(x).obtenerFechaFinal();
			}
		}
		return fechaVuelta;
	}

}
