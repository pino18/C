package gestorAplicación.documents;

public class Seguimiento {
	
	
	
	private String Duracion;
	private String Tratamiento;
	private Cita UltimaCita;


	
	public String getDuracion() {
		return Duracion;
	}
	public void setDuracion(String duracion) {
		Duracion = duracion;
	}
	public String getTratamiento() {
		return Tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		Tratamiento = tratamiento;
	}
	public Cita getUltimaCita() {
		return UltimaCita;
	}
	public void setUltimaCita(Cita ultimaCita) {
		UltimaCita = ultimaCita;
	}
	// Fin Setters and Getters

}
