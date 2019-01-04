package modelo;

public class Butaca {
	
	private int id;
	private int fila;
	private int columna;
	private boolean ocupado;
	
	public Butaca(int id, int fila, int columna, boolean ocupado) {
		super();
		this.id = id;
		this.fila = fila;
		this.columna = columna;
		this.ocupado = ocupado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Butaca [id=" + id + ", fila=" + fila + ", columna=" + columna + ", ocupado=" + ocupado + "]";
	}

	public boolean equals(Butaca butaca){
		return this.fila == butaca.getFila() && this.columna == butaca.getColumna();
	}

	

}
