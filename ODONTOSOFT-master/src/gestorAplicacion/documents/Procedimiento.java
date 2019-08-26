package gestorAplicacion.documents;
import BaseDatos.Data;
public class Procedimiento {//Clase procedimiento, se guarda el tipo y el valor de cada procedimiento que se realizará en una cita, los cuales se guardan como atributos
	
	private String Tipo;
	private int valor;
	
	public Procedimiento(String t,int v) {//Constructor encargado de asignar valor a el tipo y valor(Costo) del procedimiento, y a su vez almacenarlo en la tabla hash procedimientos que se encuentra en la clase Data
		Tipo=t;
		valor=v;
		Data.proced.put(t, this);
	}
	
	public String getTipo() {//Accede al tipo de procedimiento que se realizará en la cita
		return Tipo;
	}
	public void setTipo(String tipo) {//Asigna el tipo de procedimiento que se realizará en la cita
		this.Tipo = tipo;
	}
	public int getValor() {//Accede y retorna el valor de el procedimiento el cual se realizará (Precio en Pesos Colombianos)
		return valor;
	}
	public void setValor(int valor) {//asigna el costo de el procedimiento el cual se realizará (Precio en Pesos Colombianos)
		this.valor = valor;
	}
	// Fin Setters and Getters
}
