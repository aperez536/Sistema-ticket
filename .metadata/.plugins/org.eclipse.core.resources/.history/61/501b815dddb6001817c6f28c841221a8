package modelo;

import java.util.*;

public class Reserva {
	
	private Cliente cliente;
	private GregorianCalendar fechaHora;
	private List<Ticket> tickets;
	private boolean entregado;
	
	public Reserva(Cliente cliente, GregorianCalendar fechaHora, boolean entregado) {
		super();
		this.cliente = cliente;
		this.fechaHora = fechaHora;
		this.tickets = new ArrayList<Ticket>();
		this.entregado = entregado;
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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", fechaHora=" + fechaHora + ", tickets=" + tickets + ", entregado="
				+ entregado + "]";
	}
	
}
