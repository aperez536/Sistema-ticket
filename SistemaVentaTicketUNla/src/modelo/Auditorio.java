package modelo;
import java.util.*;
public class Auditorio {

	private int idAuditorio;
	private String tipo;
	private String nombre;
	private String direccion;
	private List<Evento> listaEvento;
	private List<Sector> sectores;
	
	public Auditorio(int idAuditorio, String tipo, String nombre, String direccion) 
	{
		super();
		this.idAuditorio = idAuditorio;
		this.tipo = tipo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaEvento = new ArrayList<Evento>();
		this.sectores = new ArrayList<Sector>();
	}

	public int getIdAuditorio() {
		return idAuditorio;
	}

	public void setIdAuditorio(int idAuditorio) {
		this.idAuditorio = idAuditorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(List<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

	public String getTipo() {
		return tipo;
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	@Override
	public String toString() {
		return "Auditorio [idAuditorio=" + idAuditorio + ", tipo=" + tipo + ", nombre=" + nombre + ", direccion="
				+ direccion + ", listaEvento=" + listaEvento + ", sectores=" + sectores + "]";
	}
	public boolean equals(Auditorio auditorio) {
		return getIdAuditorio() == idAuditorio;
	}
  
}
