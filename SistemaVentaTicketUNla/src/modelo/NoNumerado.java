package modelo;

public class NoNumerado extends Sector{
	
	private int espacioDisponible;
	private int espacioTotal;

	public NoNumerado(String tipo, int espacioDisponible,int espacioTotal) throws Exception {
		super(tipo);
		this.espacioDisponible = espacioDisponible;
		this.espacioTotal = espacioTotal;
	}

	public int getEspacioDisponible() {
		return espacioDisponible;
	}

	public void setEspacioDisponible(int espacioDisponible) {
		this.espacioDisponible = espacioDisponible;
	}

	public int getEspacioTotal() {
		return espacioTotal;
	}

	public void setEspacioTotal(int espacioTotal) {
		this.espacioTotal = espacioTotal;
	}

	@Override
	public String toString() {
		return "NoNumerado [espacioDisponible=" + espacioDisponible + ", espacioTotal=" + espacioTotal + "]";
	}

	
	
	
	
	

}
