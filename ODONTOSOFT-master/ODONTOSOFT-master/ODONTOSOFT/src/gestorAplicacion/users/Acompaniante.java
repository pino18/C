package gestorAplicacion.users;

import BaseDatos.Data;

public class Acompaniante extends User {
	private String parentezco;
	private Paciente paciente;
	
	public Acompaniante (String usurpa, String parentezco) {
		paciente=(Paciente)User.getUserByUsername(usurpa);
		this.parentezco=parentezco;
		
	}
	
	public Acompaniante(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);
		Data.users.put(username, this);
	}
	
	//Setters and Getters
	public String getParentezco() {
		return parentezco;
	}
	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	// Fin Setters and Getters
}
