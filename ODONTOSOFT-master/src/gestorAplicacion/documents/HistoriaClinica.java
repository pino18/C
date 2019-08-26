package gestorAplicacion.documents;

import BaseDatos.Data;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;

public class HistoriaClinica {//Clase historia clinica, guarda información de el usuario tal que las citas realizadas, información,etc.
	private String ID;
	private Paciente Paciente;
	private int NroCitasRealizadas;
	private String Informacion;
	
	
	public HistoriaClinica(String Id, Paciente P,int NCR,String I) {//Asigna los valores correspondientes a la historia clinica en cuestión y la guarda en la tabla hash historias de la clase Data
		ID=Id;
		Paciente=P;
		NroCitasRealizadas=NCR;
		Informacion=I;
		Data.historias.put(Id,this);
	}
	public HistoriaClinica(String Id, String username,int NCR,String I) {//Asigna los valores correspondientes a la historia clinica cuando se ingresa el username del paciente en cuestión y la guarda en la tabla hash historias de la clase Data
		ID=Id;
		Paciente=(Paciente) User.getUserByUsername(username);
		NroCitasRealizadas=NCR;
		Informacion=I;
		Data.historias.put(Id,this);
	}
	
	public void AddNroCitasRealizadas() {//toma el numero de citas y le suma uno
		this.NroCitasRealizadas = this.NroCitasRealizadas+1;
	}
	public void setInformacionNueva(String informacion) {//Edita la información de la historia clinica concatenando los valores que ya estaban
		this.Informacion += informacion;
	}
	public String getID() {//Accede y retorna el ID de la historia
		return ID;
	}
	public void setID(String iD) {//Asigna un ID a la historia
		ID = iD;
	}
	public Paciente getPaciente() {//Accede y retorna el paciente ligado a la historia clinica
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {//Enserio tengo que explicar que hace esto?
		this.Paciente = paciente;
	}
	public String getInformacion() {//Accede y retorna la información de la historia clinica
		return Informacion;
	}
	public void setInformacion(String informacion) {////Edita la información de la historia clinica borrando los valores que ya estaban
		this.Informacion = informacion;
	}
	public int getNroCitasRealizadas() {//Accede y retorna el numero de citas asignada a una historia clinica
		return NroCitasRealizadas;
	}
	public void setNroCitasRealizadas(int NCR) {//Asigna un numero de citas a la historia clinica
		this.NroCitasRealizadas = NCR;
	}
}



