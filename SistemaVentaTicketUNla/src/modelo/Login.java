package modelo;

public class Login {
	
	private String usuario;
	private String contraseña;
	private Privilegio privilegio;
	
	public Login(String usuario, String contraseña, Privilegio privilegio) throws Exception{
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.privilegio = privilegio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Privilegio getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}
	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", contraseña=" + contraseña + ", privilegio=" + privilegio + "]";
	}
	

}
