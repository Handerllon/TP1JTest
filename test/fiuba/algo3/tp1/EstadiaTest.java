package fiuba.algo3.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstadiaTest {

	private static final double DELTA = 1e-2;
	
	@Test
	public void test01PrecioDeEstadiaCorrectoSinAsistenciaAlViajero(){
		
		Ciudad rio = new Ciudad("RIO","Rio de Janeiro","Brasil",65.6,54.2);
		Hotel hotel = new Hotel("Copacabana Palace", rio, 3000);
		
		Estadia estadia = new Estadia(hotel, "2018-06-01", "2018-06-07");
		
		double precioEsperado = 3000*6;
		//El precioAnterior, parametro de agregarPrecio, es 0 en este caso
		assertEquals(precioEsperado, estadia.agregarPrecio(0),DELTA);
	}
	
	@Test
	public void test02PrecioDeEstadiaCorrectoConAsistenciaAlViajero(){
		
		Ciudad rio = new Ciudad("RIO","Rio de Janeiro","Brasil",65.6,54.2);
		Hotel hotel = new Hotel("Copacabana Palace", rio, 3000);
		
		Estadia estadia = new Estadia(hotel, "2018-06-01", "2018-06-07");
		estadia.agregarAsistenciaAlViajero();
		
		double precioEsperado = 3000*6 + (6*30);
		//El precioAnterior, parametro de agregarPrecio, es 0 en este caso
		assertEquals(precioEsperado, estadia.agregarPrecio(0),DELTA);
	}
	
}
