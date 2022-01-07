import java.util.ArrayList;

public class Filme {
	
	private int codigo, anoLancamento, codAtendente;
	
	private String titulo, sinopse, genero;
	
	private String elenco [];
	
	private boolean emCartaz;
	
	public Filme() {}
	
	public Filme(int codigo, String titulo, String[] elenco, int anoLancamento, String sinopse, String genero, int codAtendente) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.elenco = elenco;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.genero = genero;
		this.setEmCartaz(false);
		this.codAtendente = codAtendente;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String[] getElenco() {
		return elenco;
	}

	public void setElenco(String elenco[]) {
		this.elenco = elenco;
	}
	
	public void verificaCartaz(ArrayList<Sessao> sessoes) {
		
		int f = 0;
		
		for(Sessao a : sessoes) {
			if(a.getFilme().getCodigo() == this.codigo) {
				f = 1;
				this.setEmCartaz(true);
			}
		}
		if(f == 0) {
			this.setEmCartaz(false);
		}
	}

	public boolean isEmCartaz() {
		return emCartaz;
	}

	public void setEmCartaz(boolean emCartaz) {
		this.emCartaz = emCartaz;
	}

	public int getCodAtendente() {
		return codAtendente;
	}

	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
	}
	
}
