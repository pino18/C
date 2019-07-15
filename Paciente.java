package gestorAplicaci�n.personas;
import java.util.*;
import gestorAplicaci�n.documents.*;
public class Paciente extends Persona {
	private Acompa�ante acompa�ante;
	private HistoriaClinica historia;
	public static Vector<HistoriaClinica>pacientes=new Vector<>();
	
	
	
	public Acompa�ante getAcompa�ante() {
		return acompa�ante;
	}
	public void setAcompa�ante(Acompa�ante acompa�ante) {
		this.acompa�ante = acompa�ante;
	}
	public HistoriaClinica getHistoria() {
		return historia;
	}
	public void setHistoria(HistoriaClinica historia) {
		this.historia = historia;
	}
	// Fin Setters and Getters
	
	
	
	public void SolicitarCita(Empleado emp, String fe, String h) {
		if (emp.getCargo()=="medico") {
			if(emp.verificardisponible(fe, h)==true) {
				emp.citasasignadas.add(fe+" "+h);
				new Cita(emp,fe,h);
			}
		}
	}
	public boolean RetirarEPS(HistoriaClinica h) {
		boolean r;
		if (h.equals(this.historia)) {
			r=true;
		}
		else {
			r=false;	
		}
		return r;
	}
	public String ConsultarHistoria() {
		return this.historia.getInformacion();
	}
	public boolean cambiarhorario(Cita c, String nfe, String nh){
		return(c.cambiarhora(nfe,nh));		
	}
	public void CancelarCita(Cita c) {
		c.finalize();			
	}
	public boolean PagarRecibo(Recibo r,int monto) {
		return(r.pagar(monto));
		
		
	}
}

