package modelo;

public class PrecioSector {

	private Sector sector;
	private double precioPorSector;
	private int cantidadVendida;
	
	public PrecioSector(Sector sector, double precioPorSector, int cantidadVendida) {
		super();
		this.sector = sector;
		this.precioPorSector = precioPorSector;
		this.cantidadVendida = cantidadVendida;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public double getPrecioPorSector() {
		return precioPorSector;
	}

	public void setPrecioPorSector(double precioPorSector) {
		this.precioPorSector = precioPorSector;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	@Override
	public String toString() {
		return "PrecioSector [sector=" + sector + ", precioPorSector=" + precioPorSector + ", cantidadVendida="
				+ cantidadVendida + "]";
	}
	
}
