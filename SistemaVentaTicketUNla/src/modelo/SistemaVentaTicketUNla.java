package modelo;

import java.util.*;

public class SistemaVentaTicketUNla {
	
	private List<Cliente> cliente;
	private List<Auditorio> listaAuditorio;
	
	public SistemaVentaTicketUNla() throws Exception{
		super();
		this.cliente = new ArrayList<Cliente>();
		this.listaAuditorio = new ArrayList<Auditorio>();
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public List<Auditorio> getListaAuditorio() {
		return listaAuditorio;
	}

	@Override
	public String toString() {
		return "SistemaVentaTicketUNla [cliente=" + cliente + ", listaAuditorio=" + listaAuditorio + "]";
	}
	
	public Auditorio traerAuditorio(int idAuditorio){
		Auditorio a = null;
		int i = 0;
		while(a == null && i < listaAuditorio.size()){
			if(listaAuditorio.get(i).getIdAuditorio() == idAuditorio) a = listaAuditorio.get(i);
			i++;
		}
		return a;
	}
	
	public Auditorio traerAuditorio(String nombre){
		Auditorio a = null;
		int i = 0;
		while(a == null && i < listaAuditorio.size()){
			if(listaAuditorio.get(i).getNombre().equalsIgnoreCase(nombre)) a = listaAuditorio.get(i);
			i++;
		}
		return a;
	}
	
	public List<Auditorio> traerAuditorios(String tipo){
		List<Auditorio> lista = new ArrayList<Auditorio>();
		for(int i = 0; i < listaAuditorio.size(); i++){
			if(listaAuditorio.get(i).getTipo().equalsIgnoreCase(tipo)){
				lista.add(listaAuditorio.get(i));
			}
		}
		return lista;
	}
	
	public boolean agregarAuditorio(String tipo,String nombre,String direccion)throws Exception{
		if(traerAuditorio(nombre) != null)throw new Exception("ERROR Auditorio ya existe en el sistema");
		int proxId = 0;
		if(listaAuditorio.size() == 0)proxId =1;
		else proxId = listaAuditorio.get(listaAuditorio.size() - 1).getIdAuditorio() + 1;
		return listaAuditorio.add(new Auditorio(proxId,tipo,nombre,direccion));
	}
	
	public boolean eliminarAuditorio(int idAuditorio)throws Exception{
		if(traerAuditorio(idAuditorio) == null)throw new Exception("ERROR no se pudo eliminar el auditorio");
		Auditorio a = traerAuditorio(idAuditorio);
		return listaAuditorio.remove(a);
	}
	
	public boolean modificarAuditorio(int idAuditorio,String tipo,String nombre,String direccion)throws Exception{
		if(traerAuditorio(idAuditorio) == null)throw new Exception("ERROR no se pudo modificar el auditorio");
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < listaAuditorio.size()){
			if(listaAuditorio.get(i).getIdAuditorio() == idAuditorio){
				listaAuditorio.get(i).setTipo(tipo);
				listaAuditorio.get(i).setNombre(nombre);
				listaAuditorio.get(i).setDireccion(direccion);
				encontrado = true;
			}
		}
		return true;
	}
	

	

}
