package gestorAplicacion.documents;

import java.util.HashMap;

import BaseDatos.Data;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;

public class Cita {//Clase cita, tiene los atributos necesarios para poder hacer creación de citas las cuales serán solicitadas por un pacientes o modificadas por un empleado
	private String NroCita;
	private String Fecha;
	private String Hora;
	private String Lugar;
	private Paciente Paciente;
	private String TipoConsulta;
	private String Estado;
	private Procedimiento Procedimiento;
	private String Empleado;

	public Cita(String NC, String F, String H, String L, Paciente PA, String TC, String ES, Procedimiento PRO, String EMP){//Constructor con todos los parametros, agrega las citas a la tabla hash citas que está en la clase Data
		NroCita = NC;
		Fecha = F;
		Hora = H;
		Lugar = L;
		Paciente = PA;
		TipoConsulta = TC;
		Estado = ES;
		Procedimiento = PRO;
		Empleado = EMP;
		Data.citas.put(F+H,this);
		Data.citasByN.put(NC,this);
	}
	public static String GenNroCita() {//Genera un numero de cita aleatorio de 5 cifras el cual servirá como ID para cada cita creada y registrada en el sistema
		 String N = Integer.toString((int)(Math.random()*99999 + 1));
		 if(!Data.citasByN.containsKey(N)) {
			 return N;
		 }
		 return null;
	}
	
	
	public String getNroCita() {//Retorna el numero de la cita
		return NroCita;
	}

	public void setNroCita(String nroCita) {//Asigna un valor al numero de cita
		NroCita = nroCita;
	}

	public String getFecha() {//Accede a la fecha de la cita en cuestión  y la retorne en formato (DD/MM/AAAA)
		return Fecha;
	}

	public void setFecha(String fecha) {//Asigna una fecha a la cita en formato (DD/MM/AAAA)
		Fecha = fecha;
	}

	public String getHora() {//Accede a la hora de la cita y la retorna como un string en formato (HH:MM) 24H
		return Hora;
	}

	public void setHora(String hora) { //Asigna una hora a la cita en cuestión en formato (HH:MM) 24H
		Hora = hora;
	}

	public String getLugar() {//Accede a la sede en la cual se realizará la cita 
		return Lugar;
	}

	public void setLugar(String lugar) {//Asigna una sede para que se realice la cita
		Lugar = lugar;
	}

	public Paciente getPaciente() {//Accede y retorna el paciente al cual se le realizará la cita
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {//Asigna un paciente para la cita agendada a una fecha y una hora
		Paciente = paciente;
	}

	public String getTipoConsulta() {//Retorna el tipo de consulta que se va a realizar ya sea general o prioritaria
		return TipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {//Asigna un tipo de consulta ya sea general o prioritaria
		TipoConsulta = tipoConsulta;
	}

	public String getEstado() {//Retorna el estado en el que se encuentra la cita, ya sea realizada o pendiente
		return Estado;
	}

	public void setEstado(String estado) {//Asigna un estado a la cita en cuestión ya sea pendiente en caso de no haberse realizado o realizada en caso contrario
		Estado = estado;
	}

	public Procedimiento getProcedimiento() {//Acede y retorna el tipo de procedimiento que se dará a cabo en la cita
		return Procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {//Asigna el procedimiento que se realizará en la cita
		Procedimiento = procedimiento;
	}

	public String getEmpleado() {//Accede y retorna el empleado que se encargará de realizar la cita dependiendo el horario
		return Empleado;
	}

	public void setEmpleado(String empleado) {//Asigna el empleado que realizará la cita, basado en el horario de la misma
		Empleado = empleado;
	}
	// Fin Setters and Getters
}
