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
		return "Reserva [cliente=" + cliente + ", fechaHora=" + fechaHora + ", entregado=" + entregado + ", tickets="
				+ tickets + "]";
	}
	
	

	
	
	
	
	
	
	
}
