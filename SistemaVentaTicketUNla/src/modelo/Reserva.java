package modelo;

import java.util.*;

public class Reserva {
	
	private Cliente cliente;
	private GregorianCalendar fechaHora;
	private boolean entregado;
	private List<Ticket> tickets;
	
	public Reserva(Cliente cliente, GregorianCalendar fechaHora, boolean entregado)throws Exception {
		super();
		this.cliente = cliente;
		this.fechaHora = fechaHora;
		this.entregado = entregado;
		this.tickets = new ArrayList<Ticket>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", fechaHora=" + Funciones.traerFechaCorta(fechaHora) + ", entregado=" + entregado + ", tickets="
				+ tickets + "]";
	}
	
	public Ticket traerTicket(int idTicket){
		Ticket t = null;
		int i = 0;
		while(t == null && i < tickets.size()){
			if(tickets.get(i).getIdTicket() == idTicket) t = tickets.get(i);
			i++;
		}
		return t;
	}
	
	public Ticket traerTicket(Butaca butaca){
		Ticket t = null;
		int i = 0;
		while(t == null && i < tickets.size()){
			if(tickets.get(i).getSector() instanceof Numerado){
				if(tickets.get(i).getButaca().equals(butaca)) t = tickets.get(i);
			}
			i++;
		}
		return t;
	}
	
	public boolean agregarTicketNoNumerado(Sector sector,GregorianCalendar fechaReserva,Auditorio auditorio,Evento evento,Funcion funcion)throws Exception{
		int id = 0;
		if(tickets.size() == 0) id = 1;
		else id = tickets.get(tickets.size() - 1).getIdTicket() + 1;
		NoNumerado n = auditorio.traerNoNumerado(sector.getTipo());
		n.setEspacioDisponible(n.getEspacioDisponible() - 1);
		return tickets.add(new Ticket(id,sector,fechaReserva,calcularPrecioTicket(auditorio,evento,funcion,sector)));
	}
	
	public boolean agregarTicketNumerado(Sector sector,Butaca butaca,GregorianCalendar fechaReserva,Auditorio auditorio,Evento evento,Funcion funcion)throws Exception{
		int id = 0;
		if(tickets.size() == 0) id = 1;
		else id = tickets.get(tickets.size() - 1).getIdTicket() + 1;
		Numerado n = auditorio.traerNumerado(sector.getTipo());
		Butaca b = n.traerButaca(butaca.getFila(), butaca.getColumna());
		if(b.isOcupado() == true) throw new Exception("ERROR butaca ya ocupada");
		b.setOcupado(true);
		Ticket t = new Ticket(id,sector,fechaReserva,calcularPrecioTicket(auditorio,evento,funcion,sector));
		t.setButaca(b);
		return tickets.add(t);
	}
	
	public boolean eliminarTicket(int idTicket)throws Exception{
		Ticket t = traerTicket(idTicket);
		if(t == null)throw new Exception("ERROR no se pudo eliminar Ticket");
		return tickets.remove(t);
	}
	
	private double calcularPrecioTicket(Auditorio auditorio,Evento evento,Funcion funcion,Sector sector)throws Exception{
		double precio = 0;
		if(auditorio.traerEvento(evento.getIdEvento()) == null)throw new Exception("ERROR no existe evento");
		double precioSector = auditorio.traerPrecioSector(evento.getIdEvento(), sector).getPrecioPorSector();
		double porcentaje = cliente.getPorcentaje()/100;
		double descuento = precioSector * porcentaje;
		String dia = Funciones.traerDiaDeLaSemana(funcion.getFechaInicio());
		double descuentoFuncion = 0;
		if(dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles")){
			double porcentajeFuncion = funcion.getDescuento()/100;
			descuentoFuncion = precioSector * porcentajeFuncion;
		}
		precio = precioSector - descuento - descuentoFuncion;
		return precio;
	}
	
	public double calcularPrecioTickets(){
		double precio = 0;
		for(int i = 0;i < tickets.size();i++){
			precio += tickets.get(i).getPrecioTicket();
		}
		return precio;
	}
	
}
