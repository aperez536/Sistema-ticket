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

	@Override
	public String toString() {
		return super.toString() + " Numerado [butacas=" + butacas + "]";
	}
	
	
	

}
