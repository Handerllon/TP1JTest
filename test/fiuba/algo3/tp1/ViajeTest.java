package fiuba.algo3.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ViajeTest {
	
	private static final double DELTA = 1e-1;
	
	@Test
	public void test01DuracionYCostoDeViajeIgualA0CuandoEsCreado(){
		
		Viaje viaje = new Viaje("Vacaciones");
		
		assertEquals(0, viaje.obtenerCosto(), DELTA);
		assertEquals(0, viaje.obtenerDuracion());
	}
	
	@Test
	public void test02ViajeConUnVueloDomestico(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Viaje viaje = new Viaje("Vacaciones");
		
		viaje.agregarVuelo(ciudadDom1, ciudadDom2, "2018-06-01");
		double costoEsperado = (645.97 * 1);
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(1,viaje.obtenerDuracion());
	}

	@Test
	public void test03ViajeConVueloInternacional(){
		
		Ciudad ciudadDom = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Viaje viaje = new Viaje("Vacaciones");
		
		viaje.agregarVuelo(ciudadDom, ciudadInt, "2018-06-01");
		double costoEsperado = 1966.7 * 1.5 * 1.05;
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(1,viaje.obtenerDuracion());
	}
	
	@Test 
	public void test04ViajeConVueloDeIdaYVueltaYVueloEnElMedio(){

		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Ciudad ciudadInt = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Viaje viaje = new Viaje("Vacaciones");
		
		viaje.agregarVuelo(ciudadDom2, ciudadDom1, "2018-06-01");
		viaje.agregarVuelo(ciudadDom1, ciudadInt, "2018-06-06");
		viaje.agregarVuelo(ciudadInt, ciudadDom1, "2018-06-12");
		viaje.agregarVuelo(ciudadDom1, ciudadDom2, "2018-06-13");
		
		double costoEsperado = 2*(645.97 * 1) + 2*(1966.7 * 1.5 * 1.05);
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(13,viaje.obtenerDuracion());
		
	}
	
	@Test
	public void test05ViajeConHotel(){
		Ciudad ciudad = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Hotel hotel = new Hotel("Copacabana Palace", ciudad, 3000);
		Viaje viaje = new Viaje("vacaciones-2018");
		viaje.agregarEstadia(hotel, "2018-06-01", "2018-06-12");
		
		//11 noches
		double costoEsperado = 11*3000;
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		//11 noches pero viaje de 12 dias
		assertEquals(12,viaje.obtenerDuracion());
	}
	
	@Test
	public void test06ViajeConVueloConAsistenciaAlViajero(){
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Viaje viaje = new Viaje("Vacaciones");
		
		viaje.agregarVuelo(ciudadDom1, ciudadInt, "2018-07-29");
		viaje.agregarAsistenciaAlViajero();
		
		//Se le agrega un 10% al costo del vuelo, ya sea domestico o internacional
		double costoEsperado = 1966.7 * 1.5 * 1.05 * 1.1;
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(1,viaje.obtenerDuracion());
	}
	
	@Test
	public void test07ViajeConHotelConAsistenciaAlViajero(){
		Ciudad ciudad = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Hotel hotel = new Hotel("Copacabana Palace", ciudad, 3000);
		Viaje viaje = new Viaje("vacaciones-2018");
		viaje.agregarEstadia(hotel, "2018-06-01", "2018-06-12");
		viaje.agregarAsistenciaAlViajero();
		
		double costoEsperado = (11*3000) + (11*30);
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(12,viaje.obtenerDuracion());
		
	}
	
	@Test
	public void test08ViajeConVueloConComidaEspecialAbordo(){
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Viaje viaje = new Viaje("Vacaciones");
		
		viaje.agregarVuelo(ciudadDom1, ciudadInt, "2018-07-29");
		viaje.agregarVuelo(ciudadInt, ciudadDom1, "2018-08-15");
		viaje.agregarComidaEspecialABordo();
		
		//Se le agrega 100 pesos al costo de cada vuelo, ya sea domestico o internacional
		double costoEsperado = 2*(1966.7 * 1.5 * 1.05)+(2*100);
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(18,viaje.obtenerDuracion());
	}
	
	@Test
	public void test09ViajeConPaqueteConAsistenciaAlViajero(){
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadInt = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Viaje viaje = new Viaje("Vacaciones");
		Paquete paquete = new Paquete("SuperPaquete");
		
		paquete.agregarVuelo(ciudadDom1, ciudadInt, "2018-06-06");
		viaje.agregarPaquete(paquete);
		viaje.agregarAsistenciaAlViajero();
		
		
		double costoEsperado = 1966.7 * 1.5 * 1.05 * 1.1 * 0.9;
		
		assertEquals(costoEsperado,viaje.obtenerCosto(),DELTA);
		assertEquals(1,viaje.obtenerDuracion());
		
	}
	
	@Test 
	public void test10SoyViajeFalsoCuandoElNombreDelViajeEsDiferente(){
		Viaje viaje = new Viaje("Vacaiones1");
		assertFalse(viaje.soyViaje("Vacaciones2"));
	}
}
