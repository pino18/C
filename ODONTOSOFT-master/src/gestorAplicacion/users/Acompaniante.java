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
		Data.users.put(username, this);//Añade los usuarios de tipo acompañante a la Tabla Hash users definida en la clase Data
	}
	
	//Setters and Getters
	public String getParentezco() {//Accede al parentezco del usuario de tipo acompañante y el usuario de tipo paciente ligado a dicho acompañante
		return parentezco;
	}
	public void setParentezco(String parentezco) {//Asigna el parentezco entre el usuario de tipo acompañante y el usuario de tipo paciente ligado a dicho acompañante
		this.parentezco = parentezco;
	}
	public Paciente getPaciente() {//Accede al paciente ligado al usuario de tipo paciente
		return paciente;
	}
	public void setPaciente(Paciente paciente) {//Liga un paciente que es ingresado como paramentro al acompañante en cuestión
		this.paciente = paciente;
	}
	// Fin Setters and Getters
}
