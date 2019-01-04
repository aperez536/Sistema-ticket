package modelo;

import java.util.*;

public class Funciones {
	
	public static int traerAnio(GregorianCalendar fecha){
		return fecha.get(Calendar.YEAR);
	}
	
	public static int traerMes(GregorianCalendar fecha){
		return (fecha.get(Calendar.MONTH)+1);
	}
	
	public static int traerDia(GregorianCalendar fecha){
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	
	public static boolean esBisiesto(int anio){
		boolean bisiesto = false;
		if((anio%4 == 0)&&(anio%100 != 0)||(anio%400 == 0)){
			bisiesto = true;
		}
		return bisiesto;
	}
	
	public static boolean esFechaValida(int anio,int mes,int dia){
		boolean valido = false;
		if(mes >=1 && mes <=12){
			if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia >= 1 && dia <= 31)){
				valido = true;
			}
			if(mes == 2 && (dia >=1 && dia <= 28)){
				valido = true;
			}	
			if(mes == 2 && Funciones.esBisiesto(anio) == true && dia ==29){
				valido = true;
			}
			else{
				if(dia >=1 && dia <=30){
					valido = true;
				}
			}
		}
		return valido;
	}
	
	public static GregorianCalendar traerFecha(int anio,int mes,int dia){
		GregorianCalendar f = new GregorianCalendar();
		f.set(anio, mes, dia);
		return f;
	}
	
	public static GregorianCalendar traerFecha(String fecha){
		GregorianCalendar f = new GregorianCalendar();
		int dia = Integer.parseInt(fecha.substring(0,2));
		int mes = Integer.parseInt(fecha.substring(3,5));
		int anio = Integer.parseInt(fecha.substring(6,10));
		f.set(anio, mes, dia);
		return f;
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha){
		return Funciones.traerDia(fecha) + "/" + Funciones.traerMes(fecha) + "/" + Funciones.traerAnio(fecha);
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha){
		return Funciones.traerFechaCorta(fecha) + " " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND);
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha,int cantDias){
		GregorianCalendar fechaProx = Funciones.traerFecha(Funciones.traerAnio(fecha), Funciones.traerMes(fecha), Funciones.traerDia(fecha));
		fechaProx.add(Calendar.DAY_OF_MONTH, cantDias);
		return fechaProx;
	}
	
	public static boolean esDiaHabil(GregorianCalendar fecha){
		boolean habil = true;
		if(Funciones.traerDiaDeLaSemana(fecha).equalsIgnoreCase("Domingo") || Funciones.traerDiaDeLaSemana(fecha).equalsIgnoreCase("Sabado")){
			habil = false;
		}
		return habil;
	}
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha){
		String dia = "";
		int d = fecha.get(Calendar.DAY_OF_WEEK);
		for(int i = 1; i <= 7; i++){
			if(d == 1){
				dia = "Domingo";
			}
			if(d == 2){
				dia = "Lunes";
			}
			if(d == 3){
				dia = "Martes";
			}
			if(d == 4){
				dia = "Miercoles";
			}
			if(d == 5){
				dia = "Jueves";
			}
			if(d == 6){
				dia = "Viernes";
			}
			if(d == 7){
				dia = "Sabado";
			}
		}
		return dia;
		
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha){
		String mes = "";
		int m = Funciones.traerMes(fecha);
		for(int i = 1; i <=12; i++){
			if(m == 1){
				mes = "Enero";
			}
			
			if(m == 2){
				mes = "Febrero";
			}
			
			if(m == 3){
				mes = "Marzo";
			}
			
			if(m == 4){
				mes = "Abril";
			}
			
			if(m == 5){
				mes = "Mayo";
			}
			
			if(m == 6){
				mes = "Junio";
			}
			
			if(m == 7){
				mes = "Julio";
			}
			
			if(m == 8){
				mes = "Agosto";
			}
			
			if(m == 9){
				mes = "Septiembre";
			}
			
			if(m == 10){
				mes = "Octubre";
			}
			
			if(m == 11){
				mes = "Noviembre";
			}
			
			if(m == 12){
				mes = "Diciembre";
			}
			
			
		}
		return mes;
	}
	
	public static String traerFechaLArga(GregorianCalendar fecha){
		return Funciones.traerDiaDeLaSemana(fecha) + " " + Funciones.traerDia(fecha) + " de " + Funciones.traerMesEnLetras(fecha) + " del " + Funciones.traerAnio(fecha);
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean iguales = false;
		if(Funciones.traerFechaCorta(fecha).equals(Funciones.traerFechaCorta(fecha1))){
			iguales = true;
		}
		return iguales;
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean iguales = false;
		if(Funciones.traerFechaCortaHora(fecha).equals(Funciones.traerFechaCortaHora(fecha1))){
			iguales = true;
		}
		return iguales;
	}
	
	public static int traerDiasDelMes(int anio,int mes){
		int dia = 0;
		for(int i = 1; i <= 12; i++){
			if(mes == 2){
				if(Funciones.esBisiesto(anio)){
					dia = 29;
				}
				dia = 28;
			}
			if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes ==10 || mes == 12){
				dia = 31;
			}
			else {
				dia = 30;
			}
		}
		return dia;
	}
	
	public static boolean esNumero(char c){
		boolean es = false;
		for(int i = 0; i < 10; i++){
			if(c == String.valueOf(i).charAt(0)){
				es = true;
			}
		}
		return es;
	}
	
	public static boolean esLetra(char c){
		String abecedario = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
		boolean es = false;
		for(int i = 0; i < abecedario.length(); i++){
			if(c == abecedario.charAt(i)){
				es = true;
			}
		}
		return es;
	}
	
	public static boolean esCadenaDeNumeros(String cadena){
		boolean es = true;
		for(int i = 0; i < cadena.length(); i++){
			if(Funciones.esNumero(cadena.charAt(i))!=true){
				es = false;
			}
		}
		return es;
	}
	
	public static boolean esCadenaDeCaracteres(String cadena){
		boolean es = true;
		for(int i = 0; i < cadena.length(); i++){
			if(!(Funciones.esLetra(cadena.charAt(i)))){
				es = false;
			}
		}
		return es;
	}

}

