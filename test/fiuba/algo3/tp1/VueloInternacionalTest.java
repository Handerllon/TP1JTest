package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VueloInternacionalTest {

	private static final double DELTA = 1e-2;
	
	@Test
	public void test01CostoVueloInternacionalEsCorrecto(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt1 =  new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Vuelo vuelo = new VueloInternacional(ciudadDom1,ciudadInt1,"2018-06-05");
		
		double costoEsperado = 1966.7 * 1.5 * 1.05;
		//Costo anterior es 0
		assertEquals(costoEsperado,vuelo.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test02CostoVueloInternacionalConAsistenciaYComidaAbordoEsCorrecto(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt1 =  new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Vuelo vuelo = new VueloInternacional(ciudadDom1,ciudadInt1,"2018-06-05");
		vuelo.agregarAsistenciaAlViajero();
		vuelo.agregarComidaEspecialAbordo();
		
		double costoEsperado = (1966.7 * 1.5 * 1.05 * 1.1) + 100;

		//Costo anterior es 0
		assertEquals(costoEsperado,vuelo.agregarPrecio(0),DELTA);
	}
	
}
