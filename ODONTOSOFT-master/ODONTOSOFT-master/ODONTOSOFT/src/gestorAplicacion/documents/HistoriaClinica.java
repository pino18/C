package gestorAplicacion.documents;

import BaseDatos.Data;
import gestorAplicacion.users.Paciente;

public class HistoriaClinica {
	private String ID;
	private Paciente Paciente;
	private int NroCitasRealizadas;
	private String Informacion;
	
	
	public HistoriaClinica(String Id, Paciente P,int NCR,String I) {
		ID=Id;
		Paciente=P;
		NroCitasRealizadas=NCR;
		Informacion=I;
		Data.historias.put(Id,this);
	}
	
	

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Paciente getPaciente() {
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.Paciente = paciente;
	}
	public String getInformacion() {
		return Informacion;
	}
	public void setInformacion(String informacion) {
		this.Informacion = informacion;
	}
	public void setInformacionNueva(String informacion) {
		this.Informacion += informacion ;
	}
	public int getNroCitasRealizadas() {
		return NroCitasRealizadas;
	}
	public void setNroCitasRealizadas(int NCR) {
		this.NroCitasRealizadas = NCR;
	}
}

