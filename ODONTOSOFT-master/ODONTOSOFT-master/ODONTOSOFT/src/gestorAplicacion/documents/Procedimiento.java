package gestorAplicacion.documents;


import BaseDatos.Data;

public class Procedimiento {
	
	private String Tipo;
	private int valor;
	
	public Procedimiento(String t,int v) {
		Tipo=t;
		valor=v;
		Data.proced.put(t, this);
	}
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		this.Tipo = tipo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	// Fin Setters and Getters
}
