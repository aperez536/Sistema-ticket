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
	
	public boolean agregarEvento(String titulo,String tipoEvento)throws Exception{
		if(traerEvento(titulo) != null)throw new Exception("ERROR evento ya existe en la lista");
		int proxId = 0;
		if(listaEvento.size() == 0) proxId = 1;
		else proxId = listaEvento.get(listaEvento.size() - 1).getIdEvento() + 1;
		return listaEvento.add(new Evento(proxId,titulo,tipoEvento));
	}
	
	public boolean eliminarEvento(int idEvento)throws Exception{
		Evento e = traerEvento(idEvento);
		if(e == null)throw new Exception("ERROR no se pudo eliminar el evento");
		return listaEvento.remove(e);
	}
	
	public boolean modificarEvento(int idEvento,String titulo,String tipoEvento)throws Exception{
		Evento e = traerEvento(idEvento);
		if(e == null)throw new Exception("ERROR no se pudo modificar el evento");
		e.setTitulo(titulo);
		e.setTipoEvento(tipoEvento);
		return true;
	}
	
	public Sector traerSector(String tipo){
		Sector s =  null;
		int i = 0;
		while(s == null && i < sectores.size()){
			if(sectores.get(i).getTipo().equalsIgnoreCase(tipo)) s = sectores.get(i);
			i++;
		}
		return s;
	}
	
	public NoNumerado traerNoNumerado(String tipo){
	    NoNumerado n = (NoNumerado)traerSector(tipo);
		return n;
	}
	
	public Numerado traerNumerado(String tipo){
		Numerado n =  (Numerado)traerSector(tipo);
		return n;
	}
	
	public boolean agregarNoNumerado(String tipo,int espacioDisponible,int espacioTotal)throws Exception{
		NoNumerado n = traerNoNumerado(tipo);
		if(n != null)throw new Exception("ERROR ya existe sector noNumerado");
		return sectores.add(new NoNumerado(tipo,espacioDisponible,espacioTotal));
	}
	
	public boolean agregarNumerado(String tipo)throws Exception{
		Numerado n = traerNumerado(tipo);
		if(n != null)throw new Exception("ERROR ya existe sector numerado");
		return sectores.add(new Numerado(tipo));
	}
	
	public PrecioSector traerPrecioSector(int idEvento,Sector sector) {
		Evento e = traerEvento(idEvento);
		PrecioSector p = null;
		int i = 0;
		while(p == null && i < e.getListaPrecios().size()) {
			if(e.getListaPrecios().get(i).getSector().equals(sector)) p = e.getListaPrecios().get(i);
			i++;
		}
		return p;
	}
	
	public boolean agregarPrecioSector(int idEvento,Sector sector,double precioPorSector)throws Exception {
		Evento e = traerEvento(idEvento);
		if(traerPrecioSector(idEvento,sector) != null) throw new Exception("ERROR ya existe en la lista");
		return e.getListaPrecios().add(new PrecioSector(sector,precioPorSector));
	}
	
	public boolean eliminarPrecioSector(int idEvento,Sector sector)throws Exception {
		Evento e = traerEvento(idEvento);
		PrecioSector p = traerPrecioSector(idEvento,sector);
		if(p == null)throw new Exception("ERROR no se pudo eliminar de la lista");
		return e.getListaPrecios().remove(p);
	}
	
	public boolean modificarPrecioSector(int idEvento,Sector sector,double precioPorSector)throws Exception {
		PrecioSector p = traerPrecioSector(idEvento,sector);
		if(p == null)throw new Exception("ERROR no se pudo modificar de la lista");
		p.setPrecioPorSector(precioPorSector);
		return true;
	}
	
	public int ubicacionesNoOcupadasNumerado(){
		int ocupado = 0;
		for(int i = 0; i < sectores.size(); i++){
			if(sectores.get(i) instanceof Numerado){
				Numerado n = traerNumerado(sectores.get(i).getTipo());
				for(int j = 0; j < n.getButacas().size(); j++){
					if(n.getButacas().get(j).isOcupado() == false){
						ocupado += 1;
					}
				}
			}
		}
		return ocupado;
	}
	
	public int ubicacionesOcupadasNumerado(){
		int ocupado = 0;
		for(int i = 0; i < sectores.size(); i++){
			if(sectores.get(i) instanceof Numerado){
				Numerado n = traerNumerado(sectores.get(i).getTipo());
				for(int j = 0; j < n.getButacas().size(); j++){
					if(n.getButacas().get(j).isOcupado() == true){
						ocupado += 1;
					}
				}
			}
		}
		return ocupado;
	}
	
	
	public int ubicacionesNoOcupadasNoNumerado(){
		int ocupado = 0;
		for(int i = 0; i < sectores.size(); i++){
			if(sectores.get(i) instanceof NoNumerado){
				NoNumerado n = traerNoNumerado(sectores.get(i).getTipo());
				ocupado = n.getEspacioDisponible();
			}
		}
		return ocupado;
	}
	
	public int ubicacionesOcupadasNoNumerado(){
		int ocupado = 0;
		for(int i = 0; i < sectores.size(); i++){
			if(sectores.get(i) instanceof NoNumerado){
				NoNumerado n = traerNoNumerado(sectores.get(i).getTipo());
				ocupado = n.getEspacioTotal() - n.getEspacioDisponible();
			}
		}
		return ocupado;
	}
	
	public int ubicacionesTotalNoOcupadas(){
		return ubicacionesNoOcupadasNumerado() + ubicacionesNoOcupadasNoNumerado();
	}
	
	public int ubicacionesTotalOcupadas(){
		return ubicacionesOcupadasNumerado() + ubicacionesOcupadasNoNumerado();
	}
  
}
