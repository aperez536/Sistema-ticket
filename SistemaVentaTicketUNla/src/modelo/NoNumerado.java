package modelo;

public class NoNumerado extends Sector{
	
	private int espacioDisponible;

	public NoNumerado(String tipo, int espacioDisponible) throws Exception {
		super(tipo);
		this.espacioDisponible = espacioDisponible;
	}

	public int getEspacioDisponible() {
		return espacioDisponible;
	}

	public void setEspacioDisponible(int espacioDisponible) {
		this.espacioDisponible = espacioDisponible;
	}

	@Override
	public String toString() {
		return super.toString() + " NoNumerado [espacioDisponible=" + espacioDisponible + "]";
	}
	
	
	
	

}
