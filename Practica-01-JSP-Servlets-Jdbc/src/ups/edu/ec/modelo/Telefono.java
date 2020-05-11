package ups.edu.ec.modelo;

import java.io.Serializable;



public class Telefono implements Serializable{

	private static final long serialVersionUID=1L;
	private int id;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario usuario;
	
	public Telefono() {
	
	}
	public Telefono(String numero, String tipo, String operadora) {
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario=" + usuario + "]";
	}
	
}
