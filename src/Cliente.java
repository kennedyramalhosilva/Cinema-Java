
public class Cliente extends Pessoa{
	
	private int codigoCliente;
	
	private double valorPago;
	
	public Cliente() {}
	
	public Cliente(int codigo, String nome, double valor) {
		super();
		this.codigoCliente = codigo;
		this.nome = nome;
		this.valorPago = valor;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}
