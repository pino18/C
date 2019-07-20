package gestorAplicacion.users;

import java.util.ArrayList;
import java.util.HashMap;

import BaseDatos.Data;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Main;
import gestorAplicacion.users.Acompaniante;

public class User extends Persona {
	
	private String username;
	private String email;
	private String password;
	private MenuDeConsola menu;
	
	public User() {
	}
	
	protected User(String username, MenuDeConsola menu) {
		this.username = username;
		this.menu = menu;
		Data.users.put(username, this);
	}

	public User(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo);
		this.username = username;
		this.email = email;
		this.password = password;
		Data.users.put(username, this);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public MenuDeConsola getMenu() {
		return menu;
	}

	public void setMenu(MenuDeConsola menu) {
		this.menu = menu;
	}
	
	public static String newUser(User user, String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password){
		//Validaciones de cada parametro
		user.setIdentificacion(identificacion);
		user.setFullname(fullname);
		user.setEdad(edad);
		user.setTelefono(telefono);
		user.setSexo(sexo);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		//Menu por defecto al crear un nuevo usuario
		if (user instanceof Paciente) {
			//Agregar las opciones del menu de paciente (operations.add("#"))
			String [] operations = {"6","7","8","9","10","12"};
			MenuDeConsola.newMenu(user, operations);
			Data.users.put(username,user);
			return "Ha sido creado";
		}
		else if (user instanceof Acompaniante) {
			//agregar las opciones del menu de acompaÃ±ante (operations.add("#"))
			String [] operations = {"10","12"};
			MenuDeConsola.newMenu(user, operations);
			Data.users.put(username,user);
			return "Ha sido creado";
		}
		else if (user instanceof Empleado) {
			//agregar las opciones del menu de empleado (operations.add("#"))
			String [] operations = {"11","12"};
			MenuDeConsola.newMenu(user, operations);
			Data.users.put(username,user);
			return "Ha sido creado";
		}
		return"";
	}
	
	public static String editUser(User u,int option, String value){
		switch (option) {
		case 1:	
			u.setFullname(value);
			return "Nombre modificado";
		case 2:
			u.setPassword(value);
			return "ContraseÃ±a modificada";
		default:
			return "Opcion no valida";
		}
	}
	
	public static String deleteUser(String username){
		Data.users.remove(username);
		return "Ha sido eliminado";
	}
	
	public static User getUserByUsername(String username){
        return Data.users.get(username);
    }
	
	public HashMap<String, User> getUsers(){
		return Data.users;
	}
	
    public static String login(String username, String password){
        User u = User.getUserByUsername(username);
        if (u != null){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
            	//Seteo el usuario
            	Main.user = u;
            	String bienvenido="";
            	if (u instanceof Acompaniante) {bienvenido=u.getFullname()+"  (AcompaÃ±ante) de "+ ((Acompaniante) u).getPaciente().getFullname();}
            	else if (u instanceof Paciente) {bienvenido=u.getFullname()+"  (Paciente)";}
            	else if (u instanceof AdminUser) {bienvenido=u.getFullname()+"  (Admin)";}
            	else if (u instanceof Empleado) {bienvenido=u.getFullname()+"  (Empleado)";}
            	else {bienvenido=u.getFullname()+"  (Invitado)";}
                return "Bienvenido "+bienvenido;
            }
        }
        return "Usuario no encontrado";
    }
    
    public static String signOut(){
    	Main.user = getUserByUsername("default");
        return "Adios";
    }
    
	
	public String editMyUser(int option, String value){
		switch (option) {
		case 1:	
			this.setFullname(value);
			return "Nombre modificado";
		case 2:
			this.setPassword(value);
			return "Contraseña modificada";
		default:
			return "Opcion no valida";
		}
	}
	
}

