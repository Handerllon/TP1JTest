package fiuba.algo3.tp1;

public class Ciudad {
	
	private String codigoCiudad;
	@SuppressWarnings("unused")
	private String nombreCiudad;
	private String pais;
	private double latitud;
	private double longitud;
	
	public Ciudad(String codigoCiudad, String nombreCiudad, String pais, double latitud, double longitud) {
		this.codigoCiudad = codigoCiudad;
		this.nombreCiudad = nombreCiudad;
		this.pais = pais;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public boolean soyCiudad(String codigoDeCiudad) {
		
		return (this.codigoCiudad == codigoDeCiudad);
	}
	
	public boolean soyDelMismoPaisQue(Ciudad ciudadAComparar){
		
		return (this.pais == ciudadAComparar.obtenerPais());
		
	}

	private String obtenerPais() {

		return this.pais;
	}

	public double obtenerLatitud() {
		
		return latitud;
	}

	public double obtenerLongitud() {
		
		return longitud;
	}

	public void actualizarDatos(double nuevaLatitud, double nuevaLongitud) {
		this.latitud = nuevaLatitud;
		this.longitud = nuevaLongitud;
	}

	public String obtenerCodigoCiudad() {

		return this.codigoCiudad;
	}

}
