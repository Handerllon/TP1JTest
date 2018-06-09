package fiuba.algo3.tp1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CiudadTest {
	
	@Test
	public void test01SoyCiudadEsVerdaderoSiLaComparoConEllaMisma(){
		
		Ciudad ciudad = new Ciudad("BUE","Bueno Aires","Argentina",-37.0,69.8);
		
		assertTrue(ciudad.soyCiudad("BUE"));
		
	}
	
	@Test
	public void test02SoyDelMismoPaisQueEsVerdaderoSiLaOtraCiudadEsDelMismoPais(){
		
		Ciudad ciudad1 = new Ciudad("BUE","Bueno Aires","Argentina",-37.0,69.8);
		Ciudad ciudad2 = new Ciudad("COR","Cordoba","Argentina",96.6,65.2);
		
		assertTrue(ciudad1.soyDelMismoPaisQue(ciudad2));
	}

}
