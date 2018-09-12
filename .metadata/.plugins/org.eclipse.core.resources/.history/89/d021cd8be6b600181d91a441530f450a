package modelo;
import java.util.*;
public class Evento {
	
	private int idEvento;
	private String titulo;
	private String tipoEvento;
	private Auditorio auditorio;
	private PrecioSector precioEvento;
	private List<Funcion> listaFuncion;
	
	public Evento(int idEvento, String titulo, String tipoEvento, Auditorio auditorio, PrecioSector precioEvento) {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
		this.auditorio = auditorio;
		this.precioEvento = precioEvento;
		this.listaFuncion = new ArrayList<Funcion>();
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Auditorio getAuditorio() {
		return auditorio;
	}

	public void setAuditorio(Auditorio auditorio) {
		this.auditorio = auditorio;
	}

	public PrecioSector getPrecioEvento() {
		return precioEvento;
	}

	public void setPrecioEvento(PrecioSector precioEvento) {
		this.precioEvento = precioEvento;
	}

	public List<Funcion> getListaFuncion() {
		return listaFuncion;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", titulo=" + titulo + ", tipoEvento=" + tipoEvento + ", auditorio="
				+ auditorio + ", precioEvento=" + precioEvento + ", listaFuncion=" + listaFuncion + "]";
	}
	
	public boolean equals(Evento evento) {
		return getIdEvento() == idEvento;
	}
	
}
