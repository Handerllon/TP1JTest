package fiuba.algo3.tp1;

public class VueloInternacional extends Vuelo {
	
	private Coordenada coordenada;
	private AsistenciaAlViajero asistenciaAlViajero;
	private ComidaEspecialABordo comidaEspecialAbordo;
	
	public VueloInternacional(Ciudad salida, Ciudad llegada, String fecha) {
		super(salida, llegada, fecha);
		//this.coordenada = super.getCoordenada();
		this.coordenada = new Coordenada(salida,llegada);
		this.asistenciaAlViajero = new SinAsistenciaAlViajero();
		this.comidaEspecialAbordo = new SinComidaEspecialAbordo();
	}
	
	public double agregarPrecio(double precioAnterior){
		
		double precio = 0.0;
		
		// Cuesta 1.5 pesos por Km. con un 5% de impuesto
		
		precio = this.coordenada.obtenerDistancia()*1.5*1.05;

		//Si enviamos solo el precio, que es double a agregarCosteAsistencia, le agregara un 10%, ya que
		// sabra por el parametro que se trata de un vuelo
		precio = this.asistenciaAlViajero.agregarCosteAsistencia(precio);
		precio = this.comidaEspecialAbordo.agregarCostoComidaAbordo(precio);
		
		return (precioAnterior+precio);
	}
	
	public void agregarAsistenciaAlViajero(){
		
		this.asistenciaAlViajero = new ConAsistenciaAlViajero();
	}
	
	public void agregarComidaEspecialAbordo(){
		
		this.comidaEspecialAbordo = new ConComidaEspecialAbordo();
	}
	
}
