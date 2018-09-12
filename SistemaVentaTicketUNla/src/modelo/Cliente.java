package modelo;

public class Cliente extends Persona{
	
	private int idCliente;
	private String tipoCliente;
	private double porcentaje;
	
	public Cliente( String nombre, String apellido, long dni, Login login,
			int idCliente , String tipoCliente, double porcentaje)  {
		super(nombre,apellido,dni,login);
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.porcentaje = porcentaje;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return  super.toString() + " Cliente [ idCliente=" + idCliente + ", tipoCliente=" + tipoCliente + ", porcentaje=" + porcentaje + "]";
	}
	

}
