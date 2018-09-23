package modelo;
import java.util.*;
public class Auditorio {

	private int idAuditorio;
	private String tipo;
	private String nombre;
	private String direccion;
	private List<Evento> listaEvento;
	private List<Sector> sectores;
	
	public Auditorio(int idAuditorio, String tipo, String nombre, String direccion) throws Exception{
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



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
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



	public List<Sector> getSectores() {
		return sectores;
	}



	@Override
	public String toString() {
		return "Auditorio [idAuditorio=" + idAuditorio + ", tipo=" + tipo + ", nombre=" + nombre + ", direccion="
				+ direccion + ", listaEvento=" + listaEvento + ", sectores=" + sectores + "]";
	}
	
	public boolean equals(Auditorio a) {
		return idAuditorio == a.getIdAuditorio();
	}
	
	public Evento traerEvento(int idEvento){
		Evento e = null;
		int i = 0;
		while(e == null && i < listaEvento.size()){
			if(listaEvento.get(i).getIdEvento() == idEvento) e = listaEvento.get(i);
			i++;
		}
		return e;
	}
	
	public Evento traerEvento(String titulo){
		Evento e = null;
		int i = 0;
		while(e == null && i < listaEvento.size()){
			if(listaEvento.get(i).getTitulo().equalsIgnoreCase(titulo)) e = listaEvento.get(i);
			i++;
		}
		return e;
	}
	
	public List<Evento> traerEventos(String tipoEvento){
		List<Evento> lista = new ArrayList<Evento>();
		for(int i = 0; i < listaEvento.size(); i++){
			if(listaEvento.get(i).getTipoEvento().equalsIgnoreCase(tipoEvento)){
				lista.add(listaEvento.get(i));
			}
		}
		return lista;
	}
	
	public boolean agregarEvento(String titulo,String tipoEvento,PrecioSector precioEvento)throws Exception{
		if(traerEvento(titulo) != null)throw new Exception("ERROR evento ya existe en la lista");
		int proxId = 0;
		if(listaEvento.size() == 0) proxId = 1;
		else proxId = listaEvento.get(listaEvento.size() - 1).getIdEvento() + 1;
		return listaEvento.add(new Evento(proxId,titulo,tipoEvento,precioEvento));
	}
	
	public boolean eliminarEvento(int idEvento)throws Exception{
		if(traerEvento(idEvento) == null)throw new Exception("ERROR no se pudo eliminar el evento");
		Evento e = traerEvento(idEvento);
		return listaEvento.remove(e);
	}
	
	public boolean modificarEvento(int idEvento,String titulo,String tipoEvento,PrecioSector precioEvento)throws Exception{
		if(traerEvento(idEvento) == null)throw new Exception("ERROR no se pudo modificar el evento");
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < listaEvento.size()){
			if(listaEvento.get(i).getIdEvento() == idEvento){
				listaEvento.get(i).setTitulo(titulo);
				listaEvento.get(i).setTipoEvento(tipoEvento);
				listaEvento.get(i).setPrecioEvento(precioEvento);
				encontrado = true;
			}
			i++;
		}
		return true;
	}
	
  
}
