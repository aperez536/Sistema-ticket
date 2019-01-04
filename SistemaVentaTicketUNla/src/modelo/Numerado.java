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
	
	public boolean agregarButacas(int fila, int columna)throws Exception{
		if(traerButaca(fila,columna) != null)throw new Exception("ERROR ya existe butaca");
		int id = 0;
		if(butacas.size() == 0)id = 1;
		else id = butacas.get(butacas.size() - 1).getId() + 1;
		boolean ocupado = false;
		return butacas.add(new Butaca(id,fila,columna,ocupado));
	}
	
	public Butaca traerButaca(int fila,int columna){
		Butaca b = null;
		int i = 0;
		while(b == null && i < butacas.size()){
			if(butacas.get(i).getFila() == fila && butacas.get(i).getColumna() == columna)b=butacas.get(i);
			i++;
		}
		return b;
	}
	
	public List<Butaca> traerButacasSinOcupar(){
		List<Butaca> aux = new ArrayList<Butaca>();
		for(int i = 0; i < butacas.size(); i++) {
			if(butacas.get(i).isOcupado() == false) {
				aux.add(butacas.get(i));
			}
		}
		return aux;
	}
	
	public List<Butaca> traerButacasOcupadas(){
		List<Butaca> aux = new ArrayList<Butaca>();
		for(int i = 0; i < butacas.size(); i++) {
			if(butacas.get(i).isOcupado() == true) {
				aux.add(butacas.get(i));
			}
		}
		return aux;
	}

}
