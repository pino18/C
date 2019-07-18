package gestorAplicacion.users;

import BaseDatos.Data;
import uiMain.MenuDeConsola;


public class AdminUser extends User{
	
	AdminUser(){
		super();
	}
	
	public AdminUser(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password) {
		super(identificacion, fullname, edad, telefono, sexo, username, email, password);
		Data.users.put(username, this);
	}
	
	public static String newAdminUser(String identificacion, String fullname, String edad, String telefono, String sexo, String username, String email, String password){
		AdminUser user = new AdminUser();
		//Validaciones de cada parametro
		user.setIdentificacion(identificacion);
		user.setFullname(fullname);
		user.setEdad(edad);
		user.setTelefono(telefono);
		user.setSexo(sexo);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		
		//Menu por defecto al crear un nuevo usuario administrador
		String [] operations = {"1","2","3","4","5"};
		MenuDeConsola.newMenu(user, operations);
		Data.users.put(username,user);
		return "Ha sido creado";
	}
}
