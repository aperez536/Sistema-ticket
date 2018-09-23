package modelo;

public class Login {
	
	private String usuario;
	private String password;
	private Privilegio privilegio;
	
	public Login(String usuario, String password, Privilegio privilegio) throws Exception{
		super();
		this.usuario = usuario;
		this.password = password;
		this.privilegio = privilegio;
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Privilegio getPrivilegio() {
		return privilegio;
	}



	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}



	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", password=" + password + ", privilegio=" + privilegio + "]";
	}
	

}
