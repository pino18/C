package gestorAplicacion.users;
import java.util.*;

import BaseDatos.Data;

public class Empleado extends User{

	private String contrato;
	private String cargo;
	private int sueldo;
	private String horario;
	
	public Empleado(){
		super();
	}
	
	public Empleado(String contrato, String cargo, int sueldo, String horario) {//Constructor que asigna los parametros que corresponden a cada atributo
		this.contrato=contrato;
		this.cargo=cargo;
		this.sueldo=sueldo ;
		this.horario=horario;
	}
	
	public Empleado(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);//Constructor que recibe los parametros e ingresa el usuario de tipo empleado a la tabla hash users de la clase Data
		Data.users.put(username, this);
	}
	
//Setters and getters
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
