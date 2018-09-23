package modelo;

import java.util.*;

public class Funcion {
	
	private int idFuncion;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private double descuento;
	private List<Reserva> reservas;
	
	public Funcion(int idFuncion, GregorianCalendar fechaInicio, GregorianCalendar fechaFin, double descuento) throws Exception{
		super();
		this.idFuncion = idFuncion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.reservas = new ArrayList<Reserva>();
	}

	

	public int getIdFuncion() {
		return idFuncion;
	}



	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}



	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}



	public double getDescuento() {
		return descuento;
	}



	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", descuento=" + descuento + ", reservas=" + reservas + "]";
	}



	public boolean equals(Funcion f){
		return idFuncion == f.getIdFuncion();
	}
	
	
	

}
