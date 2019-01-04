package test;

import modelo.*;

public class TestSistemaVentaTicketUNla2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Escenario 2: Excepcion carga de cliente");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("Carga de Cliente 1: " + s.agregarCliente("Oscar", "Ruina", 11111111, "Estudiante"));
			System.out.println("Carga de Cliente 1: " + s.agregarCliente("Oscar", "Ruina", 11111111, "Estudiante"));
	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("Escenario 3: Excepcion carga de auditorio");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("Escenario 4: Excepcion carga de evento");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
			System.out.println("Carga de Evento 1: " + s.traerAuditorio(1).agregarEvento("Musica Fest", "Recital"));
			System.out.println("Carga de Evento 1: " + s.traerAuditorio(1).agregarEvento("Musica Fest", "Recital"));
	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("Escenario 5: Excepcion carga de sectores");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
			System.out.println("Carga de Sectores 1: " + s.traerAuditorio(1).agregarNoNumerado("popular", 100,100));
			System.out.println("Carga de Sectores 1: " + s.traerAuditorio(1).agregarNoNumerado("popular", 100,100));
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			System.out.println("Escenario 6: Excepcion carga de reserva");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
			System.out.println("Carga de Cliente 1: " + s.agregarCliente("Oscar", "Ruina", 11111111, "Estudiante"));
			System.out.println("Carga de Evento 1: " + s.traerAuditorio(1).agregarEvento("Musica Fest", "Recital"));
			System.out.println("Carga de Funcion 1: " + s.traerAuditorio(1).traerEvento(1).agregarFuncion(Funciones.traerFecha(2018, 9, 16), Funciones.traerFecha(2018, 9, 16), 25));
			System.out.println("Carga de Sectores 1: " + s.traerAuditorio(1).agregarNoNumerado("popular", 100,100));
			System.out.println("Carga de Precio por Sector 1: " + s.traerAuditorio(1).agregarPrecioSector(1, s.traerAuditorio(1).traerNoNumerado("popular"), 100));
			System.out.println("Carga de Reservas 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).agregarReserva(s.traerCliente(1), Funciones.traerFecha(2018, 9, 17)));
			System.out.println("Carga de Reservas 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).agregarReserva(s.traerCliente(1), Funciones.traerFecha(2018, 9, 17)));
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
