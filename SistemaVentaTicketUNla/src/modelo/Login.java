package modelo;

public class Login {
	private String usuario;
	private String contrase�a;
	private Privilegio privilegio;
	public Login(String usuario, String contrase�a, Privilegio privilegio) {
		super();
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.privilegio = privilegio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public Privilegio getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(Privilegio privilegio) {
		this.privilegio = privilegio;
	}
	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", contrase�a=" + contrase�a + ", privilegio=" + privilegio + "]";
	}
	

}
