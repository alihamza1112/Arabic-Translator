package transferObject;

public class MashqoolTransferObjects {
	private int raqm;
	private String mashqool;
	private String juzar;
	private String germashqool;
	private String sinf;
	private String asal;
	private String jins;
	private String adad;
	private String gerasal;
	private String meaning;
	public MashqoolTransferObjects()
	{
		this.raqm = 0;
		this.mashqool="";
		this.juzar="";
		this.germashqool="";
		this.sinf = "";
		this.asal = "";
		this.jins = "";
		this.adad = "";
		this.gerasal="";
		this.meaning = "";
	}
	public MashqoolTransferObjects(int raqm,String mashqool, String juzar,String gairmashkol,String sinf, String asal, String jins, String adad,String gairasal, String meaning) {
		super();
		this.raqm = raqm;
		this.mashqool = mashqool;
		this.juzar=juzar;
		this.germashqool=gairmashkol;
		this.sinf = sinf;
		this.asal = asal;
		this.jins = jins;
		this.adad = adad;
		this.gerasal=gairasal;
		this.meaning = meaning;
	}
	public int getRaqm() {
		return raqm;
	}
	public void setRaqm(int raqm) {
		this.raqm = raqm;
	}
	public void setMashqool(String mashqool) {
		this.mashqool = mashqool;	
	}
	public String getMashqool() {
		return mashqool;
	}
	public String getJuzar() {
		return juzar;
	}
	public void setJuzar(String juzar) {
		this.juzar = juzar;
	}
	public String getGermashqool() {
		return germashqool;
	}
	public void setGermashqool(String germashqool) {
		this.germashqool = germashqool;
	}
	public String getSinf() {
		return sinf;
	}
	public void setSinf(String sinf) {
		this.sinf = sinf;
	}
	public String getAsal() {
		return asal;
	}
	public void setAsal(String asal) {
		this.asal = asal;
	}
	public String getJins() {
		return jins;
	}
	public void setJins(String jins) {
		this.jins = jins;
	}
	public String getAdad() {
		return adad;
	}
	public void setAdad(String adad) {
		this.adad = adad;
	}
	public String getGerasal() {
		return gerasal;
	}
	public void setGerasal(String gerasal) {
		this.gerasal = gerasal;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	
	
}
