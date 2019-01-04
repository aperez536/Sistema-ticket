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
		return "Funcion [idFuncion=" + idFuncion + ", fechaInicio=" + Funciones.traerFechaCorta(fechaInicio) + ", fechaFin=" + Funciones.traerFechaCorta(fechaFin)
				+ ", descuento=" + descuento + ", reservas=" + reservas + "]";
	}



	public boolean equals(Funcion f){
		return idFuncion == f.getIdFuncion();
	}
	
	public Reserva traerReserva(Cliente cliente){
		Reserva r = null;
		int i = 0;
		while(r == null && i < reservas.size()){
			if(reservas.get(i).getCliente().equals(cliente)) r = reservas.get(i);
			i++;
		}
		return r;
	}
	
	public boolean agregarReserva(Cliente cliente,GregorianCalendar fechaHora)throws Exception{
		if(traerReserva(cliente) != null)throw new Exception("ERROR cliente ya tiene una reserva");
		return reservas.add(new Reserva(cliente,fechaHora,true));
	}
	
	public boolean eliminarReserva(Cliente cliente)throws Exception{
		Reserva r = traerReserva(cliente);
		if(r == null)throw new Exception("ERROR no se pudo eliminar reserva");
		return reservas.remove(r);
	}
	
	public double calcularTotal() throws Exception{
		double total = 0;
		for(int i = 0; i < reservas.size(); i++){
			total += reservas.get(i).calcularPrecioTickets();
		}
		return total;
	}
	
	public List<Ticket> traerTicketsPorFuncion(){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i < reservas.size(); i++){
			Reserva r = traerReserva(reservas.get(i).getCliente());
			for(int j = 0; j < r.getTickets().size(); j++){
				tickets.add(r.getTickets().get(j));
			}
		}
		return tickets;
	}
	
	public List<Ticket> traerTicketsPorFuncion(String tipoCliente){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i < reservas.size(); i++){
			Reserva r = traerReserva(reservas.get(i).getCliente());
			if(r.getCliente().getTipoCliente().equalsIgnoreCase(tipoCliente)){
				for(int j = 0; j < r.getTickets().size(); j++){
					tickets.add(r.getTickets().get(j));
				}
			}
		}
		return tickets;
	}
	
	public List<Ticket> traerTicketsPorFuncion(GregorianCalendar fechaInicio,GregorianCalendar fechaFin){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i < reservas.size(); i++) {
			Reserva r = traerReserva(reservas.get(i).getCliente());
			for(int j = 0; j < r.getTickets().size(); j++) {
				if(r.getFechaHora().after(fechaInicio) && r.getFechaHora().before(fechaFin)) {
					tickets.add(r.getTickets().get(j));
				}
				if(Funciones.sonFechasIguales(r.getFechaHora(), fechaInicio)) {
					tickets.add(r.getTickets().get(j));
				}
			}
		}
		return tickets;
	}
	
	public List<Ticket> traerTicketsPorFuncion(GregorianCalendar fechaInicio){
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(Funciones.traerAnio(fechaInicio),Funciones.traerMes(fechaInicio), Funciones.traerDia(fechaInicio), 23, 59, 59);
		return traerTicketsPorFuncion(fechaInicio,fecha1);
		
	}
	
	public List<Ticket> traerTicketsPorFuncion(GregorianCalendar fechaInicio,GregorianCalendar fechaFin,Sector sector){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i < reservas.size(); i++) {
			Reserva r = traerReserva(reservas.get(i).getCliente());
			for(int j = 0; j < r.getTickets().size(); j++) {
				if(r.getFechaHora().after(fechaInicio) && r.getFechaHora().before(fechaFin) && r.getTickets().get(j).getSector().equals(sector)) {
					tickets.add(r.getTickets().get(j));
				}
				if(Funciones.sonFechasIguales(r.getFechaHora(), fechaInicio) && r.getTickets().get(j).getSector().equals(sector)) {
					tickets.add(r.getTickets().get(j));
				}
			}
		}
		return tickets;
	}
	
	public List<Ticket> traerTicketsPorFuncion(GregorianCalendar fechaInicio,Sector sector){
		GregorianCalendar fecha1 = new GregorianCalendar();
		fecha1.set(Funciones.traerAnio(fechaInicio),Funciones.traerMes(fechaInicio), Funciones.traerDia(fechaInicio), 23, 59, 59);
		return traerTicketsPorFuncion(fechaInicio,fecha1,sector);
	}
	
	public List<Ticket> traerTicketsPorFuncionYDescuento(){
		List<Ticket> tickets = new ArrayList<Ticket>();
		if(this.descuento > 0){
			tickets =traerTicketsPorFuncion();
		}
		return tickets;
	}
	
	
	public List<Ticket> traerTicketsPorFuncionYCliente(GregorianCalendar fechaInicio,GregorianCalendar fechaFin,Cliente cliente){
		List<Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i < reservas.size(); i++){
			if(reservas.get(i).getCliente().equals(cliente)){
				for(int j = 0; j < reservas.get(i).getTickets().size(); j++){
					if(reservas.get(i).getFechaHora().after(fechaInicio) && reservas.get(i).getFechaHora().before(fechaFin)){
						tickets.add(reservas.get(i).getTickets().get(j));
					}
				}
			}
		}
		return tickets;
	}

	

}
