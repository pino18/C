package gestorAplicación.documents;
import gestorAplicación.personas.*;
import java.util.HashMap;
public class Cita {
	
	
	
	private String NroCita;
	private String Fecha;
	private String Hora;
	private String Lugar;
	private Paciente Paciente;
	private String TipoConsulta;
	private String Estado;
	private Procedimiento Procedimiento;
	private Seguimiento Seguimiento;
	private Empleado Empleado;
	
	
	
	
	public Cita(Empleado emp, String fe, String h){
		this.Empleado=emp;
		this.Fecha=fe;
		this.Hora=h;
	}
	
	

	public String getNroCita() {
		return NroCita;
	}
	public void setNroCita(String nroCita) {
		NroCita = nroCita;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	public String getLugar() {
		return Lugar;
	}
	public void setLugar(String lugar) {
		Lugar = lugar;
	}
	public Paciente getPaciente() {
		return Paciente;
	}
	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}
	public String getTipoConsulta() {
		return TipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		TipoConsulta = tipoConsulta;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Procedimiento getProcedimiento() {
		return Procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		Procedimiento = procedimiento;
	}
	public Seguimiento getSeguimiento() {
		return Seguimiento;
	}
	public void setSeguimiento(Seguimiento seguimiento) {
		Seguimiento = seguimiento;
	}
	public Empleado getEmpleado() {
		return Empleado;
	}
	public void setEmpleado(Empleado empleado) {
		Empleado = empleado;
	}
	//Fin Setters and Getters
	
	
	public boolean cambiarhora(String nfe, String nh) {
		boolean r = false;
		String nf=nfe+" "+nh;
		if(this.Empleado.citasasignadas.contains(nf)==true) {
			r=false;
		}
		else if(this.Empleado.citasasignadas.contains(nf)==false) {
			this.Empleado.citasasignadas.remove(this.Fecha+" "+this.Hora);
			this.Fecha=nfe;
			this.Hora=nh;
			this.Empleado.citasasignadas.add(nf);
			r=true;
		}
		return r;
		
	}
	public void finalize() {
		this.Empleado.citasasignadas.remove(this.Fecha+" "+this.Hora);
		
	}

	
}