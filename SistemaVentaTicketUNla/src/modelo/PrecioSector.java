package modelo;

public class PrecioSector {

	private Sector sector;
	private double precioPorSector;
	
	public PrecioSector(Sector sector, double precioPorSector)throws Exception {
		super();
		this.sector = sector;
		this.precioPorSector = precioPorSector;
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

	@Override
	public String toString() {
		return "PrecioSector [sector=" + sector + ", precioPorSector=" + precioPorSector + "]";
	}

	

	
	
}
