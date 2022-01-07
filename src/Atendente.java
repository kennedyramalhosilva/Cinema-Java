
public class Atendente extends Pessoa {
	
	private int codigoAtendente;
	
	public Atendente() {}
	
	public Atendente(int codigoAtendente, String nome) {
		super();
		this.codigoAtendente = codigoAtendente;
		this.nome = nome;
	}
	
	public int getCodigoAtendente() {
		return codigoAtendente;
	}

	public void setCodigoAtendente(int codigoAtendente) {
		this.codigoAtendente = codigoAtendente;
	}
}
