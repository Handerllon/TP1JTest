package fiuba.algo3.tp1;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PaqueteTest {

	private static final double DELTA = 1e-2;
	
	@Test
	public void test01CosteDePaqueteCorrectoConVueloYHotel(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Paquete paquete = new Paquete("SuperVacaciones");
		Hotel hotel = new Hotel("Hotel",ciudadDom2,3000);
		
		paquete.agregarEstadia(hotel, "2018-06-01", "2018-06-07");
		paquete.agregarVuelo(ciudadDom1, ciudadDom2, "2018-06-01");
		
		double costoHotel = 3000*6;
		double costoVuelo = 645.97 * 1;
		double costoEsperado = 0.8*(costoHotel) + 0.9*(costoVuelo);
		//El precio anterior en este caso es 0
		assertEquals(costoEsperado,paquete.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test02CosteDePaqueteCorrectoConVueloYHotelYAsistenciaAlViajero(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Paquete paquete = new Paquete("SuperVacaciones");
		Hotel hotel = new Hotel("Hotel",ciudadDom2,3000);
		
		paquete.agregarEstadia(hotel, "2018-06-01", "2018-06-07");
		paquete.agregarVuelo(ciudadDom1, ciudadDom2, "2018-06-01");
		paquete.agregarAsistenciaAlViajero();
		
		double costoHotel = (3000*6) + (30*6);
		double costoVuelo = 645.97 * 1 * 1.1;
		double costoEsperado = 0.8*(costoHotel) + 0.9*(costoVuelo);
		//El precio anterior en este caso es 0
		assertEquals(costoEsperado,paquete.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test03CosteDePaqueteCorrectoConDosVuelosYHotelYAsistenciaAlViajeroYComidaAbordo(){
		
		Ciudad ciudadDom1 = new Ciudad("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Paquete paquete = new Paquete("SuperVacaciones");
		Hotel hotel = new Hotel("HotelNacionalCordoba",ciudadDom2,3000);
		
		paquete.agregarEstadia(hotel, "2018-06-01", "2018-06-07");
		paquete.agregarVuelo(ciudadDom1, ciudadDom2, "2018-06-01");
		paquete.agregarVuelo(ciudadDom2, ciudadDom1, "2018-06-08");
		paquete.agregarAsistenciaAlViajero();
		paquete.agregarComidaEspecialAbordo();
		
		double costoHotel = (3000*6) + (30*6);
		double costoVuelo = 2*(645.97 * 1 * 1.1) + (2*100);
		double costoEsperado = 0.8*(costoHotel) + 0.9*(costoVuelo);
		//El precio anterior en este caso es 0
		assertEquals(costoEsperado,paquete.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test04FechaInicialYFinalCorrectas(){
		
		Ciudad ciudadDom2 = new Ciudad("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Paquete paquete = new Paquete("SuperVacaciones");
		Hotel hotel = new Hotel("Hotel",ciudadDom2,3000);
		
		paquete.agregarEstadia(hotel, "2018-06-01", "2018-06-07");
		LocalDate fechaInicial = LocalDate.parse("2018-06-01");
		LocalDate fechaFinal = LocalDate.parse("2018-06-07");
		LocalDate fechaInicialPaquete = paquete.obtenerFechaInicial();
		LocalDate fechaFinalPaquete = paquete.obtenerFechaFinal();
		
		assertTrue(fechaInicial.isEqual(fechaInicialPaquete));
		assertTrue(fechaFinal.isEqual(fechaFinalPaquete));
	}
}
