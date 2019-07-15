package gestorAplicación.documents;
import gestorAplicación.personas.*;

public class HistoriaClinica {
	
	
	
	private String ID;
	private Paciente paciente;
	private String informacion;
	

	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
}

