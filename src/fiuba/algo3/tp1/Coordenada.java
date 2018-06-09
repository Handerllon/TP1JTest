package fiuba.algo3.tp1;

import java.util.ArrayList;

public class Coordenada {

	private double latitudSalida;
	private double longitudSalida;
	private double latitudLlegada;
	private double longitudLlegada;
	private Ciudad llegada;
	private Ciudad salida;
	
	public Coordenada(Ciudad salida, Ciudad llegada) {
		this.salida = salida;
		this.llegada = llegada;
	}
	
	public double obtenerDistancia(){
		
		latitudSalida = salida.obtenerLatitud();
		longitudSalida = salida.obtenerLongitud();
		latitudLlegada = llegada.obtenerLatitud();
		longitudLlegada = llegada.obtenerLongitud();
		
		double distancia = 0.0;
		double radioTerrestre = 6371.00;
		
		double lat1 = Math.toRadians(latitudSalida);
		double lon1 = Math.toRadians(longitudSalida);
		double lat2 = Math.toRadians(latitudLlegada);
		double lon2 = Math.toRadians(longitudLlegada);
		
		double dLat = lat2 - lat1;
		double dLon = lon2 - lon1;
		
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +  
		         Math.cos(lat1) * Math.cos(lat2) *  
		         Math.sin(dLon/2) * Math.sin(dLon/2);  
		double c = 2 * Math.asin(Math.sqrt(a)); 
		
		distancia = radioTerrestre * c;
		
		return distancia;
	}

	public void renovarCoordenadas(ArrayList<Ciudad> ciudades) {
		//Como no sabemos que coordenadas se actualizaron, actualizamos ambas, salida y llegada
		for (int x=0; x<ciudades.size();x++){
			if (ciudades.get(x).soyCiudad(salida.obtenerCodigoCiudad())){
				this.salida = ciudades.get(x);
			}
			if (ciudades.get(x).soyCiudad(llegada.obtenerCodigoCiudad())){
				this.llegada = ciudades.get(x);
			}
		}
	}
	
}
