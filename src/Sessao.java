import java.util.Date;

public class Sessao {
	
	private int codigoSessao;

	private Sala sala;
	
	private Filme filme;
	
	private String horario;
	
	public Sessao() {}
	
	public Sessao(int codigoSessao, Sala sala, Filme filme, String horario) {
		this.sala = new Sala();
        zeraSala(sala);
		this.filme = filme;
		this.horario = horario;
		this.codigoSessao = codigoSessao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public int getCodigoSessao() {
		return codigoSessao;
	}

	public void setCodigoSessao(int codigoSessao) {
		this.codigoSessao = codigoSessao;
	}
	
	public void zeraSala(Sala sala) {
        this.sala.setCodigoSala(sala.getCodigoSala());
        this.sala.criaLugares(sala.getLugares().length, sala.getLugares()[0].length);
        this.sala.setNumLugares(sala.getNumLugares());
        this.sala.setTipoSala(sala.getTipoSala());
    }
	
}