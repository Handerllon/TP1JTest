package fiuba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class CoordenadaTest {

	private static final double DELTA = 1e-2;	
	
	@Test
	public void test01DistanciaCorrectaEntreBuenosAiresYCordoba(){
		
		Ciudad BsAs = new Ciudad ("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad Cor = new Ciudad ("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Coordenada coordenada = new Coordenada(BsAs,Cor);
		
		Double distanciaEsperada = 645.97;
		
		assertEquals(distanciaEsperada,coordenada.obtenerDistancia(),DELTA);
	}
	
	@Test
	public void test02DistanciaCorrectaEntreBuenosAiresYRio(){
		
		Ciudad BsAs = new Ciudad ("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad rio = new Ciudad("RIO", "Rio", "Brasil", -22.90, -43.19);
		Coordenada coordenada = new Coordenada(BsAs,rio);
		
		Double distanciaEsperada = 1966.7;
		
		assertEquals(distanciaEsperada,coordenada.obtenerDistancia(),DELTA);
		
	}
	
	@Test
	public void test03LaDistanciaSeCorrigeCorrectamenteLuegoDeUnCambioDeLatitudesYLongitudes(){
		
		Ciudad BsAs = new Ciudad ("BUE", "Buenos Aires", "Argentina", -34.60, -58.38);
		Ciudad CorIncorrecta = new Ciudad ("COR", "Cordoba", "Argentina",-22.90, -43.19);
		Ciudad CorCorrecta = new Ciudad ("COR", "Cordoba", "Argentina", -31.42, -64.18);
		Coordenada coordenada = new Coordenada (BsAs,CorIncorrecta);
		
		Double distanciaPreCorreccion = 1966.7;
		Double distanciaPostCorreccion = 645.97;
		
		assertEquals(distanciaPreCorreccion,coordenada.obtenerDistancia(),DELTA);
		
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		ciudades.add(BsAs);
		ciudades.add(CorCorrecta);
		coordenada.renovarCoordenadas(ciudades);
		
		assertEquals(distanciaPostCorreccion,coordenada.obtenerDistancia(),DELTA);
	}
	
	
}
