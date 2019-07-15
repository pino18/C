package gestorAplicación.personas;

public abstract class Persona {
	private String identificacion;
	private String nombre_completo;
	private int edad;
	private String telefono;
	private String sexo;
	
	//Setters and Getters
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	// Fin Setters and Getters
	
}

class Acompañante extends Persona {
	private String parentezco;
	private Paciente paciente;
	
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
