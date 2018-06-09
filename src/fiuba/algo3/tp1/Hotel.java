package fiuba.algo3.tp1;

public class Hotel {

	private String nombre;
	private Ciudad ciudad;
	private int precioPorNoche;

	public Hotel(String nombreHotel, Ciudad ciudad, int precioPorNoche) {
		
		this.nombre = nombreHotel;
		this.ciudad = ciudad;
		this.precioPorNoche = precioPorNoche;
		
	}

	public boolean soyHotel(String nombreHotel) {
		
		return (this.nombre == nombreHotel);
	}
	
	public boolean soyDeCiudad(Ciudad unaCiudad) {
		
		return (this.ciudad.soyCiudad(unaCiudad.obtenerCodigoCiudad()));
	}

	public int obtenerPrecioPorNoche() {
		
		return precioPorNoche;
	}

	public void modificarCiudad(Ciudad nuevaCiudad) {
		
		this.ciudad = nuevaCiudad;
		
	}

}
