package modelo;
import java.util.*;
public class Ticket {
	
	private int idTicket;
	private Sector sector;
	private Funcion funcion;
	private GregorianCalendar fechaReserva;
	private double precioTicket;

	public Ticket(int idTicket, Sector sector, Funcion funcion, GregorianCalendar fechaReserva, double precioTicket) {
		super();
		this.idTicket = idTicket;
		this.sector = sector;
		this.funcion = funcion;
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

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
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
		return "Ticket [idTicket=" + idTicket + ", sector=" + sector + ", funcion=" + funcion + ", fechaReserva="
				+ fechaReserva + ", precioTicket=" + precioTicket + "]";
	}
	
	
}
