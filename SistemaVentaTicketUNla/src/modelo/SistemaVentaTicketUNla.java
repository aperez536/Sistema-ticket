package modelo;

import java.util.*;

public class SistemaVentaTicketUNla {
	
	private List<Cliente> clientes;
	private List<Auditorio> listaAuditorio;
	
	public SistemaVentaTicketUNla() throws Exception{
		super();
		this.clientes = new ArrayList<Cliente>();
		this.listaAuditorio = new ArrayList<Auditorio>();
	}

	public List<Cliente> getCliente() {
		return clientes;
	}

	public List<Auditorio> getListaAuditorio() {
		return listaAuditorio;
	}

	@Override
	public String toString() {
		return "SistemaVentaTicketUNla [cliente=" + clientes + ", listaAuditorio=" + listaAuditorio + "]";
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
		Auditorio a = traerAuditorio(idAuditorio);
		if(a == null)throw new Exception("ERROR no se pudo eliminar el auditorio");
		return listaAuditorio.remove(a);
	}
	
	public boolean modificarAuditorio(int idAuditorio,String tipo,String nombre,String direccion)throws Exception{
		Auditorio a = traerAuditorio(idAuditorio);
		if(a == null)throw new Exception("ERROR no se pudo modificar el auditorio");
		a.setTipo(tipo);
		a.setNombre(nombre);
		a.setDireccion(direccion);
		return true;
	}
	public Cliente traerCliente(int idCliente){
		Cliente c = null;
		int i = 0;
		while(c == null && i < clientes.size()){
			if(clientes.get(i).getIdCliente() == idCliente) c = clientes.get(i);
			i++;
		}
		return c;
	}
	private Cliente traerCliente(long dni){
		Cliente c = null;
		int i = 0;
		while(c == null && i < clientes.size()){
			if(clientes.get(i).getDni() == dni ) c = clientes.get(i);
			i++;
		}
		return c;
	}
	
	public boolean agregarCliente( String nombre, String apellido, long dni, String tipoCliente) throws Exception{
		int proxId;
		if(traerCliente(dni) != null) throw new Exception ("ERROR esta persona ya esta agregada en la lista");
		if(clientes.size() == 0) proxId = 1;
		else {
			proxId = clientes.get(clientes.size()-1).getIdCliente() +1;
		}
		Privilegio p = new Privilegio(2,"Reservar Tickets");
		Login l = new Login(nombre.substring(0, 1) + apellido, String.valueOf(dni),p);
		double porcentaje = 0;
		if(tipoCliente.equalsIgnoreCase("Jubilado")) porcentaje = 30;
		else if(tipoCliente.equalsIgnoreCase("Estudiante")) porcentaje = 15;
		else porcentaje = 0;
		return clientes.add(new Cliente(nombre,apellido,dni,l,proxId,tipoCliente,porcentaje));
	}
	public boolean eliminarCliente(long dni) throws Exception {
		Cliente c = traerCliente(dni);
		if(c == null) throw new Exception("ERROR no existe el cliente a eliminar");
		return clientes.remove(c);
		
	}
	public boolean  modificarCliente(String nombre, String apellido, long dni, String tipoCliente, double porcentaje) throws Exception{
		Cliente c = traerCliente(dni);
		if(c == null) throw new Exception ("ERROR no existe el cliente a modificar");
		c.setApellido(apellido);
		c.setNombre(nombre);
		c.setPorcentaje(porcentaje);
		c.setTipoCliente(tipoCliente);
		return true;
	}
	
	

	

}
