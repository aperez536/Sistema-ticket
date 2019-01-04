package modelo;

import java.util.*;

public class Ticket {
	
	private int idTicket;
	private Sector sector;
	private Butaca butaca;
	private GregorianCalendar fechaReserva;
	private double precioTicket;
	
	public Ticket(int idTicket, Sector sector, GregorianCalendar fechaReserva, double precioTicket) {
		super();
		this.idTicket = idTicket;
		this.sector = sector;
		this.fechaReserva = fechaReserva;
		this.precioTicket = precioTicket;
	}

	public int getIdTicket() {
		return idTicket;
	}
	
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}
	
	public Sector getSector() {
		return sector;
	}
	
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	public Butaca getButaca() {
		return butaca;
	}
	
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	
	public GregorianCalendar getFechaReserva() {
		return fechaReserva;
	}
	
	public void setFechaReserva(GregorianCalendar fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	
	public double getPrecioTicket() {
		return precioTicket;
	}
	
	public void setPrecioTicket(double precioTicket) {
		this.precioTicket = precioTicket;
	}
	
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", sector=" + sector.getTipo() + ", butaca=" + butaca + ", fechaReserva="
				+ Funciones.traerFechaCorta(fechaReserva) + ", precioTicket=" + precioTicket + "]";
	}

	public boolean equals(Ticket t){
		return idTicket == t.getIdTicket();
	}
	
	
	
}
