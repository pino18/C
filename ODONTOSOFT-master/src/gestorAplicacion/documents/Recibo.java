package gestorAplicacion.documents;
import java.util.*;

import BaseDatos.Data;

public class Recibo {//Clase recibo, tien los atributos ID, Estado y Procedimiento(ID es unico)
	private String ID;
	private String Estado;
	private Procedimiento procedimiento;
	
	public Recibo(String i,String e, Procedimiento p) {//Constructor cuyos parametros son la informaci�n del recibo, ademas guarda el recibo en la tabla hash reci de la clase Data
		ID=i;
		Estado=e;
		procedimiento=p;
		Data.reci.put(i, this);
	}
//Gets acceden y retornan la informaci�n en cuesti�n
//Sets asignan el valor ingresado como parametro al atributo en cuesti�n
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	public static String GenNroRecibo() {//genera un numero de recibo de 5 digitos el cual sirve para diferenciar recibos
		 String N = Integer.toString((int)(Math.random()*99999 + 1));
		 if(!Data.citasByN.containsKey(N)) {
			 return N;
		 }
		 return null;
	}
}
