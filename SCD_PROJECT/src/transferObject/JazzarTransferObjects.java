package transferObject;

public class JazzarTransferObjects {
	private int raqam;
	private String juzzar;
	public JazzarTransferObjects() {
		this.raqam = 0;
		this.juzzar="";
	}
	public JazzarTransferObjects(int raqam, String juzzar) {
		super();
		this.raqam = raqam;
		this.juzzar = juzzar;
	}
	public int getRaqam() {
		return raqam;
	}
	public void setRaqam(int raqam) {
		this.raqam = raqam;
	}
	public String getJuzzar() {
		return juzzar;
	}
	public void setJuzzar(String juzzar) {
		this.juzzar = juzzar;
	}
	
}
