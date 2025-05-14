package Modelo;

public class Transaccion {
	
	private String movimiento,metodopago,importe, notas,  usuario, Categoria;
	
	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public String getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Transaccion(String movimiento, String metodopago, String importe, String notas, String usuario,
			String categoria) {
		super();
		this.movimiento = movimiento;
		this.metodopago = metodopago;
		this.importe = importe;
		this.notas = notas;
		this.usuario = usuario;
		Categoria = categoria;
	}

	

}
