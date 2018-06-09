package fiuba.algo3.tp1;

public class SinComidaEspecialAbordo extends ComidaEspecialABordo {
	//Al no tener comida especial abordo, cuando se le pide agregar los costes, devuelve el mismo precio que le mandaron
	public SinComidaEspecialAbordo(){
		
		this.adicionalPorComidaAbordo = 0;
	}
	
	
	@Override
	public double agregarCostoComidaAbordo(double precioAnterior) {
		
		return (precioAnterior+this.adicionalPorComidaAbordo);
	}

}
