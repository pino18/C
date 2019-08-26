
package gestorAplicacion.users;
import java.util.*;

import BaseDatos.Data;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.documents.Recibo;

public class Paciente extends User{//Usuario de tipo paciente
	private Acompaniante Acompaniante;
	
	public Paciente(){
		super();
	}
	
	public Paciente(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);//Constructor con todos los parametros necesarios los cuales corresponden a las credenciales del usuario, ademas guarda los usuarios en la tabla hash users de la clase Data
		Data.users.put(username, this);
	}
	
	
	public Acompaniante getAcompaniante() {//Accede y retorna el acompañante ligado a el paciente en cuestión
		return Acompaniante;
	}
	public void SetAcompaniante(Acompaniante Acompaniante) {//Asigna un acompañante a el paciente en cuestión
		this.Acompaniante=Acompaniante;
	}
	public void setAcompaniante(Acompaniante Acompaniante) {
		this.Acompaniante = Acompaniante;
	}
	// Fin Setters and Getters

}