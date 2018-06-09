package fiuba.algo3.tp1;

import java.util.ArrayList;

public class AlgoTrip {
	
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Viaje> viajes;
	private ArrayList<Hotel> hoteles;
	private ArrayList<Paquete> paquetes;
	
	public AlgoTrip(){
		
		ciudades = new ArrayList<Ciudad>();
		viajes = new ArrayList<Viaje>();
		hoteles = new ArrayList<Hotel>();
		paquetes = new ArrayList<Paquete>();
		
	}
	
	public void crearViaje(String unNombre) throws ViajeYaExisteError{
		
		if (this.viajeExiste(unNombre))
			throw new ViajeYaExisteError();
		
		viajes.add(new Viaje(unNombre));
	}

	public double obtenerCostoDelViaje(String nombreDeViaje) {
		
		Viaje viaje = this.buscarViaje(nombreDeViaje);
		return viaje.obtenerCosto();
	}

	public int obtenerDuracionEnDiasDelViaje(String nombreDeViaje) {
		
		Viaje viaje = this.buscarViaje(nombreDeViaje);
		return viaje.obtenerDuracion();
	}
	
	private void recalcularViajes() {
		for (int x = 0; x<viajes.size();x++){
			viajes.get(x).actualizarCiudades(ciudades);
		}
	}

	public void agregarVueloEnViaje(String nombreViaje, String codigoDeSalida, String codigoDeLlegada, String fecha)
			throws ViajeNoExisteError,CiudadNoExisteError,VueloInvalidoError{
		
		if (!this.viajeExiste(nombreViaje))
			throw new ViajeNoExisteError();
		if (!this.ciudadExiste(codigoDeSalida) || !this.ciudadExiste(codigoDeLlegada))
			throw new CiudadNoExisteError();
		if (codigoDeSalida == codigoDeLlegada)
			throw new VueloInvalidoError();
		
		Viaje viajeAModificar = this.buscarViaje(nombreViaje);
		Ciudad salida = this.buscarCiudad(codigoDeSalida);
		Ciudad llegada = this.buscarCiudad(codigoDeLlegada);
		
		viajeAModificar.agregarVuelo(salida, llegada, fecha);
	}

	public void agregarEstadiaEnViaje(String nombreViaje, String nombreHotel, String fechaCheckIn, String fechaCheckOut) {
		
		Hotel hotel = this.buscarHotel(nombreHotel);
		Viaje viajeAModificar = this.buscarViaje(nombreViaje);
		viajeAModificar.agregarEstadia(hotel,fechaCheckIn,fechaCheckOut);
	}
	
	public void agregarHotel(String nombreHotel, String codigoCiudad, int precioPorNoche)throws HotelYaFueAgregadoError {
		
		if(this.hotelExiste(nombreHotel))
			throw new HotelYaFueAgregadoError();
		
		Ciudad ciudad = this.buscarCiudad(codigoCiudad);
		
		hoteles.add(new Hotel(nombreHotel,ciudad,precioPorNoche));
		
	}
	
	public void agregarPaquete(String unNombreDePaquete)throws PaqueteYaFueCreadoError {
		
		if(this.PaqueteExiste(unNombreDePaquete))
			throw new PaqueteYaFueCreadoError();
		
		Paquete nuevoPaquete = new Paquete(unNombreDePaquete);
		
		paquetes.add(nuevoPaquete);
		
	}
	
	public void agregarVueloEnPaquete(String nombrePaquete, String codigoSalida, String codigoLlegada, String fecha) {
		
		Paquete PaqueteAModificar = this.buscarPaquete(nombrePaquete);
		Ciudad salida = this.buscarCiudad(codigoSalida);
		Ciudad llegada = this.buscarCiudad(codigoLlegada);
		
		PaqueteAModificar.agregarVuelo(salida, llegada, fecha);
	}
	
	
	public void agregarEstadiaEnPaquete(String nombrePaquete, String nombreHotel, String fechaCheckIn, String fechaCheckOut) {
		
		Paquete PaqueteAModificar = this.buscarPaquete(nombrePaquete);
		Hotel hotelBuscado = this.buscarHotel(nombreHotel);
		PaqueteAModificar.agregarEstadia(hotelBuscado,fechaCheckIn,fechaCheckOut);
	}
	
	public void agregarPaqueteEnViaje(String nombreViaje, String nombrePaquete) {
		
		Viaje viajeDeseado = this.buscarViaje(nombreViaje);
		Paquete paqueteDeseado = this.buscarPaquete(nombrePaquete);
		
		viajeDeseado.agregarPaquete(paqueteDeseado);
	}
	
	public void agregarAsistenciaAlViajeroAlViaje(String unNombreDeViaje) {
		
		Viaje viajeDeseado = this.buscarViaje(unNombreDeViaje);
		viajeDeseado.agregarAsistenciaAlViajero();
	}

	public void solicitarComidaEspecialAbordoPara(String unNombreDeViaje) {
		
		Viaje viajeDeseado = this.buscarViaje(unNombreDeViaje);
		viajeDeseado.agregarComidaEspecialABordo();
	}
	
	public void agregarCiudad(String codigoCiudad, String nombreCiudad, String pais, double latitud, double longitud) {
		
		Ciudad ciudadDesactualizada = this.buscarCiudad(codigoCiudad);
		//En el caso de que haya una ciudad desactualizada, actualizamos los datos de todos los viajes
		if (ciudadDesactualizada!= null && ciudadDesactualizada.soyCiudad(codigoCiudad)){
			ciudadDesactualizada.actualizarDatos(latitud,longitud);
			this.recalcularViajes();
		}
		else{
			ciudades.add(new Ciudad(codigoCiudad,nombreCiudad,pais,latitud,longitud));
		}
		
	}
	
	private Hotel buscarHotel(String nombreHotel) {
		Hotel hotelBuscado = null;
		
		for (int x=0;x<hoteles.size();x++){
			
			if (hoteles.get(x).soyHotel(nombreHotel))
				hotelBuscado = hoteles.get(x);
			
		}
		return hotelBuscado;
	}
	
	private Ciudad buscarCiudad (String codigoDeCiudad){
		
		Ciudad ciudadBuscada = null;
		
		for (int x=0;x<ciudades.size();x++){
			
			if (ciudades.get(x).soyCiudad(codigoDeCiudad))
				ciudadBuscada = ciudades.get(x);
			
		}
		return ciudadBuscada;
	}
	
	private Viaje buscarViaje(String nombreViaje) {
		
		Viaje viajeBuscado = null;
		
		for (int x=0;x<viajes.size();x++){
			
			if (viajes.get(x).soyViaje(nombreViaje))
				viajeBuscado = viajes.get(x);
			
		}
		return viajeBuscado;
	}

	private Paquete buscarPaquete(String nombrePaquete) {
		Paquete PaqueteBuscado = null;
		
		for (int x=0;x<paquetes.size();x++){
			
			if (paquetes.get(x).soyPaquete(nombrePaquete))
				PaqueteBuscado = paquetes.get(x);
			
		}
		return PaqueteBuscado;
	}
	
	public boolean viajeExiste(String unNombreDeViaje){
		for (int x = 0; x < viajes.size();x++){
			//Verificamos que no este vacio para que no exista la posibilidad de tomar datos basura
			if(!viajes.isEmpty() && viajes.get(x).soyViaje(unNombreDeViaje))
				return true;
		}
		return false;
	}
	
	public boolean ciudadExiste(String unCodigoDeCiudad){
		for (int x = 0; x < ciudades.size();x++){
			if(!ciudades.isEmpty() && ciudades.get(x).soyCiudad(unCodigoDeCiudad))
				return true;
		}
		return false;
	}
	
	public boolean hotelExiste(String unNombreDeHotel){
		for (int x = 0; x < hoteles.size();x++){
			if(!hoteles.isEmpty() && hoteles.get(x).soyHotel(unNombreDeHotel))
				return true;
		}
		return false;
	}
	
	public boolean PaqueteExiste(String unNombreDePaquete){
		for (int x = 0; x < paquetes.size();x++){
			if(!paquetes.isEmpty() && paquetes.get(x).soyPaquete(unNombreDePaquete))
				return true;
		}
		return false;
	}
	
	
}
