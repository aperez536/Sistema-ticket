package modelo;

import java.util.*;

public class Numerado extends Sector{
	
	private List<Butaca> butacas;

	public Numerado(String tipo) throws Exception {
		super(tipo);
		this.butacas = new ArrayList<Butaca>();
	}

	public List<Butaca> getButacas() {
		return butacas;
	}

	public void setButacas(List<Butaca> butacas) {
		this.butacas = butacas;
	}

	@Override
	public String toString() {
		return super.toString() + " Numerado [butacas=" + butacas + "]";
	}
	
	
	

}
