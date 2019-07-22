package gestorAplicacion.users;
import java.util.*;

import BaseDatos.Data;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.documents.Recibo;

public class Paciente extends User{
	private Acompaniante Acompaniante;
	
	public Paciente(){
		super();
	}
	
	public Paciente(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);
		Data.users.put(username, this);
	}
	
	
	public Acompaniante getAcompaniante() {
		return Acompaniante;
	}
	public void SetAcompaniante(Acompaniante Acompaniante) {
		this.Acompaniante=Acompaniante;
	}
	public void setAcompaniante(Acompaniante Acompaniante) {
		this.Acompaniante = Acompaniante;
	}
	
	// Fin Setters and Getters
	
/*
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
		
		
	}*/
}
