package fiuba.algo3.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

public class VueloTest {
	
	private static final double DELTA = 1e-2;
	
	@Test
	public void test01CostoVueloDomesticoEsCorrecto(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Vuelo vuelo = new Vuelo(ciudadDom1,ciudadDom2,"2018-06-05");
		
		double costoEsperado = 645.97 * 1;
		//Costo anterior es 0
		assertEquals(costoEsperado,vuelo.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test02CostoVueloDomesticoConAsistenciaAlViajeroEsCorrecto(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Vuelo vuelo = new Vuelo(ciudadDom1,ciudadDom2,"2018-06-05");
		vuelo.agregarAsistenciaAlViajero();
		
		double costoEsperado = 645.97 * 1 * 1.1;
		//Costo anterior es 0
		assertEquals(costoEsperado,vuelo.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test03CostoVueloDomesticoConAsistenciaAlViajeroYComidaAbordoEsCorrecto(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Vuelo vuelo = new Vuelo(ciudadDom1,ciudadDom2,"2018-06-05");
		vuelo.agregarAsistenciaAlViajero();
		vuelo.agregarComidaEspecialAbordo();
		
		double costoEsperado = (645.97 * 1 * 1.1) + 100;
		//Costo anterior es 0
		assertEquals(costoEsperado,vuelo.agregarPrecio(0),DELTA);
	}
	
	
	
}
