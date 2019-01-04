package test;

import modelo.*;

public class TestSistemaVentaTicketUNla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//Caso de Uso Principal,Carga de Prueba
			System.out.println("Escenario 1: Carga de Prueba");
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			
			System.out.println("Carga de Cliente 1: " + s.agregarCliente("Oscar", "Ruina", 11111111, "Estudiante"));
			System.out.println("Carga de Cliente 2: " + s.agregarCliente("Alan", "Perez", 22222222, "Normal"));
			System.out.println("Carga de Cliente 3: " + s.agregarCliente("Esteban", "Rodriguez", 33333333, "Jubilado"));
			
			System.out.println("Carga de Auditorio 1: " + s.agregarAuditorio("Estadio", "Florencio Sola", "Gral Arenales 902"));
			System.out.println("Carga de Auditorio 2: " + s.agregarAuditorio("Teatro", "Maipu", "Maipu 380"));
			
			System.out.println("Carga de Evento 1: " + s.traerAuditorio(1).agregarEvento("Musica Fest", "Recital"));
			System.out.println("Carga de Evento 2: " + s.traerAuditorio(2).agregarEvento("SUGAR", "Obra de Teatro"));
			
			System.out.println("Carga de Funcion 1: " + s.traerAuditorio(1).traerEvento(1).agregarFuncion(Funciones.traerFecha(2018, 9, 16), Funciones.traerFecha(2018, 9, 16), 25));
			System.out.println("Carga de Funcion 2: " + s.traerAuditorio(2).traerEvento(1).agregarFuncion(Funciones.traerFecha(2018, 9, 16), Funciones.traerFecha(2018, 9, 16), 0));
			
			System.out.println("Carga de Sectores 1: " + s.traerAuditorio(1).agregarNoNumerado("popular", 100,100));
			System.out.println("Carga de Sectores 2: " + s.traerAuditorio(1).agregarNumerado("palco"));
			System.out.println("Carga de Sectores 3: " + s.traerAuditorio(1).agregarNumerado("palcoB"));
			System.out.println("Carga de Butacas Sector 2: " + s.traerAuditorio(1).traerNumerado("palco").agregarButacas(1,1));
			System.out.println("Carga de Butacas Sector 2: " + s.traerAuditorio(1).traerNumerado("palco").agregarButacas(1,2));
			System.out.println("Carga de Butacas Sector 2: " + s.traerAuditorio(1).traerNumerado("palco").agregarButacas(1,3));
			System.out.println("Carga de Precio por Sector 1: " + s.traerAuditorio(1).agregarPrecioSector(1, s.traerAuditorio(1).traerNoNumerado("popular"), 100));
			System.out.println("Carga de Precio por Sector 2: " + s.traerAuditorio(1).agregarPrecioSector(1, s.traerAuditorio(1).traerNumerado("palco"), 1000));
			
			System.out.println("Carga de Reservas 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).agregarReserva(s.traerCliente(1), Funciones.traerFecha(2018, 9, 17)));
			System.out.println("Carga de Reservas 2: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).agregarReserva(s.traerCliente(2), Funciones.traerFecha(2018, 9, 17)));
			System.out.println("Carga de Reservas 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).agregarReserva(s.traerCliente(3), Funciones.traerFecha(2018, 9, 17)));
			
			System.out.println("Traigo Reserva Cliente 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)));
			System.out.println("Traigo Reserva Cliente 2: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(2)));
			System.out.println("Traigo Reserva Cliente 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)));
			
			System.out.println("Generar Ticket 1 al Cliente 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)).agregarTicketNoNumerado(s.traerAuditorio(1).traerNoNumerado("popular"), Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1), s.traerAuditorio(1).traerEvento(1), s.traerAuditorio(1).traerEvento(1).traerFuncion(1)));
			System.out.println("Generar Ticket 2 al Cliente 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)).agregarTicketNoNumerado(s.traerAuditorio(1).traerNoNumerado("popular"), Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1), s.traerAuditorio(1).traerEvento(1), s.traerAuditorio(1).traerEvento(1).traerFuncion(1)));
			System.out.println("Traigo Reserva con Tickets Cliente 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)));
			System.out.println("Precio Ticket 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)).traerTicket(1).getPrecioTicket());
			System.out.println("Precio Ticket 2: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)).traerTicket(2).getPrecioTicket());
			System.out.println("Precio Tickets del Cliente 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(1)).calcularPrecioTickets());
			
			System.out.println("Generar Ticket 3 al Cliente 2: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(2)).agregarTicketNoNumerado(s.traerAuditorio(1).traerNoNumerado("popular"), Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1), s.traerAuditorio(1).traerEvento(1), s.traerAuditorio(1).traerEvento(1).traerFuncion(1)));
			System.out.println("Traigo Reserva con Tickets Cliente 2: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(2)));
			System.out.println("Precio Ticket 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(2)).traerTicket(1).getPrecioTicket());
			
			
			
			System.out.println("Generar Ticket 4 al Cliente 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).agregarTicketNoNumerado(s.traerAuditorio(1).traerNoNumerado("popular"), Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1), s.traerAuditorio(1).traerEvento(1), s.traerAuditorio(1).traerEvento(1).traerFuncion(1)));
			System.out.println("Precio Ticket 4: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).traerTicket(1).getPrecioTicket());
			System.out.println("Genero Ticket 5 al Cliente 3 " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).agregarTicketNumerado(s.traerAuditorio(1).traerNumerado("palco"), s.traerAuditorio(1).traerNumerado("palco").traerButaca(1, 1), Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1), s.traerAuditorio(1).traerEvento(1), s.traerAuditorio(1).traerEvento(1).traerFuncion(1)));
			System.out.println("Precio Ticket 5: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).traerTicket(2).getPrecioTicket());
			System.out.println("Precio Tickets del Cliente 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).calcularPrecioTickets());
			System.out.println("Traigo Reserva Cliente 3: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)));
			
			System.out.println("Ubicaciones No Ocupadas de Butacas en Auditorio 1: " + s.traerAuditorio(1).ubicacionesNoOcupadasNumerado());
			System.out.println("Ubicaciones Ocupadas de Butacas en Auditorio 1: " + s.traerAuditorio(1).ubicacionesOcupadasNumerado());
			System.out.println("Ubicaciones No Ocupadas en Auditorio 1: " + s.traerAuditorio(1).ubicacionesNoOcupadasNoNumerado());
			System.out.println("Ubicaciones Ocupadas en Auditorio 1: " + s.traerAuditorio(1).ubicacionesOcupadasNoNumerado());
			System.out.println("Total de Ocupados en Auditorio 1: " + s.traerAuditorio(1).ubicacionesTotalOcupadas());
			System.out.println("Lista Butacas No Ocupadas: " + s.traerAuditorio(1).traerNumerado("Palco").traerButacasSinOcupar());
			System.out.println("Lista Butacas Ocupadas: " + s.traerAuditorio(1).traerNumerado("palco").traerButacasOcupadas());
			
			System.out.println("Traigo Ticket por Butaca: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerReserva(s.traerCliente(3)).traerTicket(s.traerAuditorio(1).traerNumerado("palco").traerButaca(1, 1)));
			System.out.println("7-Traigo tickets de la Funcion 1: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion());
			System.out.println("8-Traigo tickets por funcion y descuento: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncionYDescuento());
			System.out.println("9-Total de No Ocupadas en Auditorio 1: " + s.traerAuditorio(1).ubicacionesTotalNoOcupadas());
			System.out.println("10-Total de Ubicaciones No Ocupadas en Evento para un Auditorio: " + s.traerAuditorio(1).ubicacionesTotalNoOcupadas());
			System.out.println("11-Traigo tickets por tipo Cliente: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion("estudiante"));
			System.out.println("12-Traigo tickets entre fechas: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion(Funciones.traerFecha(2018, 8, 1), Funciones.traerFecha(2018, 10, 1)));
			System.out.println("13-Traigo tickets entre fechas y sector: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion(Funciones.traerFecha(2018, 9, 15), Funciones.traerFecha(2018, 9, 18), s.traerAuditorio(1).traerSector("palco")));
			System.out.println("14-Traigo tickets entre fechas y cliente: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncionYCliente(Funciones.traerFecha(2018, 9, 16), Funciones.traerFecha(2018, 9, 18), s.traerCliente(1)));
			System.out.println("Traigo tickets de una fecha: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion(Funciones.traerFecha(2018, 9, 17)));
			System.out.println("Traigo tickets de una fecha y sector: " + s.traerAuditorio(1).traerEvento(1).traerFuncion(1).traerTicketsPorFuncion(Funciones.traerFecha(2018, 9, 17), s.traerAuditorio(1).traerSector("palco")));
			System.out.println("Mapeo de Butacas: " + s.traerAuditorio(1).traerNumerado("palco").getButacas());
			System.out.println(s);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	}

}
