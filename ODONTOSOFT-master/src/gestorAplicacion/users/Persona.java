package gestorAplicacion.users;

public abstract class Persona{//Clase abstracta persona, la cual tiene los atributos que deben tener todas las clases de este tipo
	private String identificacion;
	private String fullname;
	private String edad;
	private String telefono;
	private String sexo;
	
	public Persona (){
	}
	
	public Persona(String identificacion, String fullname, String edad, String telefono, String sexo) {//Constructor persona el cual asigna los valores correspondientes a cada atributo
		this.identificacion=identificacion;
		this.fullname=fullname;
		this.edad=edad;
		this.telefono=telefono;
		this.sexo=sexo;
	}
	//Setters and Getters
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}	
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
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
