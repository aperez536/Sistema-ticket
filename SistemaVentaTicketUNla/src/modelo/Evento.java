package modelo;
import java.util.*;
public class Evento {
	
	private int idEvento;
	private String titulo;
	private String tipoEvento;
	private List<PrecioSector> listaPrecios;
	private List<Funcion> listaFuncion;
	
	public Evento(int idEvento, String titulo, String tipoEvento)throws Exception {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
		this.listaPrecios = new ArrayList<PrecioSector>();
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

	public List<PrecioSector> getListaPrecios() {
		return listaPrecios;
	}

	public List<Funcion> getListaFuncion() {
		return listaFuncion;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", titulo=" + titulo + ", tipoEvento=" + tipoEvento + ", listaPrecios="
				+ listaPrecios + ", listaFuncion=" + listaFuncion + "]";
	}

	public boolean equals(Evento e){
		return idEvento == e.getIdEvento();
	}

	public Funcion traerFuncion(int idFuncion){
		Funcion f = null;
		int i = 0;
		while(f == null && i < listaFuncion.size()){
			if(listaFuncion.get(i).getIdFuncion() == idFuncion) f = listaFuncion.get(i);
			i++;
		}
		return f;
	}
	
	public boolean agregarFuncion(GregorianCalendar fechaInicio,GregorianCalendar fechaFin,double descuento)throws Exception{
		int proxId = 0;
		if(listaFuncion.size() == 0) proxId = 1;
		else proxId = listaFuncion.get(listaFuncion.size() - 1).getIdFuncion() + 1;
		return listaFuncion.add(new Funcion(proxId,fechaInicio,fechaFin,descuento));
	}
	
	public boolean eliminarFuncion(int idFuncion)throws Exception{
		Funcion f = traerFuncion(idFuncion);
		if(f == null)throw new Exception("ERROR no se pudo eliminar la funcion");
		return listaFuncion.remove(f);
	}
	
	public boolean modificarFuncion(int idFuncion,GregorianCalendar fechaInicio,GregorianCalendar fechaFin,double descuento)throws Exception{
		Funcion f = traerFuncion(idFuncion);
		if(f == null)throw new Exception("ERROR no se pudo modificar la funcion");
		f.setFechaInicio(fechaInicio);
		f.setFechaFin(fechaFin);
		f.setDescuento(descuento);
		return true;
	}
	

	
}
