
public class Sala {
	private int codigoSala;
	
	private Cliente[][] lugares;
	
	private int tipoSala;
	
	private int numLugares;
	
	public Sala() {}

	public Sala(int codigoSala, Cliente[][] lugares, int tipoSala, int numLugares) {
		this.codigoSala = codigoSala;
		this.setLugares(lugares);
		this.tipoSala = tipoSala;
		this.numLugares = numLugares;
	}

	public int getCodigoSala() {
		return codigoSala;
	}

	public void setCodigoSala(int codigoSala) {
		this.codigoSala = codigoSala;
	}

	public int getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(int tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getNumLugares() {
		return numLugares;
	}

	public void setNumLugares(int numLugares) {
		this.numLugares = numLugares;
	}

	public Cliente[][] getLugares() {
		return lugares;
	}

	public void setLugares(Cliente[][] lugares) {
		this.lugares = lugares;
	}
	
	public boolean verificaLugar (int fileira, int poltrona) {
		
		if(this.lugares[fileira][poltrona] == null ) {
			return true;
		}
		
		return false;
	}
	
	public void criaLugares(int linhas, int colunas) {
        this.lugares = new Cliente[linhas][colunas];
    }
	
	@Override
    public String toString() {

        System.out.print(" ");
        for(int i = 0; i < lugares[0].length; i++) {
            if (i<10) {
                System.out.print("    0" + i);
            } else {
                System.out.print("    "+ i);
            }
        }
        System.out.println();

        for(int i = 0; i < lugares.length; i++) {
            if (i<10) {
                System.out.print("0" + i + " ");
            } else {
                System.out.print(i + " ");
            }

            for(int j = 0; j < lugares[i].length; j++) {
                if (lugares[i][j] != null) {
                    System.out.print("[ XX ]");
                } else {
                    System.out.print("[    ]");
                }
            }
            System.out.println();
        }

        return null;
    }
}
