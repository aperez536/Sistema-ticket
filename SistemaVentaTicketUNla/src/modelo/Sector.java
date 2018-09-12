package modelo;

public class Sector {
	
	protected String tipo;

	public Sector(String tipo) throws Exception{
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Evento [tipo=" + tipo + "]";
	}

}
