package fiuba.algo3.tp1;

public class ConComidaEspecialAbordo extends ComidaEspecialABordo {

	public ConComidaEspecialAbordo(){
		
		//El coste por tener comida especial abordo es de 100 pesos
		this.adicionalPorComidaAbordo = 100;
	}
	
	@Override
	public double agregarCostoComidaAbordo(double precioAnterior) {
		
		return precioAnterior+this.adicionalPorComidaAbordo;
	}

}
