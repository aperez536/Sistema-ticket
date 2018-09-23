package modelo;
import java.util.*;
public class Evento {
	
	private int idEvento;
	private String titulo;
	private String tipoEvento;
	private PrecioSector precioEvento;
	private List<Funcion> listaFuncion;
	
	public Evento(int idEvento, String titulo, String tipoEvento, PrecioSector precioEvento)throws Exception {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.tipoEvento = tipoEvento;
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
		return "Evento [idEvento=" + idEvento + ", titulo=" + titulo + ", tipoEvento=" + tipoEvento + ", precioEvento="
				+ precioEvento + ", listaFuncion=" + listaFuncion + "]";
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
		if(traerFuncion(idFuncion) == null)throw new Exception("ERROR no se pudo eliminar la funcion");
		Funcion f = traerFuncion(idFuncion);
		return listaFuncion.remove(f);
	}
	
	public boolean modificarFuncion(int idFuncion,GregorianCalendar fechaInicio,GregorianCalendar fechaFin,double descuento)throws Exception{
		if(traerFuncion(idFuncion) == null)throw new Exception("ERROR no se pudo modificar la funcion");
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < listaFuncion.size()){
			if(listaFuncion.get(i).getIdFuncion() == idFuncion){
				listaFuncion.get(i).setFechaInicio(fechaInicio);
				listaFuncion.get(i).setFechaFin(fechaFin);
				listaFuncion.get(i).setDescuento(descuento);
				encontrado = true;
			}
			i++;
		}
		return true;
	}
	
}
