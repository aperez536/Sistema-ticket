package test;

import modelo.*;
import java.util.*;

public class TestSistemaVentaTicketUNla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SistemaVentaTicketUNla s = new SistemaVentaTicketUNla();
			System.out.println("ESCENARIO 1: CARGA DE AUDITORIOS,EVENTOS Y FUNCIONES SIN EXCEPCIONES");
			System.out.println(s.agregarAuditorio("Cine", "Auditorio 1", "Calle 1"));
			System.out.println(s.agregarAuditorio("Cine", "Auditorio 2", "Calle 2"));
			System.out.println(s.agregarAuditorio("Cine", "Auditorio 3", "Calle 3"));
			System.out.println(s.agregarAuditorio("Estadio", "Auditorio 4", "Calle 4"));
			System.out.println(s.agregarAuditorio("Estadio", "Auditorio 5", "Calle 5"));
			System.out.println(s.agregarAuditorio("Teatro", "Auditorio 6", "Calle 6"));
			System.out.println(s.agregarAuditorio("Teatro", "Auditorio 7", "Calle 7"));
			System.out.println(s);
			System.out.println(s.traerAuditorio(1).agregarEvento("Evento 1 ", "Recital", null));
			System.out.println(s);
			System.out.println(s.traerAuditorio(1).traerEvento(1).toString());
			System.out.println(s.traerAuditorio(1).traerEvento(1).agregarFuncion(null, null, 10));
			System.out.println(s.traerAuditorio(1).traerEvento(1).traerFuncion(1).toString());
			System.out.println(s);
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	

	}

}
